package com.arijit.microservice.cache.services;


import com.arijit.microservice.cache.models.User;

public interface CacheServiceLRU {
	User getUserFromCache(String userName);
	User putUserToCache(User userDetails);
	User evictUserFromCache(String userName);
}
