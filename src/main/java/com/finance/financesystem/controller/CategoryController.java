package com.finance.financesystem.controller;


import com.finance.financesystem.dto.CategoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryController {

    ResponseEntity<List<CategoryDto>> getAllCategory();

    ResponseEntity<CategoryDto> getByIdCategory(Long id);

    ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto);
}
