package com.finance.financesystem.service;

import com.finance.financesystem.dto.CategoryDto;

import java.util.List;

public interface CategoryService {


    List<CategoryDto> getAllCategory();

    CategoryDto getByIdCategory(Long id);

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto deleteByIdCategory(Long id);


}
