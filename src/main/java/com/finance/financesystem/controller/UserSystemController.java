package com.finance.financesystem.controller;

import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.dto.UserSystemDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserSystemController {

    ResponseEntity<List<UserSystemDto>> getAllUserSystem();

    ResponseEntity<UserSystemDto> getByIdUserSystem(Long id);

    ResponseEntity<UserSystemDto> createBudget(UserSystemDto userSystemDto);
}
