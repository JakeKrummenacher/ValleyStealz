package com.grouptwelve.sportclothingsite.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<Product> products;


    public Cart() {

    }

    @PrePersist
    protected void onCreate() {this.createdAt = new Date();}
    @PreUpdate
    protected void onUpdate() {this.updatedAt = new Date();}
}
