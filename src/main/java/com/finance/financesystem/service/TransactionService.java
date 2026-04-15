package com.finance.financesystem.service;

import com.finance.financesystem.dto.TransactionDto;
import com.finance.financesystem.dto.transactionrequest.TransactionRequest;

import java.util.List;

public interface TransactionService {

    List<TransactionRequest> getAllTransactions();

    String addTransaction(TransactionRequest transactionRequest);

}
