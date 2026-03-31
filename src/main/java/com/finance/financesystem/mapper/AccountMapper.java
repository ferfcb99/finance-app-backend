package com.finance.financesystem.mapper;

import com.finance.financesystem.dto.AccountDto;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.Account;
import com.finance.financesystem.entity.UserSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class AccountMapper {

    private AccountMapper() {}

    public static Account toEntity(AccountDto accountDto) {

        Account account = new Account();
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());
        account.setType(accountDto.getType());
        account.setBalance(accountDto.getBalance());
        account.setCurrency(accountDto.getCurrency());
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        account.setStatus(accountDto.getStatus());
        account.setDescription(accountDto.getDescription());

        UserSystem userSystem = new UserSystem();
        userSystem.setId(accountDto.getUserSystemDto().getId());
        userSystem.setName(accountDto.getUserSystemDto().getName());
        userSystem.setEmail(accountDto.getUserSystemDto().getEmail());
        userSystem.setPassword(accountDto.getUserSystemDto().getPassword());
        userSystem.setCurrency(accountDto.getUserSystemDto().getCurrency());
        userSystem.setCreatedAt(LocalDateTime.now());
        userSystem.setUpdatedAt(LocalDateTime.now());
        userSystem.setStatus(accountDto.getUserSystemDto().getStatus());
        userSystem.setLastLogin(accountDto.getUserSystemDto().getLastLogin());

        account.setUserSystem(userSystem);

        return account;
    }

    public static AccountDto toDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setName(account.getName());
        accountDto.setType(account.getType());
        accountDto.setBalance(account.getBalance());
        accountDto.setCurrency(account.getCurrency());
        accountDto.setStatus(account.getStatus());
        accountDto.setDescription(account.getDescription());

        UserSystemDto userSystemDto = new UserSystemDto();
        userSystemDto.setId(account.getUserSystem().getId());
        userSystemDto.setName(account.getUserSystem().getName());
        userSystemDto.setEmail(account.getUserSystem().getEmail());
        userSystemDto.setPassword(account.getUserSystem().getPassword());
        userSystemDto.setCurrency(account.getUserSystem().getCurrency());
        userSystemDto.setStatus(account.getUserSystem().getStatus());
        userSystemDto.setLastLogin(account.getUserSystem().getLastLogin());

        accountDto.setUserSystemDto(userSystemDto);

        return accountDto;
    }

    public static List<AccountDto> toListDto(List<Account> accounts) {
        List<AccountDto> accountDtoList = new ArrayList<>();
        for(Account account : accounts) {
            accountDtoList.add(toDto(account));
        }
        return accountDtoList;
    }

    public static List<Account> toListEntity(List<AccountDto> accountDtoList) {
        List<Account> accounts = new ArrayList<>();
        for(AccountDto accountDto : accountDtoList) {
            accounts.add(toEntity(accountDto));
        }
        return accounts;
    }


}
