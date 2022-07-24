package com.alex.repo.service.impl;

import com.alex.repo.models.File;
import com.alex.repo.repositories.FilesRepository;
import com.alex.repo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FilesRepository filesRepository;


    @Override
    @Transactional(readOnly = true)
    public List<File> get() {
        return filesRepository.findAll();
    }

    @Override
    @Transactional
    public File update(File file) {
        return filesRepository.save(file);
    }

    @Override
    @Transactional
    public File create(File file) {
        return filesRepository.save(file);
    }

    @Override
    @Transactional(readOnly = true)
    public File getById(Long id) {
        return filesRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        filesRepository.deleteById(id);
    }
}
