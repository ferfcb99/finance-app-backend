package com.finance.financesystem.service;

import com.finance.financesystem.dto.BudgetDto;

import java.util.List;

public interface BudgetService {

    List<BudgetDto> getAllBudget();

    BudgetDto getByIdBudget(Long id);

    BudgetDto createBudget(BudgetDto budgetDto);

    BudgetDto deteByIdBudget(Long id);

}
