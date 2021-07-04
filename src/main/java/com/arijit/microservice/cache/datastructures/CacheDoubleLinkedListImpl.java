package com.arijit.microservice.cache.datastructures;

public class CacheDoubleLinkedListImpl implements CacheDoubleLinkedList {
	private CacheNode head = null, tail = null;
	private int size = 0;

	@Override
	public void addAtEnd(String name) {
		
		CacheNode newNode = new CacheNode(name, null, null);
		
		if( head == null ) {
			head = tail = newNode;
		}
		else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = tail.getNext();
		}
		
		size++;
	}

	@Override
	public void removeAndAddAtEnd(CacheNode node) {
		if( node == null ) return;
		
		
	}

	@Override
	public void remove(String name) {
		
	}	
	
}
