package com.finance.financesystem.mapper;

import java.time.LocalDateTime;

import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.Budget;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.entity.UserSystem;

import java.util.ArrayList;
import java.util.List;

public final class BudgetMapper {

    private BudgetMapper(){
    }
    public static Budget toEntity(BudgetDto budgetDto){

        Budget budget = new Budget();
        budget.setId(budgetDto.getId());
        budget.setLimitAmount(budgetDto.getLimitAmount());
        budget.setMonth(budgetDto.getMonth());
        budget.setYear(budgetDto.getYear());
        budget.setStatus(budgetDto.getStatus());
        budget.setCreatedAt(LocalDateTime.now());
        budget.setUpdatedAt(LocalDateTime.now());
        budget.setAlertThreshold(budgetDto.getAlertThreshold());

        UserSystem userSystem = new UserSystem();
        userSystem.setId(budgetDto.getUserSystemDto().getId());
        userSystem.setName(budgetDto.getUserSystemDto().getName());
        userSystem.setEmail(budgetDto.getUserSystemDto().getEmail());
        userSystem.setPassword(budgetDto.getUserSystemDto().getPassword());
        userSystem.setCurrency(budgetDto.getUserSystemDto().getCurrency());
        userSystem.setStatus(budgetDto.getUserSystemDto().getStatus());
        userSystem.setLastLogin(LocalDateTime.now());
        userSystem.setCreatedAt(LocalDateTime.now());
        userSystem.setUpdatedAt(LocalDateTime.now());

        Category category = new Category();
        category.setId(budgetDto.getCategoryDto().getId());
        category.setName(budgetDto.getCategoryDto().getName());
        category.setType(budgetDto.getCategoryDto().getType());
        category.setDescription(budgetDto.getCategoryDto().getDescription());
        category.setColor(budgetDto.getCategoryDto().getColor());
        category.setIcon(budgetDto.getCategoryDto().getIcon());
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        category.setStatus(budgetDto.getCategoryDto().getStatus());

        budget.setUserSystem(userSystem);
        budget.setCategory(category);

        return budget;
    }

    public static BudgetDto toDto(Budget budget){
        BudgetDto budgetDto = new BudgetDto();
        budgetDto.setId(budget.getId());
        budgetDto.setLimitAmount(budget.getLimitAmount());
        budgetDto.setMonth(budget.getMonth());
        budgetDto.setYear(budget.getYear());
        budgetDto.setStatus(budget.getStatus());
        budgetDto.setAlertThreshold(budget.getAlertThreshold());

        UserSystemDto userSystemDto = new UserSystemDto();
        userSystemDto.setId(budget.getUserSystem().getId());
        userSystemDto.setName(budget.getUserSystem().getName());
        userSystemDto.setEmail(budget.getUserSystem().getEmail());
        userSystemDto.setPassword(budget.getUserSystem().getPassword());
        userSystemDto.setCurrency(budget.getUserSystem().getCurrency());
        userSystemDto.setStatus(budget.getUserSystem().getStatus());
        userSystemDto.setLastLogin(budget.getUserSystem().getLastLogin());
        
        CategoryDto categorydDto = new CategoryDto();
        categorydDto.setId(budget.getCategory().getId());
        categorydDto.setName(budget.getCategory().getName());
        categorydDto.setType(budget.getCategory().getType());
        categorydDto.setDescription(budget.getCategory().getDescription());
        categorydDto.setColor(budget.getCategory().getColor());
        categorydDto.setIcon(budget.getCategory().getIcon());
        categorydDto.setStatus(budget.getCategory().getStatus());

        budgetDto.setUserSystemDto(userSystemDto);
        budgetDto.setCategoryDto(categorydDto);

        return budgetDto;
    }
    
    public static List<BudgetDto> toListDto(List<Budget> budgets) {
        List<BudgetDto> budgetDtoList = new ArrayList<>();
        for(Budget budget : budgets){
            budgetDtoList.add(toDto(budget));
        }
        return budgetDtoList;
    }

    public static List<Budget> toListEntity(List<BudgetDto> budgetDtoList){
        List<Budget> budgets = new ArrayList<>();
        for(BudgetDto budgetDto : budgetDtoList){
            budgets.add(toEntity(budgetDto));
        }
        return budgets;
    }
}
