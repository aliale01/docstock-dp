package com.alex.repo.service;

import com.alex.repo.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> get();

    Category update(Category category);

    Category create(Category category);

    Category getById(Long id);

    void delete(Long id);
}
