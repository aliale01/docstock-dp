package com.alex.repo.service.impl;

import com.alex.repo.dto.FileDto;
import com.alex.repo.models.File;
import com.alex.repo.models.User;
import com.alex.repo.repositories.FilesRepository;
import com.alex.repo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    public FilesRepository filesRepository;

    @Override
    public File getFile(Long id) {
        return null;
    }

    @Override
    public File saveFile(FileDto dto) {
        File file = new File();

        file.setName(dto.getName());
        file.setPath(dto.getPath());
        file.setDescription(dto.getDescription());
        file.setDateUpload(Timestamp.valueOf(dto.getDateUpload()));
        file.setDateUpdate(Timestamp.valueOf(dto.getDateUpdate()));
        file.setUser(new User(1L,"user", "pa$$word",null, null));

        return filesRepository.save(file);
    }
}
