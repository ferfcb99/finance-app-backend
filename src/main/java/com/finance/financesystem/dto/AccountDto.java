package com.finance.financesystem.dto;

public class AccountDto {

    private Long id;

    private String nombre;

    private String type;

    private String currency;

    private String status;

    private String description;

    private UserSystemDto userSystemDto;


    public AccountDto(){
    }

    public AccountDto(Long id, String nombre, String type, String currency, String status, String description,
                      UserSystemDto userSystemDto) {
        this.id = id;
        this.nombre = nombre;
        this.type = type;
        this.currency = currency;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
