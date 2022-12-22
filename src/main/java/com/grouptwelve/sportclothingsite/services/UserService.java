package com.grouptwelve.sportclothingsite.services;

import com.grouptwelve.sportclothingsite.models.LoginUser;
import com.grouptwelve.sportclothingsite.models.User;
import org.mindrot.jbcrypt.BCrypt;
import com.grouptwelve.sportclothingsite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//	======================== REGISTER AND LOGIN ================================
//	======================== CREATE AND UPDATE =================================
//	Need two methods one for register and one for login
//	Both functions return a User and have different data type and parameters

    //	Has a User datatype and BindingResult
//	This method is used for making a new user in out database
    public User register(User newUser, BindingResult result) {
//		newUser is an OBJECT with the information from the register form

//		Check if the email is unique
//		Calling on the UserRepository to use the findByEmail function created
//		findByEmail returns an Optional, so we will need to check if the user is actually .isPresent()
//		The email is coming from the newUser object in our register function
//		Since it's an User OBJECT it has a dot email but using the getters since it's not a jsp page
        if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
//			if True that email is taken, so we will need to call upon result now from BindingResult
//			the first argument is the email (field inside the object), then "theUniqueErrorCode" ,and finally the message to display
            result.rejectValue("email","Matches","Email is already in use");
        }

//		Check if the password matches the confirm password
//		To compare two String together we use .equals()
//		first get the password from the new user and then call the dot equals()
//		Passing in the newUser confirm password
//		BUT we only want to do something if they DON'T MATCH!!!
        if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password!");
        }

//		Final check to see if there are errors
        if(result.hasErrors()) {
            return null;
        }

//		Need to Hash the Password b/c it's a 1 to 1 meaning it's not reversible
//		One any given String will always go to one given hash
//		Using bycrypt to do this because it's slow, adds salt for more security, and hashes it 12 times
//		Need to take the password from the newUser Object and Hash it
//		Then we could save it to the User to the database

//		hash the password and set the newUser object's password to the new hash
//		Taking the password and pass it through the password function for BCrpt and get this hashed version
        String hash_browns=BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt());
//		We now Set the password to this hash_browns
        newUser.setPassword(hash_browns);

//		Now save the newUser by passing it in the save UserRepository function
//		userRepo.save returns a user so our function returns a user
        return userRepository.save(newUser);
    }


    //	login method has a LoginUser datatype and a BindingResult
//	This method is just for the purpose of logging someone in
    public User login(LoginUser newLoginUser, BindingResult result) {
//		First check to see any Validation Errors and return null if it has errors
        if(result.hasErrors()) {
            return null;
        }
//		Then check if the user with the entered email exist
//		Using the Optional function we could do so
        Optional<User> potentialUser = userRepository.findByEmail(newLoginUser.getEmail());
//		if the email is not in the database
//		then return the reject of email and the unique message and not say what went wrong or incorrect
        if(!potentialUser.isPresent()) {
            result.rejectValue("email","Unique","Invalid Credentials");
//			if the email is not found, don't bother checking the password
            return null;
        }
//		If the user Does Exist then grab the user out of the Optional(database)
        User user = potentialUser.get(); // gets the User object from the Optional
//		Using BCrypt to check if the password are NOT EQUAL to eachOther
//		Checking PW passing in the String newLoginUser.getPassword() and the Hashed PW user.getPassword()
        if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
            result.rejectValue("password","Matches","Invalid Credentials");
            return null;
        }

//		If the Email and Password matches we return the user
        return user;
    }


//	=============================== READ ====================================

    public User getOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
