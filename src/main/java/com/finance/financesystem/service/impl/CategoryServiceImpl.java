package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.repository.CategoryRepository;
import com.finance.financesystem.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    private CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<CategoryDto> getAllCategory(){
        List<Category> categoryList = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for(Category categoryTmp: categoryList){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(categoryTmp.getId());
            categoryDto.setName(categoryTmp.getName());
            categoryDto.setType(categoryTmp.getType());
            categoryDto.setDescription(categoryTmp.getDescription());
            categoryDto.setColor(categoryTmp.getColor());
            categoryDto.setIcon(categoryTmp.getIcon());
            categoryDto.setStatus(categoryDto.getStatus());

            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;

    }

    @Override
    public CategoryDto getByIdCategory(Long id) {
        Category categoryTmp = this.categoryRepository.findById(id).get();

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(categoryTmp.getId());
        categoryDto.setName(categoryTmp.getName());
        categoryDto.setType(categoryTmp.getType());
        categoryDto.setDescription(categoryTmp.getDescription());
        categoryDto.setColor(categoryTmp.getColor());
        categoryDto.setIcon(categoryTmp.getIcon());
        categoryDto.setStatus(categoryDto.getStatus());


        return categoryDto;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return null;
    }
}
