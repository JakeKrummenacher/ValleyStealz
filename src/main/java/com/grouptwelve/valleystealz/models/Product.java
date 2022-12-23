package com.grouptwelve.valleystealz.models;

import lombok.Data;

import javax.persistence.*;
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
