package ie.dcu.ee417.betteryou.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ie.dcu.ee417.betteryou.entities.Feedback;
import ie.dcu.ee417.betteryou.entities.Users;
import ie.dcu.ee417.betteryou.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public Iterable<Users> getUsers() {
	    return userRepository.findAll();
	}
	
	@GetMapping("/users/{userName}")
	public ResponseEntity<?> getUser(@PathVariable String userName) {
		
		System.out.println("USERNAME : "+userName);
	    try {
	        Users user = userRepository.findByUserName(userName);
	        if (user == null) {
	            // Return a not found response
	            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	        }
	        // Return the user object
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    } catch (Exception e) {
	        // Return an error response
	        return new ResponseEntity<>("Error getting user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	

	
	
		
}
