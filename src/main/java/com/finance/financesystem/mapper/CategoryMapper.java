package com.finance.financesystem.mapper;

import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.entity.Category;

import java.util.ArrayList;
import java.util.List;

public final class CategoryMapper {

    private CategoryMapper(){
    }
    
    //Convierte un objeto CategoryDto a Category
    public static Category toEntity(CategoryDto categoryDto) {

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setType(categoryDto.getType());
        category.setDescription(categoryDto.getDescription());
        category.setColor(categoryDto.getColor());
        category.setIcon(categoryDto.getIcon());
        category.setStatus(categoryDto.getStatus());

        return category;
    }

    //Convierte un objeto Category a CategoryDto
    public static CategoryDto toDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setType(category.getType());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setColor(category.getColor());
        categoryDto.setIcon(category.getIcon());
        categoryDto.setStatus(category.getStatus());

        return categoryDto;
    }

    public static List<CategoryDto> toListDto(List<Category> categories){
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for(Category category : categories){
            categoryDtoList.add(toDto(category));
        }
        return categoryDtoList;
    }

    public static List<Category> toListEntity(List<CategoryDto> categoryDtoList){
        List<Category> categories = new ArrayList<>();
        for (CategoryDto categoryDto : categoryDtoList){
            categories.add(toEntity(categoryDto));
        }
        return categories;
    }


}
