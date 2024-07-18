package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.entity.Users;
import com.project.service.UsersService;
import com.wakefit.ecommerce.entity.User;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UsersController {
	@Autowired
	private UsersService userv;
	
	@PostMapping("/Users/addUsers")
	public ResponseEntity<Users> saveUsers(@Valid @RequestBody Users users)    // response is give record to postman
	{
		return new ResponseEntity<Users>(userv.CreatUsersDetail(users),HttpStatus.CREATED);
	}
	
	@GetMapping("/Users/get/{userID}")
	public ResponseEntity<Users> getUsers(@PathVariable("userID")  Long userID)    // response is give record to postman
	{
		return new ResponseEntity<Users>(userv.getUsersDeatil(userID),HttpStatus.OK);
	}
	
	@DeleteMapping("/Users/remove/{userID}")
	public ResponseEntity<String> deleteUsers(@PathVariable("userID")  Long userID)    // response is give record to postman
	{
		userv.deleteUsersDetail(userID);
		
		return new ResponseEntity<String>("Delete succefull..", HttpStatus.OK);
	}
	@PutMapping("/Users/update/{userID}")
	public ResponseEntity<String> updatedUsers(@PathVariable("userID")  Long userID,@Valid @RequestBody Users users)    // response is give record to postman
	{
		userv.updateUsersDetail(users, userID);
		
		return new ResponseEntity<String>("update succesfully..", HttpStatus.OK);
	}


	 @GetMapping("/User/all")
	    public List<Users> getAllUsers() {
	        return userv.getAllUsers();
	    }
}
