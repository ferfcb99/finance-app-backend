package com.finance.financesystem.service;

import com.finance.financesystem.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    List<TransactionDto> getAllTransaction();

    TransactionDto getByIdTransaction(Long id);

    TransactionDto createTransaction(TransactionDto transactionDto);

    TransactionDto deleteByIdTransaction(Long id);
}
