package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.TransactionController;
import com.finance.financesystem.dto.TransactionDto;
import com.finance.financesystem.service.TransactionService;
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
    @GetMapping(value = "/get-all-transaction", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransactionDto>> getAllTransaction(){
        return null;
    }

    @Override
    @GetMapping(value = "/get-by-id-transaction/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDto> getByIdTransaction(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    @PostMapping(value = "/create-transaction", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        return null;
    }

}

