package com.arijit.microservice.cache.datastructures;

import com.arijit.microservice.cache.models.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CacheNode {
	private User user;
	private CacheNode previous;
	private CacheNode next;
}
