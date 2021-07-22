package com.arijit.microservice.cache.datastructures;

import org.springframework.stereotype.Service;

import com.arijit.microservice.cache.models.User;

@Service
public class CacheDoubleLinkedListImpl implements CacheDoubleLinkedList {
	private CacheNode head = null, tail = null;
	private int size;

	@Override
	public CacheNode addAtEnd(User user) {
		
		CacheNode newNode = new CacheNode(user, null, null);
		
		if( head == null ) {
			head = tail = newNode;
		}
		else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = tail.getNext();
		}
		
		size++;
		
		return newNode;
	}
	
	@Override
	public CacheNode addAtEnd(CacheNode newNode) {		
		if( head == null ) {
			head = tail = newNode;
		}
		else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = tail.getNext();
		}
		
		size++;
		
		return newNode;
	}

	@Override
	public User removeAndAddAtEnd(CacheNode node) {
		if( node == null || size == 0 ) return null;
		if( size == 1 || node == tail ) return node.getUser(); 
		
		if( node == head ) {
			node.getNext().setPrevious(null);
			
			head = head.getNext();
		}
		else {
			node.getPrevious().setNext(node.getNext());
			node.getNext().setPrevious(node.getPrevious());
		}
		
		addAtEnd(node);
		
		return node.getUser();
	}

	@Override
	public User remove() {
		if( head == null || size == 0 ) return null;
		
		User returnUser = head.getUser();
		
		head = head.getNext();
		head.setPrevious(null);
		size--;
		return returnUser;
	}	
	
}
