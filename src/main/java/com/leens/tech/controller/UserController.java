package com.leens.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leens.tech.entity.User;
import com.leens.tech.entity.UserResponse;
import com.leens.tech.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	//@PostMapping("/user")
	@PostMapping(
			path = "/user", 
			consumes =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
			    )
	public User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PostMapping(path="/users",
			consumes =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
	            )
	public List<User> addUsers(@RequestBody List<User> users) {
		return userService.createUsers(users);
	}

	@GetMapping(
			value = "/users/{id}",
			consumes =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
	           )
	//@GetMapping("/users/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable int id) {
		Optional<User> user= userService.getUser(id);
		User newUser =user.get();
		UserResponse userResponse = new UserResponse();
		userResponse.setUname(newUser.getUname());
		HttpHeaders header = new HttpHeaders();
		header.add("error code", "200");
		header.add("error desc", "success ");
		
		
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(userResponse);
	}
	
	//@GetMapping("/users")
	@GetMapping(
			value = "/users", 
			consumes =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<User> getAllUsers() {
		return userService.getUsers();
	}
	
	@PutMapping(
			value = "/users", 
			consumes =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces =  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	
	  @DeleteMapping( value="/users/{id}", consumes = {
	  MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces =
	  { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} )
	 
	
	
	public String deleteUser(@PathVariable int  id) {
		userService.deleteUser(id);
		return "User deleted";
	}

}
