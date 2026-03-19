package com.finance.financesystem.controller;

import com.finance.financesystem.dto.AccountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountController {

    ResponseEntity<List<AccountDto>> getAll();

    ResponseEntity<AccountDto> getById(Long id);

    ResponseEntity<AccountDto> create(AccountDto accountDto);

}


