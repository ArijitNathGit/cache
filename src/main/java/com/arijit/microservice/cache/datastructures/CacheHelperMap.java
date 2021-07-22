package com.arijit.microservice.cache.datastructures;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import lombok.Getter;

@Repository
@Getter
public class CacheHelperMap {
	private Map<String, CacheNode> cacheMap;
	
	@PostConstruct
	public void init() {
		cacheMap = new ConcurrentHashMap<>();
	}
	
	public void add(String name, CacheNode node) {
		cacheMap.put(name, node);
	}
	
	public void remove(String name) {
		cacheMap.remove(name);
	}
}
