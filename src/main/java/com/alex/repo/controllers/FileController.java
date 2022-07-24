package com.alex.repo.controllers;

import com.alex.repo.models.File;
import com.alex.repo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = FileController.BASE_URL)
public class FileController {

    public static final String BASE_URL = ServiceAPIUrl.VERSION_PATH + "/files";

    @Autowired
    private FileService fileService;

    @GetMapping
    public List<File> get() {
        return fileService.get();
    }

    @GetMapping(value = "/{id}")
    public File getById(@PathVariable Long id) {
        return fileService.getById(id);
    }

    @PostMapping
    public File create(@Valid @RequestBody File file) {
        return fileService.create(file);
    }

    @PutMapping
    public File update(@Valid @RequestBody File file) {
        return fileService.update(file);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        fileService.delete(id);
    }
}