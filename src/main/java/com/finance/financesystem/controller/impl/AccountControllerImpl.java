package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.AccountController;
import com.finance.financesystem.dto.AccountDto;
import com.finance.financesystem.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/v1/account")
public class AccountControllerImpl implements AccountController{

    Logger logger = LoggerFactory.getLogger(AccountControllerImpl.class);

    private final AccountService accountService;

    public AccountControllerImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    // para obtener todos
    @Override
    @GetMapping(value = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountDto>> getAll() {
        logger.info("Entro al metodo getAll del controlador");
        List<AccountDto> accountDtoList = this.accountService.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountDtoList);
    }

    // para obtener por id
    @Override
    @GetMapping(value = "/get-by-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> getById(@PathVariable("id") Long id) {
        logger.info("Entro al metodo getById del controlador");
        AccountDto accountById = this.accountService.getById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountById);
    }

    // para crear
    @Override
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto) {
        logger.info("Entro al metodo create del controlador");
        AccountDto accountCreated = this.accountService.create(accountDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountCreated);
    }

    // para eliminar
    @Override
    @DeleteMapping(value = "/delete-by-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> deleteById(@PathVariable("id") Long id) {
        logger.info("Entro al metodo deleteById en el controlador");
        AccountDto accountDto = this.accountService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountDto);
    }





}
