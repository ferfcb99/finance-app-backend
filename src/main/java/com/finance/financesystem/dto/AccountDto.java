package com.finance.financesystem.dto;

public class AccountDto {

    private Long id;

    private String name;

    private String type;

    private Double balance;

    private String currency;

    private String status;

    private String description;

    private UserSystemDto userSystemDto;


    public AccountDto() {
    }

    public AccountDto(Long id, String name, String type, Double balance, String currency, String status, String description,
                      UserSystemDto userSystemDto) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.currency = currency;
        this.balance = balance;
        this.status = status;
        this.description = description;
        this.userSystemDto = userSystemDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserSystemDto getUserSystemDto() {
        return userSystemDto;
    }

    public void setUserSystemDto(UserSystemDto userSystemDto) {
        this.userSystemDto = userSystemDto;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", userSystemDto=" + userSystemDto +
                '}';
    }
}