package com.finance.financesystem.dto.transactionrequest;

public class TransactionRequest {

    private Long id;

    private String type;

    private Double amount;

    private String description;

    private String status;

    private String reference;

    private Long categoryId;

    private Long accountId;

    public TransactionRequest() {}

    public TransactionRequest(Long id, String type, Double amount, String descritpion, String status, String reference, Long categoryId, Long accountId) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = descritpion;
        this.status = status;
        this.reference = reference;
        this.categoryId = categoryId;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", descritpion=" + description +
                ", status='" + status + '\'' +
                ", reference='" + reference + '\'' +
                ", categoryId=" + categoryId +
                ", accountId=" + accountId +
                '}';
    }
}
