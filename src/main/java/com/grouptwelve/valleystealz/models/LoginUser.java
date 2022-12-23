package com.grouptwelve.valleystealz.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//This class is just for the purpose of logging, not saving anything to the database
public class LoginUser {

//	When a user is loging in the website we're not creating something new in the database
//	We just need to check and verify the info matches such as the email and password
//	We don't want to use the User class because it's an entity
//	We want something simple that's not an entity
//	so that we can make an object really quick to make some validations

    //	================== Member Variables ========================
    @NotEmpty(message="Email is Required")
    @Email(message="Invalid Email")
    private String email;

    @NotEmpty(message="Password is Required")
    @Size(min=2,max=256,message="Password must be at least 6 Characters!")
    private String password;


    //	================== Constructor ========================
    public LoginUser() {}


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }













}
