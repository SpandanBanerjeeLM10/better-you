package ie.dcu.ee417.betteryou.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ie.dcu.ee417.betteryou.entities.Login;
import ie.dcu.ee417.betteryou.entities.Users;
import ie.dcu.ee417.betteryou.repository.LoginRepository;
import ie.dcu.ee417.betteryou.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private LoginRepository loginRepository;
    

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody Users newUser) {
        try {
        	
            // Save the new user to the database
        	System.out.println(newUser.toString());
            userRepository.save(newUser);
            
            // Create a new login object with the user's credentials
            Login newLogin = new Login();
            newLogin.setUserName(newUser.getUserName());
            newLogin.setPassword(newUser.getPassword());
            newLogin.setRole("user");
            loginRepository.save(newLogin);


            // Return a success response
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            // Return an error response
            return new ResponseEntity<>("Error creating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
   @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Login newLogin) {
    	
    	System.out.println(newLogin.getUserName());
    	
    	
    	
        Optional<Login> login = loginRepository.findByUserNameAndPassword(newLogin.getUserName(), newLogin.getPassword());
        
        if (login.isPresent()) {
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    } 
}