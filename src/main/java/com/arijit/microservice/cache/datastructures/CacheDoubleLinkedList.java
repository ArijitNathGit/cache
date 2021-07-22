package com.arijit.microservice.cache.datastructures;

import com.arijit.microservice.cache.models.User;

public interface CacheDoubleLinkedList {
	CacheNode addAtEnd(User user);
	CacheNode addAtEnd(CacheNode newNode);
	User removeAndAddAtEnd(CacheNode node);
	User remove();
}
