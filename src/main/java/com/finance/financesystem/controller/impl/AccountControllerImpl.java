package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.AccountController;
import com.finance.financesystem.dto.AccountDto;
import com.finance.financesystem.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/account")
public class AccountControllerImpl implements AccountController{


    private final AccountService accountService;

    public AccountControllerImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    @GetMapping(value = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE) // http://localhost:8080/v1/account/get-all
    public ResponseEntity<List<AccountDto>> getAll() {
        return null;
    }

    @Override
    @GetMapping(value = "/get-by-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> getById(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto) {
        return null;
    }
}
