package com.arijit.microservice.cache.datastructures;

public class CacheNode {
	private String name;
	private CacheNode previous;
	private CacheNode next;
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public CacheNode getPrevious() { return previous; }
	
	public void setPrevious(CacheNode previous) { this.previous = previous; }
	
	public CacheNode getNext() { return next; }
	
	public void setNext(CacheNode next) { this.next = next; }

	public CacheNode(String name, CacheNode previous, CacheNode next) {
		super();
		this.name = name;
		this.previous = previous;
		this.next = next;
	}
	
	public CacheNode() {}
}
