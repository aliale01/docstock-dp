package com.alex.repo.controllers;

import com.alex.repo.dto.CategoryDTO;
import com.alex.repo.mapper.CategoryMapper;
import com.alex.repo.models.Category;
import com.alex.repo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CategoryDTO>> get() {
        List<Category> categoryList = categoryService.get();
        List<CategoryDTO> responseList = CategoryMapper.INSTANCE.categoryToCategoryDTOList(categoryList);
        return new ResponseEntity<>(responseList,HttpStatus.OK);
        // return categoryService.get();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
        Category getCategory = categoryService.getById(id);
        CategoryDTO responseCategory =  CategoryMapper.INSTANCE.categoryToCategoryDTO(getCategory);
        return new ResponseEntity<>(responseCategory,HttpStatus.OK);
        //return categoryService.getById(id);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO categoryDTO) {
        //DTO to entity
        Category requestCategory = CategoryMapper.INSTANCE.categoryDTOToCategory(categoryDTO);
        //Post request
        Category createCategory = categoryService.create(requestCategory);
        //Entity to DTO
        CategoryDTO responseCategory = CategoryMapper.INSTANCE.categoryToCategoryDTO(createCategory);
        return new ResponseEntity<>(responseCategory, HttpStatus.CREATED);
        //return categoryService.create(category);
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> update(@Valid @RequestBody CategoryDTO categoryDTO) {
        Category requestCategory = CategoryMapper.INSTANCE.categoryDTOToCategory(categoryDTO);

        Category updateCategory = categoryService.update(requestCategory);

        CategoryDTO responceCategory = CategoryMapper.INSTANCE.categoryToCategoryDTO(updateCategory);
        return new ResponseEntity<>(responceCategory,HttpStatus.OK);
        //return categoryService.update(category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}