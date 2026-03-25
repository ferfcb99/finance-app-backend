package com.finance.financesystem.service;

import com.finance.financesystem.dto.AccountDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAll();

    AccountDto getById(Long id);

    AccountDto deleteById(Long id);

    AccountDto create(AccountDto accountDto);

}
