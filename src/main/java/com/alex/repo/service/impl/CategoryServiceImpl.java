package com.alex.repo.service.impl;

import com.alex.repo.models.Category;
import com.alex.repo.repositories.CategoryRepository;
import com.alex.repo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> get() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public Category getById(Long id) {
        return categoryRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
