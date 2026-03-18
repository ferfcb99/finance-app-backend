package com.finance.financesystem.dto;

public class BudgetDto {

    private Long id;

    private Double limitAmount;

    private Integer month;

    private Integer year;

    private String status;

    private Double alertThreshold;

    private UserSystemDto userSystemDto;

    private CategoryDto categoryDto;


    public BudgetDto(){
    }

    public BudgetDto(Long id, Double limitAmount, Integer month, Integer year, String status, Double alertThreshold,
                     UserSystemDto userSystemDto, com.finance.financesystem.dto.CategoryDto categoryDto) {
        this.id = id;
        this.limitAmount = limitAmount;
        this.month = month;
        this.year = year;
        this.status = status;
        this.alertThreshold = alertThreshold;
        this.userSystemDto = userSystemDto;
        this.categoryDto = categoryDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Double limitAmount) {
        this.limitAmount = limitAmount;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAlertThreshold() {
        return alertThreshold;
    }

    public void setAlertThreshold(Double alertThreshold) {
        this.alertThreshold = alertThreshold;
    }

    public UserSystemDto getUserSystemDto() {
        return userSystemDto;
    }

    public void setUserSystemDto(UserSystemDto userSystemDto) {
        this.userSystemDto = userSystemDto;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;

    }

    @Override
    public String toString() {
        return "BudgetDto{" +
                "id=" + id +
                ", limitAmount=" + limitAmount +
                ", month=" + month +
                ", year=" + year +
                ", status='" + status + '\'' +
                ", alertThreshold=" + alertThreshold +
                ", userSystemDto=" + userSystemDto +
                ", categoryDto=" + categoryDto +
                '}';
    }
}
