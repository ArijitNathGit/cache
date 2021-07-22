package com.arijit.microservice.cache.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arijit.microservice.cache.datastructures.CacheDoubleLinkedList;
import com.arijit.microservice.cache.datastructures.CacheHelperMap;
import com.arijit.microservice.cache.datastructures.CacheNode;
import com.arijit.microservice.cache.models.User;
import com.arijit.microservice.cache.services.CacheServiceLRU;

@Service
public class CacheServiceLRUImpl implements CacheServiceLRU {
	
	@Autowired
	private CacheHelperMap cacheHelperMap;
	
	@Autowired
	private CacheDoubleLinkedList cacheDoubleLinkedList;

	@Override
	public User getUserFromCache(String userName) {
		User returnUser = null;
		
		if( cacheHelperMap.getCacheMap().containsKey(userName) ) {
			CacheNode node = cacheHelperMap.getCacheMap().get(userName);
			returnUser = cacheDoubleLinkedList.removeAndAddAtEnd(node);
		}
		
		return returnUser;
	}

	@Override
	public User putUserToCache(User userDetails) {
		User returnUser = null;
		
		if( cacheHelperMap.getCacheMap().containsKey(userDetails.getName()) ) {
			CacheNode node = cacheHelperMap.getCacheMap().get(userDetails.getName());
			node.setUser(userDetails);
			
			cacheHelperMap.getCacheMap().put(userDetails.getName(), node);
			returnUser = cacheDoubleLinkedList.removeAndAddAtEnd(node);
		}
		else {
			CacheNode node = cacheDoubleLinkedList.addAtEnd(userDetails);
			cacheHelperMap.getCacheMap().put(userDetails.getName(), node);
			
			returnUser = node.getUser();
		}
		
		return returnUser;
	}

	@Override
	public User evictUserFromCache(String userName) {
		User returnUser = null;
		
		if( cacheHelperMap.getCacheMap().containsKey(userName) ) {
			CacheNode node = cacheHelperMap.getCacheMap().remove(userName);
			cacheDoubleLinkedList.remove();
			
			returnUser = node.getUser();
		}
		
		return returnUser;
	}

}
