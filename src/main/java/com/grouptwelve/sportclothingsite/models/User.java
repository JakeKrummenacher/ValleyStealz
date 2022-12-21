package com.grouptwelve.sportclothingsite.models;

import lombok.Data;

import jakarta.validation.constraints.Size;
import jakarta.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2)
    private String firstName;

    @Size(min=2)
    private String lastName;

    private int age;

    @Column(updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cart cart;



    public User() {

    }

    public User(String firstName, String lastName, int age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }

    @PrePersist
    protected void onCreate(){this.createdAt = new Date();}
    @PreUpdate
    protected void onUpdate(){this.updatedAt = new Date();}


}
