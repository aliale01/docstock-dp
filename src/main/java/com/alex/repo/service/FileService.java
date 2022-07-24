package com.alex.repo.service;

import com.alex.repo.dto.FileDTO;
import com.alex.repo.models.File;

import java.util.List;

public interface FileService {

    List<File> get();

    File update(File file);

    File create(File file);

    File getById(Long id);

    void delete(Long id);

}
