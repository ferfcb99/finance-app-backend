package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.CategoryController;
import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.service.CategoryService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/category")

public class CategoryControllerImpl implements CategoryController {

    Logger logger = LoggerFactory.getLogger(AccountControllerImpl.class);

    private final CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    // metodo para obtener todos los registros
    @Override
    @GetMapping(value = "/get-all-category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        logger.info("Entro al metodo getAllCategory del controlador");
        List<CategoryDto> categoryDtoList = this.categoryService.getAllCategory();

        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryDtoList);
    }

    // metodo para obtener datos por id
    @Override
    @GetMapping(value = "/get-by-id-category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> getByIdCategory(@PathVariable Long id) {
        logger.info("Entro al metodo getByIdCategory del controlador");
        CategoryDto categoryById = this.categoryService.getByIdCategory(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryById);
    }
    // metodo para crear datos
    @Override
    @PostMapping(value = "/create-category", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        logger.info("Entro el metodo createCategory del controlador");
        CategoryDto categoryCreated = this.categoryService.createCategory(categoryDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryCreated);
    }

    // metodo para eliminar datos
    @Override
    @DeleteMapping(value = "/delete-by-id-category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> deleteByIdCategory(@PathVariable Long id) {
        logger.info("Entro al metodo deleteByIdCategory del controlador");
        CategoryDto categoryDelete = this.categoryService.deleteByIdCategory(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryDelete);
    }

}

