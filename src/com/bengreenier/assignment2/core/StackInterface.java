package com.bengreenier.assignment2.core;

/**
 * This interface describes a stack
 * of type T
 * 
 * @author B3N
 *
 * @param <T>
 */
public interface StackInterface<T> {

	/**
	 * Remove the top element
	 */
	public void pop();
	
	/**
	 * Add an element
	 * @param data
	 */
	public void push(T data);
	
	/**
	 * get the top element
	 * @return top element
	 */
	public T peek();
	
	/**
	 * check if the stack contains an element
	 * @param data
	 * @return
	 */
	public boolean contains(T data);
	
	/**
	 * get the length of the stack
	 * @return length
	 */
	public int length();
}
