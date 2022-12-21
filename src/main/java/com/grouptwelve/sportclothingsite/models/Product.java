package com.grouptwelve.sportclothingsite.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imgSource;

    private Double price;

    @Column(updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id")
    private Cart cart;


    public Product() {

    }

    public Product(String name, Double price, String imgSource) {
        this.name = name;
        this.price = price;
        this.imgSource = imgSource;
    }

    @PrePersist
    protected void onCreate() {this.createdAt = new Date();}
    @PreUpdate
    protected void onUpdate() {this.updatedAt = new Date();}
}
