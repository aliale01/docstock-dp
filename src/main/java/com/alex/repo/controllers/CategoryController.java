package com.alex.repo.controllers;

import com.alex.repo.models.Category;
import com.alex.repo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = CategoryController.BASE_URL)
public class CategoryController {

    public static final String BASE_URL = ServiceAPIUrl.VERSION_PATH + "/categories";

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> get() {
        return categoryService.get();
    }

    @GetMapping(value = "/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public Category create(@Valid @RequestBody Category category) {
        return categoryService.create(category);
    }

    @PutMapping
    public Category update(@Valid @RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
