package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.CategoryController;
import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.service.CategoryService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/category")
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    @GetMapping(value = "/get-all-category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> categoryDtoList = this.categoryService.getAllCategory();

        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryDtoList);
    }

    @Override
    @GetMapping(value = "/get-by-id-category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> getByIdCategory(@PathVariable("id") Long id) {
        CategoryDto categoryDto = this.categoryService.getByIdCategory(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryDto);
    }
    @Override
    @PostMapping(value = "/create-category", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto categorySave = this.categoryService.createCategory(categoryDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(categorySave);
    }
}

