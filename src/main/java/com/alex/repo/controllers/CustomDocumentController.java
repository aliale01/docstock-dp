package com.alex.repo.controllers;

import com.alex.repo.constants.UrlMapping;
import com.alex.repo.dto.CustomDocumentDTO;
import com.alex.repo.exception.response.ResponseHolder;
import com.alex.repo.mapper.CustomDocumentMapper;
import com.alex.repo.models.CustomDocument;
import com.alex.repo.models.User;
import com.alex.repo.service.CustomDocumentService;
import com.alex.repo.util.AuthenticationFacade;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.TimeZone;

import com.aspose.cells.DateTime;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(UrlMapping.DOCUMENTS)
@AllArgsConstructor
public class CustomDocumentController {

    private final CustomDocumentService customDocumentService;
    private final AuthenticationFacade authenticationFacade;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @PostMapping(UrlMapping.UPLOAD)
    public ResponseHolder<String> upload(@RequestParam String description,
                                         @RequestParam String convertedFileName,
                                         @RequestParam MultipartFile file) {
        String username = authenticationFacade.getUsername();
        String timestamp = Instant.now().toString();
        CustomDocument document = customDocumentService.createDocument(file, timestamp, description, convertedFileName, username);
        return new ResponseHolder<>(document.getId());
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    public ResponseHolder<List<CustomDocumentDTO>> get() {
        User user = authenticationFacade.getUser();
        List<CustomDocument> getCustomDocumentList = customDocumentService.getAllDocuments(user);
        List<CustomDocumentDTO> responseList = CustomDocumentMapper.INSTANCE.map(getCustomDocumentList);
        return new ResponseHolder<>(responseList);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    public ResponseHolder<CustomDocumentDTO> getById(@PathVariable String id) {
        CustomDocument getCustomDocument = customDocumentService.getById(id);
        CustomDocumentDTO responseFile = CustomDocumentMapper.INSTANCE.map(getCustomDocument);
        return new ResponseHolder<>(responseFile);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(value = "/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        byte[] payload = customDocumentService.downloadFile(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=\"%s\"".formatted(customDocumentService.getNameById(id)));
        return ResponseEntity.ok()
                             .contentType(MediaType.APPLICATION_PDF)
                             .headers(headers)
                             .body(payload);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    public ResponseHolder<String> delete(@PathVariable String id) {
        customDocumentService.delete(id);
        return new ResponseHolder<>("OK");
    }
}