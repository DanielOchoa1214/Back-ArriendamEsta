package com.eci.ariendamesta.model.estate;

public class EstateDto {

    private int price;
    private String description;
    private String title;
    public EstateDto(int price, String description, String title) {
        this.price = price;
        this.description = description;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
