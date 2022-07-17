package com.alex.repo.service;

import com.alex.repo.dto.FileDto;
import com.alex.repo.models.File;
import org.springframework.stereotype.Service;

public interface FileService {

    File getFile(Long id);

    File saveFile(FileDto dto);

}
