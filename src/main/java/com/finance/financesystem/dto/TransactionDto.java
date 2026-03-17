package com.finance.financesystem.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class TransactionDto {

    private Long id;

    private String type;

    private Double amount;

    private String description;

    private Date transactionDate;

    private String status;

    private String reference;

    private CategoryDto categoryDto;



}
