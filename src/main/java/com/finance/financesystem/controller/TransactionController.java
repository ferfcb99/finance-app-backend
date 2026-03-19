package com.finance.financesystem.controller;

import com.finance.financesystem.dto.TransactionDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionController {

    ResponseEntity<List<TransactionDto>> getAllTransaction();

    ResponseEntity<TransactionDto> getByIdTransaction(Long id);

    ResponseEntity<TransactionDto> createTransaction(TransactionDto transactionDto);
}
