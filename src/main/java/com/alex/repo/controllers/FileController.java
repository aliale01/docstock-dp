package com.alex.repo.controllers;

import com.alex.repo.dto.FileDTO;
import com.alex.repo.mapper.FileMapper;
import com.alex.repo.models.File;
import com.alex.repo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.transform.OutputKeys;
import java.util.List;

@RestController
@RequestMapping(value = FileController.BASE_URL)
public class FileController {

    public static final String BASE_URL = ServiceAPIUrl.VERSION_PATH + "/files";

    @Autowired
    private FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileDTO>> get() {
        List<File> getFileList = fileService.get();
        List<FileDTO> responseList = FileMapper.INSTANCE.fileToFileDTOList(getFileList);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
        //return fileService.get();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FileDTO> getById(@PathVariable Long id) {
        File getFile = fileService.getById(id);
        FileDTO responseFile = FileMapper.INSTANCE.fileToFileDTO(getFile);
        return new ResponseEntity<>(responseFile,HttpStatus.OK);
        //return fileService.getById(id);
    }

    @PostMapping
    public ResponseEntity<FileDTO> create(@Valid @RequestBody FileDTO fileDTO) {
        File requestFile = FileMapper.INSTANCE.fileDTOToFile(fileDTO);
        File createFile = fileService.create(requestFile);
        FileDTO responseFile = FileMapper.INSTANCE.fileToFileDTO(createFile);
        return new ResponseEntity<>(responseFile,HttpStatus.CREATED);
        //return fileService.create(file);
    }

    @PutMapping
    public ResponseEntity<FileDTO> update(@Valid @RequestBody FileDTO fileDTO) {
        File requestFile = FileMapper.INSTANCE.fileDTOToFile(fileDTO);
        File updateFile = fileService.update(requestFile);
        FileDTO responseFile = FileMapper.INSTANCE.fileToFileDTO(updateFile);
        return new ResponseEntity<>(responseFile, HttpStatus.OK);
        //return fileService.update(file);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        fileService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}