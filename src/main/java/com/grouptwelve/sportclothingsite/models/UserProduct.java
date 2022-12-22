package com.grouptwelve.sportclothingsite.models;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="userProducts")
public class UserProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int productId;

    int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id")
    private Cart cart;


    public UserProduct() {

    }

    public UserProduct(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

}
