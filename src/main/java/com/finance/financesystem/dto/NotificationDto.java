package com.finance.financesystem.dto;

public class NotificationDto {

    private Long id;

    private String message;

    private String type;

    private Boolean isRead;

    private String status;

    public NotificationDto(){
    }

    public NotificationDto(Long id, String message, String type, Boolean isRead, String status) {
        this.id = id;
        this.message = message;
        this.type = type;
        this.isRead = isRead;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
