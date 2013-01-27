package com.bengreenier.assignment2.core;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
	private class Node<K>{
		private K item;
		private Node<K> prev,next;
		public Node(K item,Node<K> prev, Node<K> next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
		
		public K item() {
			return item;
		}
		
		public Node<K> next() {
			return next;
		}
		
		public void next(Node<K> next) {
			this.next = next;
		}
		
		public Node<K> prev() {
			return prev;
		}
		
		public void prev(Node<K> prev) {
			this.prev = prev;
		}
	};
	
	private Node<T> head;
	private int length;
	
	public LinkedList() {
		length = 0;
	}
	
	public void push(T item) {
		length++;
		if (head == null)
			head = new Node<T>(item,null,null);
		else
			append(item);
	}
	
	public void pop() {
		if (head == null)
			return;
		
		Node<T> n = head;
		while (n.next()!=null)
			n = n.next();
		n.prev(null);
	}
	
	public T peek() {
		if (head == null)
			return null;
		
		Node<T> n = head;
		while (n.next()!=null)
			n = n.next();
		return n.item();
	}
	
	/**
	 * Please note you can only
	 * call this if head!=null
	 * @param item
	 */
	private void append(T item) {
		Node<T> n = head;
		while (n.next()!=null)
			n = n.next();
		n.next(new Node<T>(item,n,null));
		
	}
	
	public void remove(T item) {
		Node<T> n = head;
		while (n.next() != null) {
			if (n.item().equals(item)) {
				n.prev(n.next());
				return;
			}
			n = n.next();
		}
		return;	
	}
	
	public int length() {
		return length;
	}
	
	public boolean contains(T item) {
		Node<T> n = head;
		while (n.next() != null) {
			if (n.item().equals(item)) {
				return true;
			}
			n = n.next();
		}
		return false;	
	}
	
	public void clear() {
		head = null;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> t = new Iterator<T>(){//TODO for some reason this iterator skips the first item

			private Node<T> current=new Node<T>(null,null,head);
			//private boolean first = true;//TODO this is a bad way to do this
			@Override
			public boolean hasNext() {
				if (current == null)
					return false;
				
				return (current.next()!=null) ? true : false;
			}

			@Override
			public T next() {
				if (current == null)
					return null;
				
				current = current.next();
				return current.item();
			}

			@Override
			public void remove() {
				if (current == null)
					return;
				current.prev(current.next());
				current = current.prev();
			}};
		return t;
	}
	
	@Override
	public String toString() {
		if (head == null)
			return "";
		Node<T> n = head;
		String res="LinkedList["+length()+"]{\n";
		while (n.next() != null) {
			res+= n.item().toString()+",\n";
			n = n.next();
		}
		res += n.item().toString()+"\n}";
		return res;
	}

}
