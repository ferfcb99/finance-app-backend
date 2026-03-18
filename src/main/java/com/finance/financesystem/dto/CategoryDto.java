package com.finance.financesystem.dto;

public class CategoryDto {

    private Long id;

    private String name;

    private String type;

    private String description;

    private String color;

    private String icon;

    private String status;

    public CategoryDto(){

    }

    public CategoryDto(Long id, String name, String type, String description, String color, String icon, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.color = color;
        this.icon = icon;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
