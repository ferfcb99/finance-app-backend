package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.mapper.CategoryMapper;
import com.finance.financesystem.repository.CategoryRepository;
import com.finance.financesystem.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;

    }

    @Override
    public List<CategoryDto> getAllCategory() {
        logger.info("Entro el metodo getAllCategory del servicio");
        List<Category> category = this.categoryRepository.findAll();

        return CategoryMapper.toListDto(category);
        }



    @Override
    public CategoryDto getByIdCategory(Long id) {
        logger.info("Entro al metodo getByIdCategory del servicio ");
        Category categoryById = this.categoryRepository.findById(id).get();

        return CategoryMapper.toDto(categoryById);
    }

    //DTO a Entity
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        logger.info("Entro el metodo createCategory del servicio");
        Category categoryCreate = CategoryMapper.toEntity(categoryDto);

        categoryCreate.setId(null);
        categoryCreate.setCreatedAt(LocalDateTime.now());
        categoryCreate.setUpdatedAt(LocalDateTime.now());

        categoryCreate = this.categoryRepository.save(categoryCreate);

        return CategoryMapper.toDto(categoryCreate);
    }

    @Override
    public CategoryDto deleteByIdCategory(Long id) {
        logger.info("Entro el metodo deleteByIdCategory del servicio");

        Category categoryDeleted = this.categoryRepository.findById(id).get();

        this.categoryRepository.deleteById(id);

        return CategoryMapper.toDto(categoryDeleted);
    }
}
