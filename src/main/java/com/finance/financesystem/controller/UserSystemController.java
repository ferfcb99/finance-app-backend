package com.finance.financesystem.controller;

import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.dto.UserSystemDto;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserSystemController {

    ResponseEntity<List<UserSystemDto>> getAllUserSystem();

    ResponseEntity<UserSystemDto> getByIdUserSystem(Long id);

    ResponseEntity<UserSystemDto> createUserSystem(UserSystemDto userSystemDto);

    ResponseEntity<UserSystemDto> deleteByIdUserSystem(Long id);


}
