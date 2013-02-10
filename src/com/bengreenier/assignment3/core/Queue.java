package com.bengreenier.assignment3.core;

/**
 * the interface for methods
 * that are in a queue
 * @author B3N
 *
 * @param <T>
 */
public interface Queue<T>  {
	public void clear();
	public boolean isEmpty();
	public int size();
	public boolean contains(T data);
	public void enqueue(T data);
	public T dequeue();
	
}
