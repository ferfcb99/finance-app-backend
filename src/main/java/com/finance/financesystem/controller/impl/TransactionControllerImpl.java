package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.TransactionController;
import com.finance.financesystem.dto.TransactionDto;
import com.finance.financesystem.entity.Transaction;
import com.finance.financesystem.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/transaction")
public class TransactionControllerImpl implements TransactionController {

    private final TransactionService transactionService;

    public TransactionControllerImpl(TransactionService transactionService){
        this.transactionService = transactionService;
    }


    @Override
    public ResponseEntity<List<TransactionDto>> getAllTransaction() {
        return null;
    }

    @Override
    public ResponseEntity<TransactionDto> getByIdTransaction(@PathVariable Long id) {
        return null;
    }

    @Override
    public ResponseEntity<TransactionDto> createTransaction(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public ResponseEntity<TransactionDto> deleteByIdTransaction(Long id) {
        return null;
    }
}

