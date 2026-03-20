package com.finance.financesystem.dto;

import java.time.LocalDateTime;

public class UserSystemDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private String currency;

    private String status;

    private LocalDateTime lastLogin;

    public UserSystemDto(){
    }

    public UserSystemDto(Long id, String name, String email, String password, String currency, String status,
                         LocalDateTime lastLogin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.currency = currency;
        this.status = status;
        this.lastLogin = lastLogin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "UserSystemDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
