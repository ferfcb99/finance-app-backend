package com.finance.financesystem.controller;

import com.finance.financesystem.dto.TransactionDto;
import com.finance.financesystem.dto.transactionrequest.TransactionRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionController {

    ResponseEntity<List<TransactionRequest>> getAllTransactionRequests();

    ResponseEntity<String> addTransaction(TransactionRequest transactionRequest);

}
