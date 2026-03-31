package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.AccountDto;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.Account;
import com.finance.financesystem.entity.UserSystem;
import com.finance.financesystem.mapper.AccountMapper;
import com.finance.financesystem.repository.AccountRepository;
import com.finance.financesystem.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        logger.info("Entro al metodo getAll del servicio");
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountDtoList = new ArrayList<>();

        for(Account account : accounts) {
            AccountDto accountDto = AccountMapper.toDto(account);
            accountDtoList.add(accountDto);
        }

        return accountDtoList;

    }

    @Override
    public AccountDto getById(Long id) {
        logger.info("Entro al metodo getById del servicio");
        Account accountById = this.accountRepository.findById(id).get();

        AccountDto accountDto = new AccountDto();
        UserSystemDto userSystemDto = new UserSystemDto();

        accountDto.setId(accountById.getId());
        accountDto.setName(accountById.getName());
        accountDto.setType(accountById.getType());
        accountDto.setBalance(accountById.getBalance());
        accountDto.setCurrency(accountById.getCurrency());
        accountDto.setStatus(accountById.getStatus());
        accountDto.setDescription(accountById.getDescription());


        userSystemDto.setId(accountById.getUserSystem().getId());
        userSystemDto.setName(accountById.getUserSystem().getName());
        userSystemDto.setEmail(accountById.getUserSystem().getEmail());
        userSystemDto.setPassword(accountById.getUserSystem().getPassword());
        userSystemDto.setCurrency(accountById.getUserSystem().getCurrency());
        userSystemDto.setStatus(accountById.getUserSystem().getStatus());
        userSystemDto.setLastLogin(accountById.getUserSystem().getLastLogin());

        accountDto.setUserSystemDto(userSystemDto);

        return accountDto;

    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        logger.info("Entro al metodo create del servicio");

        Account accountToCreate = AccountMapper.toEntity(accountDto);

        accountToCreate = this.accountRepository.save(accountToCreate);
        accountDto.setId(accountToCreate.getId());

        return accountDto;

    }

    @Override
    public AccountDto deleteById(Long id) {
        logger.info("Entro al metodo deleteById del servicio");
        Account accountDeleted = this.accountRepository.findById(id).get();

        this.accountRepository.deleteById(id);

        AccountDto accountDto = new AccountDto();
        UserSystemDto userSystemDto = new UserSystemDto();

        accountDto.setId(accountDeleted.getId());
        accountDto.setName(accountDeleted.getName());
        accountDto.setType(accountDeleted.getType());
        accountDto.setBalance(accountDeleted.getBalance());
        accountDto.setCurrency(accountDeleted.getCurrency());
        accountDto.setStatus(accountDeleted.getStatus());
        accountDto.setDescription(accountDeleted.getDescription());



        userSystemDto.setId(accountDeleted.getUserSystem().getId());
        userSystemDto.setName(accountDeleted.getUserSystem().getName());
        userSystemDto.setEmail(accountDeleted.getUserSystem().getEmail());
        userSystemDto.setPassword(accountDeleted.getUserSystem().getPassword());
        userSystemDto.setCurrency(accountDeleted.getUserSystem().getCurrency());
        userSystemDto.setStatus(accountDeleted.getUserSystem().getStatus());
        userSystemDto.setLastLogin(accountDeleted.getUserSystem().getLastLogin());

        accountDto.setUserSystemDto(userSystemDto);

        return accountDto;
    }


}


