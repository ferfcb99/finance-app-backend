package com.finance.financesystem.controller;

import com.finance.financesystem.dto.BudgetDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BudgetController {

    ResponseEntity<List<BudgetDto>> getAllBudget();

    ResponseEntity<BudgetDto> getByIdBudget(Long id);

    ResponseEntity<BudgetDto> createBudget(BudgetDto budgetDto);

    ResponseEntity<BudgetDto> deleteByIdBudget(Long id);



}

