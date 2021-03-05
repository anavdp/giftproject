package com.giv.giftproject.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Gift {
    @Id
    @GeneratedValue
    private int id;

    @Column
    @NotBlank
    private String description;

    @Column
    private String imageUrl;
    
    @Column
    private double price;
    
    @Column(length = 500)
    @NotBlank
    private String url;

    public Gift(String description, String imageUrl, double price, String url) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.url = url;
    }

    public Gift(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
