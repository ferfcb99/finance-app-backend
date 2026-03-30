package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.dto.TransactionDto;
import com.finance.financesystem.entity.Transaction;
import com.finance.financesystem.repository.TransactionRepository;
import com.finance.financesystem.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    private TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionDto> getAllTransaction() {
        return List.of();
    }

    @Override
    public TransactionDto getByIdTransaction(Long id) {
        return null;
    }

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public TransactionDto deleteByIdTransaction(Long id) {
        return null;
    }
}