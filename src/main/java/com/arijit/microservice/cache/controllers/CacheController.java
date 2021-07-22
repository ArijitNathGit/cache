package com.arijit.microservice.cache.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arijit.microservice.cache.models.User;
import com.arijit.microservice.cache.services.CacheServiceLRU;

@RestController
@RequestMapping(value = "/cache/v1")
public class CacheController implements CacheServiceLRU {
	 
	@Autowired
	private CacheServiceLRU cacheService;
	
	@GetMapping(value = "/get/{userName}")
	public User getUserFromCache(@PathVariable("userName") String userName) {
		return cacheService.getUserFromCache(userName);
	}
	
	@PutMapping(value = "/insert")
	public User putUserToCache(@RequestBody User userDetails) {
		return cacheService.putUserToCache(userDetails);
	}
	
	@DeleteMapping(value = "/delete/{userName}")
	public User evictUserFromCache(@PathVariable("userName") String userName) {
		return cacheService.evictUserFromCache(userName);
	}
}
