package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.dto.NotificationDto;
import com.finance.financesystem.dto.TransactionDto;
import com.finance.financesystem.dto.transactionrequest.NotificationRequest;
import com.finance.financesystem.dto.transactionrequest.TransactionRequest;
import com.finance.financesystem.entity.Account;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.entity.Notification;
import com.finance.financesystem.entity.Transaction;
import com.finance.financesystem.repository.AccountRepository;
import com.finance.financesystem.repository.CategoryRepository;
import com.finance.financesystem.repository.NotificationRepository;
import com.finance.financesystem.repository.TransactionRepository;
import com.finance.financesystem.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final TransactionRepository transactionRepository;

    private final CategoryRepository categoryRepository;

    private final AccountRepository accountRepository;

    private final NotificationRepository notificationRepository;

    private TransactionServiceImpl(TransactionRepository transactionRepository,
                                   CategoryRepository categoryRepository,
                                   AccountRepository accountRepository,
                                   NotificationRepository notificationRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
        this.accountRepository = accountRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<TransactionRequest> getAllTransactions() {
        List<Transaction> transactions = this.transactionRepository.findAll();
        List<TransactionRequest> transactionRequests = transactions.stream()
                .map(transaction -> new TransactionRequest(
                        transaction.getId(),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getDescription(),
                        transaction.getStatus(),
                        transaction.getReference(),
                        transaction.getCategory().getId(),
                        transaction.getAccount().getId()
                )).toList();
        return transactionRequests;
    }

    @Override
    public String addTransaction(TransactionRequest transactionRequest) {
        logger.info("Entro al servicio de transaction en el metodo addTransaction");
        String outcome = "Transaction successfully added";
        if(transactionRequest.getCategoryId() == null || transactionRequest.getAccountId() == null){
            outcome = "Category id and account id cannot be null";
            return outcome;
        }
        logger.info("Se va a cosultar si existe la categoria");
        Category category = this.categoryRepository.findById(transactionRequest.getCategoryId()).get();

        logger.info("Se va a cosultar si existe la cuenta");
        Account account = this.accountRepository.findById(transactionRequest.getAccountId()).get();

        logger.info("Se validaron los id foraneos");

        Transaction transaction = new Transaction();
        transaction.setId(null);
        transaction.setType(transactionRequest.getType());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setDescription(transactionRequest.getDescription());
        transaction.setTransactionDate(new Date());
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setUpdatedAt(LocalDateTime.now());
        transaction.setStatus(transactionRequest.getStatus());
        transaction.setReference(transactionRequest.getReference());
        transaction.setCategory(category);
        transaction.setAccount(account);

        transaction = this.transactionRepository.save(transaction);

        addNoticationTransaction(transactionRequest);

        return outcome + " with id " + transaction.getId();
    }


    public void addNoticationTransaction(TransactionRequest transactionRequest){
        logger.info("Entro al servicio de transaction en el metodo addComentaryTransaction");

        Notification notification = new Notification();
        notification.setId(null);
        notification.setMessage("");
        notification.setType(transactionRequest.getType());
        notification.setRead(false);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setStatus(transactionRequest.getStatus());

        this.notificationRepository.save(notification);

        logger.info("Se guardo la notificacion");
    }
}









