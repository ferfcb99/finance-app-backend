package com.finance.financesystem.controller;

import com.finance.financesystem.dto.AccountDto;
import com.finance.financesystem.entity.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountController {

    ResponseEntity<List<AccountDto>> getAll();

    ResponseEntity<AccountDto> getById(Long id);

    ResponseEntity<AccountDto> create(AccountDto accountDto);

    ResponseEntity<AccountDto> deleteById(Long id);


}


