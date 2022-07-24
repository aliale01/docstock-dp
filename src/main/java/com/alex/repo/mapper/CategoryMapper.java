package com.alex.repo.mapper;

import com.alex.repo.dto.CategoryDTO;
import com.alex.repo.models.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO categoryToCategoryDTO(Category category);

    List<CategoryDTO> categoryToCategoryDTOList(List<Category> categoryList);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);
}
