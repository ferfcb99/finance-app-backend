package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.AccountDto;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.Account;
import com.finance.financesystem.entity.UserSystem;
import com.finance.financesystem.mapper.AccountMapper;
import com.finance.financesystem.mapper.CategoryMapper;
import com.finance.financesystem.repository.AccountRepository;
import com.finance.financesystem.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class  AccountServiceImpl implements AccountService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        logger.info("Entro al metodo getAll del servicio");
        List<Account> accounts = accountRepository.findAll();

        return AccountMapper.toListDto(accounts);

    }

    @Override
    public AccountDto getById(Long id) {
        logger.info("Entro al metodo getById del servicio");
        Account accountById = this.accountRepository.findById(id).get();

        return AccountMapper.toDto(accountById);

    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        logger.info("Entro al metodo create del servicio");

        Account accountToCreate = AccountMapper.toEntity(accountDto);

        accountToCreate = this.accountRepository.save(accountToCreate);
        accountDto.setId(accountToCreate.getId());

        return AccountMapper.toDto(accountToCreate);

    }

    @Override
    public AccountDto deleteById(Long id) {
        logger.info("Entro al metodo deleteById del servicio");
        Account accountDeleted = this.accountRepository.findById(id).get();

        this.accountRepository.deleteById(id);


        return AccountMapper.toDto(accountDeleted);
    }


}


