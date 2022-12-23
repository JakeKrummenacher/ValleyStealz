package com.grouptwelve.valleystealz.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name="users")
public class User {

    //	================== Primary Key ========================
//	Adding in the Id
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long id;

//	================== Member Variables ========================
//	All the member variables will be come fields in our database
//	Using Annotations to build out member variables as well
//	As provided Validations for each of the member variables

    @NotEmpty(message="First Name is Required")
    @Size(min=2,max=45,message="First Name must be at least 2 Characters!")
    private String firstName;

    @NotEmpty(message="Last Name is Required")
    @Size(min=2,max=45,message="Last Name must be at least 2 Characters!")
    private String lastName;

    @NotEmpty(message="Email is Required")
    @Email(message="Invalid Email")
    private String email;

    @NotEmpty(message="Password is Required")
    @Size(min=2,max=256,message="Password must be at least 6 Characters!")
    private String password;

    //	Will allow us to use it as an instance of a User temporarily, without storing it to the database
//	Don't want to store our confirm Password
    @Transient
    @NotEmpty(message="Confirm Password is Required")
    @Size(min=2,max=256,message="Confirm Password must be at least 6 Characters!")
    private String confirmPassword;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserProduct> userProducts;


    //	================== Data Creation Trackers ========================
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;


    // ========== Relationships =================
//    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Tab> tables;
//
////    Using the creator mappedBy so that I can access the member variables
//    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Book> borrowedBooks;

//	================== Constructor ========================

    public User() {}


//	================== Data Creation Event ========================

    //  If the item hasn't been added yet then create a new date and assign that to created at
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    //  If the item does exist then we're about to update it before we update it in the database
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



}
