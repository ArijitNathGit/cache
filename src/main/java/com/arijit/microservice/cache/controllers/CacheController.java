package com.arijit.microservice.cache.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arijit.microservice.cache.models.User;

@RestController
@RequestMapping(value = "/cache")
public class CacheController {
	 
	@GetMapping(value = "/{userName}")
	public User getUserFromCache(@PathVariable("userName") String userName) {
		return new User(userName, "Kolkata");
	}
	
	@PutMapping
	public User putUserToCache(@RequestBody User userDetails) {
		return userDetails;
	}
	
	@DeleteMapping
	public User deleteUserFromCache(@RequestBody User userDetails) {
		return userDetails;
	}
}
