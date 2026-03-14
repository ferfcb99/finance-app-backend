package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.AccountDto;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.Account;
import com.finance.financesystem.repository.AccountRepository;
import com.finance.financesystem.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        List<Account> accountList = this.accountRepository.findAll(); // sleect * from aacount
        List<AccountDto> accountDtoList = new ArrayList<>();

        for(Account accountTmp : accountList){
            AccountDto accountDto = new AccountDto();
            accountDto.setId(accountTmp.getId());
            accountDto.setName(accountTmp.getName());
            accountDto.setType(accountTmp.getType());
            accountDto.setCurrency(accountTmp.getCurrency());
            accountDto.setDescription(accountTmp.getDescription());
            accountDto.setStatus(accountTmp.getStatus());

            UserSystemDto userSystemDto = new UserSystemDto();
            userSystemDto.setId(accountTmp.getUserSystem().getId());
            userSystemDto.setName(accountTmp.getUserSystem().getName());
            userSystemDto.setCurrency(accountTmp.getUserSystem().getCurrency());
            userSystemDto.setEmail(accountTmp.getUserSystem().getEmail());
            userSystemDto.setPassword(accountTmp.getUserSystem().getPassword());
            userSystemDto.setStatus(accountTmp.getUserSystem().getStatus());
            userSystemDto.setLastLogin(accountTmp.getUserSystem().getLastLogin());

            accountDto.setUserSystemDto(userSystemDto);

            accountDtoList.add(accountDto);

        }

        return accountDtoList;
    }

    @Override
    // select * form account where id = ?
    public AccountDto getById(Long id) {
        Account accountTmp = this.accountRepository.findById(id).get();

        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountTmp.getId());
        accountDto.setName(accountTmp.getName());
        accountDto.setType(accountTmp.getType());
        accountDto.setCurrency(accountTmp.getCurrency());
        accountDto.setDescription(accountTmp.getDescription());
        accountDto.setStatus(accountTmp.getStatus());

        UserSystemDto userSystemDto = new UserSystemDto();
        userSystemDto.setId(accountTmp.getUserSystem().getId());
        userSystemDto.setName(accountTmp.getUserSystem().getName());
        userSystemDto.setCurrency(accountTmp.getUserSystem().getCurrency());
        userSystemDto.setEmail(accountTmp.getUserSystem().getEmail());
        userSystemDto.setPassword(accountTmp.getUserSystem().getPassword());
        userSystemDto.setStatus(accountTmp.getUserSystem().getStatus());
        userSystemDto.setLastLogin(accountTmp.getUserSystem().getLastLogin());

        accountDto.setUserSystemDto(userSystemDto);

        return accountDto;
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        return null;
    }
}


