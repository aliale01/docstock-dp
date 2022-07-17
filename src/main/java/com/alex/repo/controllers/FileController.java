package com.alex.repo.controllers;

import com.alex.repo.dto.FileDto;
import com.alex.repo.models.File;
import com.alex.repo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping
    public ResponseEntity<File> saveFile(@RequestBody FileDto fileDto){
        File file = fileService.saveFile(fileDto);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}
