package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.entity.Category;
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
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for(Category category1 : category){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(category1.getId());
            categoryDto.setName(category1.getName());
            categoryDto.setType(category1.getType());
            categoryDto.setColor(category1.getColor());
            categoryDto.setIcon(category1.getIcon());
            categoryDto.setDescription(category1.getDescription());
            categoryDto.setStatus(category1.getStatus());

            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    @Override
    public CategoryDto getByIdCategory(Long id) {

        logger.info("Entro al metodo getByIdCategory del servicio ");
        Category categoryById = this.categoryRepository.findById(id).get();

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(categoryById.getId());
        categoryDto.setName(categoryById.getName());
        categoryDto.setType(categoryById.getType());
        categoryDto.setColor(categoryById.getColor());
        categoryDto.setIcon(categoryById.getIcon());
        categoryDto.setDescription(categoryById.getDescription());
        categoryDto.setStatus(categoryById.getStatus());


        return categoryDto;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        logger.info("Entro el metodo createCategory del servicio");
        Category categoryCreate = new Category();

        categoryCreate.setId(null);
        categoryCreate.setName(categoryDto.getName());
        categoryCreate.setType(categoryDto.getType());
        categoryCreate.setDescription(categoryDto.getDescription());
        categoryCreate.setColor(categoryDto.getColor());
        categoryCreate.setIcon(categoryDto.getIcon());
        categoryCreate.setCreatedAt(LocalDateTime.now());
        categoryCreate.setUpdatedAt(LocalDateTime.now());
        categoryCreate.setStatus(categoryDto.getStatus());

        categoryCreate = this.categoryRepository.save(categoryCreate);
        categoryDto.setId(categoryCreate.getId());

        return categoryDto;
    }

    @Override
    public CategoryDto deleteByIdCategory(Long id) {
        logger.info("Entro el metodo deleteByIdCategory del servicio");

        Category categoryDeleted = this.categoryRepository.findById(id).get();

        this.categoryRepository.deleteById(id);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(categoryDeleted.getId());
        categoryDto.setName(categoryDeleted.getName());
        categoryDto.setType(categoryDeleted.getType());
        categoryDto.setColor(categoryDeleted.getColor());
        categoryDto.setIcon(categoryDeleted.getIcon());
        categoryDto.setDescription(categoryDeleted.getDescription());
        categoryDto.setStatus(categoryDeleted.getStatus());

        return categoryDto;
    }
}
