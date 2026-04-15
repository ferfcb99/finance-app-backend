package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.TransactionController;
import com.finance.financesystem.dto.TransactionDto;
import com.finance.financesystem.dto.transactionrequest.TransactionRequest;
import com.finance.financesystem.entity.Transaction;
import com.finance.financesystem.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/transaction")
public class TransactionControllerImpl implements TransactionController {

    private final TransactionService transactionService;

    public TransactionControllerImpl(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @Override
    @GetMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransactionRequest>> getAllTransactionRequests() {
        List<TransactionRequest> transactionRequests = this.transactionService.getAllTransactions();
        return ResponseEntity.status(HttpStatus.OK)
                .body(transactionRequests);
    }

    @Override
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTransaction(@RequestBody TransactionRequest transactionRequest) {
        String responseMessage = this.transactionService.addTransaction(transactionRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseMessage);
    }
}

