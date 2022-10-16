package com.alex.repo.service.impl;

import static com.alex.repo.service.impl.AsposeDocConvertor.PATH;
import static com.alex.repo.service.impl.AsposeDocConvertor.PDF;

import com.alex.repo.constants.APIServiceError;
import com.alex.repo.exception.APIExcepiton;
import com.alex.repo.models.CustomDocument;
import com.alex.repo.models.User;
import com.alex.repo.repositories.CustomDocumentRepository;
import com.alex.repo.service.CustomDocumentService;
import com.alex.repo.service.FileToPdfConvertor;
import com.alex.repo.service.UserService;
import com.alex.repo.util.AuthenticationFacade;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class CustomDocumentServiceImpl implements CustomDocumentService {

    private final CustomDocumentRepository customDocumentRepository;
    private final FileToPdfConvertor fileToPdfConvertor;
    private AuthenticationFacade authenticationFacade;
    private final UserService userService;


    @Override
    public List<CustomDocument> getAllDocuments(User user) {
        return user.getCustomDocuments();
    }

    @Override
    @Transactional
    public CustomDocument update(CustomDocument customDocument) {
        return customDocumentRepository.save(customDocument);
    }

    @Override
    @Transactional
    public CustomDocument create(CustomDocument customDocument) {
        return customDocumentRepository.save(customDocument);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomDocument getById(String id) {
        return customDocumentRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public void delete(String id) {
        customDocumentRepository.deleteById(id);
    }

    @Override
    public CustomDocument createDocument(MultipartFile file, String timestamp, String description, String convertedFileName, String username) {
        User user = userService.findByUserName(username);
        String contentType = file.getContentType();
        convertFile(file, convertedFileName, contentType, username);
        CustomDocument customDocument = CustomDocument.builder()
                                                      .originalFileName(file.getName())
                                                      .fileType(contentType)
                                                      .timestamp(timestamp)
                                                      .description(description)
                                                      .convertedFileName(convertedFileName)
                                                      .build();
        customDocument.addUser(user);
        userService.update(user);
        return customDocumentRepository.save(customDocument);
    }

    @Override
    public byte[] downloadFile(String id) {
        CustomDocument customDocument = customDocumentRepository.findById(id)
                                                                .orElseThrow(() -> new APIExcepiton(APIServiceError.DOCUMENT_NOT_FOUND));
        User user = authenticationFacade.getUser();
        boolean isAllowedDownloadFile = user.getCustomDocuments().stream().anyMatch(document -> document.getId().equals(id));

        if (isAllowedDownloadFile) {
            try {
                String convertedFileName = customDocument.getConvertedFileName();
                String path = PATH + user.getUsername() + "_" + convertedFileName + PDF;
                File file = new File(path);
                FileInputStream fileInputStream = new FileInputStream(file);
                return fileInputStream.readAllBytes();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new APIExcepiton(APIServiceError.USER_UNAUTHORIZED);
        }

    }

    private void convertFile(MultipartFile file, String convertedFileName, String contentType, String username) {
        try {
            fileToPdfConvertor.convert(file.getInputStream(), convertedFileName, contentType, username);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getNameById(String id) {
        CustomDocument customDocument = customDocumentRepository.findById(id)
                .orElseThrow(() -> new APIExcepiton(APIServiceError.DOCUMENT_NOT_FOUND));
        return customDocument.getConvertedFileName();
    }
}
