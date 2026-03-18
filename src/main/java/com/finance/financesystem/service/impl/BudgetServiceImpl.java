package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.Budget;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.entity.UserSystem;
import com.finance.financesystem.repository.BudgetRepository;
import com.finance.financesystem.service.BudgetService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;

    private BudgetServiceImpl(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    @Override
    public List<BudgetDto> getAllBudget(){

        List<Budget> budgetList = this.budgetRepository.findAll();
        List<BudgetDto> budgetDtoList = new ArrayList<>();

        for (Budget budgetTmp: budgetList){
            BudgetDto budgetDto = new BudgetDto();
            budgetDto.setId(budgetTmp.getId());
            budgetDto.setLimitAmount(budgetTmp.getLimitAmount());
            budgetDto.setMonth(budgetTmp.getMonth());
            budgetDto.setYear(budgetTmp.getYear());
            budgetDto.setStatus(budgetTmp.getStatus());

            UserSystemDto userSystemDto = new UserSystemDto();
            userSystemDto.setId(budgetTmp.getUserSystem().getId());
            userSystemDto.setName(budgetTmp.getUserSystem().getName());
            userSystemDto.setCurrency(budgetTmp.getUserSystem().getCurrency());
            userSystemDto.setEmail(budgetTmp.getUserSystem().getEmail());
            userSystemDto.setPassword(budgetTmp.getUserSystem().getPassword());
            userSystemDto.setStatus(budgetTmp.getUserSystem().getStatus());
            userSystemDto.setLastLogin(budgetTmp.getUserSystem().getLastLogin());

            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(budgetTmp.getCategory().getId());
            categoryDto.setName(budgetTmp.getCategory().getName());
            categoryDto.setType(budgetTmp.getCategory().getType());
            categoryDto.setDescription(budgetTmp.getCategory().getDescription());
            categoryDto.setColor(budgetTmp.getCategory().getColor());
            categoryDto.setIcon(budgetTmp.getCategory().getIcon());
            categoryDto.setStatus(budgetTmp.getCategory().getStatus());

            budgetDto.setCategoryDto(categoryDto);

            budgetDtoList.add(budgetDto);

        }
        return budgetDtoList;

    }
    @Override
    public BudgetDto getByIdBudget(Long id){
        Budget budgetTmp = this.budgetRepository.findById(id).get();

        BudgetDto budgetDto = new BudgetDto();
        budgetDto.setId(budgetTmp.getId());
        budgetDto.setLimitAmount(budgetTmp.getLimitAmount());
        budgetDto.setMonth(budgetTmp.getMonth());
        budgetDto.setYear(budgetTmp.getYear());
        budgetDto.setStatus(budgetTmp.getStatus());

        UserSystemDto userSystemDto = new UserSystemDto();
        userSystemDto.setId(budgetTmp.getUserSystem().getId());
        userSystemDto.setName(budgetTmp.getUserSystem().getName());
        userSystemDto.setCurrency(budgetTmp.getUserSystem().getCurrency());
        userSystemDto.setEmail(budgetTmp.getUserSystem().getEmail());
        userSystemDto.setPassword(budgetTmp.getUserSystem().getPassword());
        userSystemDto.setStatus(budgetTmp.getUserSystem().getStatus());
        userSystemDto.setLastLogin(budgetTmp.getUserSystem().getLastLogin());

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(budgetTmp.getCategory().getId());
        categoryDto.setName(budgetTmp.getCategory().getName());
        categoryDto.setType(budgetTmp.getCategory().getType());
        categoryDto.setDescription(budgetTmp.getCategory().getDescription());
        categoryDto.setColor(budgetTmp.getCategory().getColor());
        categoryDto.setIcon(budgetTmp.getCategory().getIcon());
        categoryDto.setStatus(budgetTmp.getCategory().getStatus());

        budgetDto.setCategoryDto(categoryDto);


        return budgetDto;
    }
    @Override
    public BudgetDto createBudget(BudgetDto budgetDto){
        UserSystem userSystem = new UserSystem(
                budgetDto.getUserSystemDto().getId(),
                budgetDto.getUserSystemDto().getName(),
                budgetDto.getUserSystemDto().getEmail(),
                budgetDto.getUserSystemDto().getPassword(),
                budgetDto.getUserSystemDto().getCurrency(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                budgetDto.getUserSystemDto().getStatus(),
                budgetDto.getUserSystemDto().getLastLogin()
        );
        Category category = new Category(
                budgetDto.getCategoryDto().getId(),
                budgetDto.getCategoryDto().getName(),
                budgetDto.getCategoryDto().getType(),
                budgetDto.getCategoryDto().getDescription(),
                budgetDto.getCategoryDto().getColor(),
                budgetDto.getCategoryDto().getIcon(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                budgetDto.getCategoryDto().getStatus()
        );
        Budget budget = new Budget(
                null,
                budgetDto.getLimitAmount(),
                budgetDto.getMonth(),
                budgetDto.getYear(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                budgetDto.getStatus(),
                budgetDto.getAlertThreshold(),
                userSystem,
                category


        );
        Budget savedBudget = this.budgetRepository.save(budget);
        budgetDto.setId(savedBudget.getId());

        return budgetDto;
    }
}
