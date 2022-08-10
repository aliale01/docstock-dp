package com.alex.repo.mapper;

import com.alex.repo.dto.CategoryDTO;
import com.alex.repo.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

    List<CategoryDTO> categoryToCategoryDTOList(List<Category> categoryList);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);
}
