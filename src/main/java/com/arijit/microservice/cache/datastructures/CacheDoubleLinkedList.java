package com.arijit.microservice.cache.datastructures;

public interface CacheDoubleLinkedList {
	void addAtEnd(String name);
	void removeAndAddAtEnd(CacheNode node);
	void remove(String name);
}
