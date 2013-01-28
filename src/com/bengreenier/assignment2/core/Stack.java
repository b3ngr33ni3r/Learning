package com.bengreenier.assignment2.core;

import java.lang.reflect.Array;

/**
 * This is a templated Stack class that implements
 * a StackInterface to create an Array based stack,
 * that allocates more space on each push 
 * (not necessarily the best idea) because this is
 * what the assignment wanted.
 * @author B3N
 *
 * @param <T> any Class.
 */
public class Stack<T> implements StackInterface<T> {

	private T[] array;
	private int index;
	
	public Stack() {
		index=0;
	}
	@Override
	public void pop() {
		array[index-1] = null;
		index--;
	}

	
	@Override
	public void push(T data) {
		@SuppressWarnings("unchecked")
		T[] t = (T[]) Array.newInstance(data.getClass(), index+1);
		
		for (int i=0; i<index;i++)
			t[i] = array[i];
		
		t[index] = data;
		array = t;
		index++;
	}

	@Override
	public T peek() {
		if (index<1)
			return null;
		
		return array[index-1];
	}

	@Override
	public boolean contains(T data) {
		for (int i=0;i<index;i++)
			if (array[i].equals(data))
				return true;
		
		return false;
	}
	@Override
	public int length() {
		return index;
	}
	
	@Override
	public String toString() {
		String t = "Stack<"+array.getClass().getSimpleName()+">["+index+"]{\n";
		for (int i=0;i<index;i++)
			t += "\t"+array[i].toString()+",\n";
		t+="}";
		return t;
	}
	
	/**
	 * entry point to randomly test out the stack
	 * @param args
	 */
	public static void main(String[] args) {
		//number of times to execute,max value to add to stack,min value to add to stack
		int n=150,max=2349,min=0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		//random stack manipulator loop
		for (int count = 0; count < n; count++) {
			int op = (int) (Math.random() * 4);
			int value = (int) (Math.random() * (max-min));
			if (op == 0) {
				System.out.println("Add:\t "+value);
				stack.push(value);
			}else if (op == 1)
				System.out.println("Peek:\t "+stack.peek());
			else if (op == 2) {
				if (stack.peek() != null){
					System.out.println("Pop:\t "+ stack.peek());
					stack.pop();
				}else
					System.out.println("Pop:\t failed [null]");
			}else if (op == 3) {
				System.out.println("Length:\t "+stack.length());
			}else if (op == 4) {
				if (stack.contains(value))
					System.out.println("Contains:\t "+value);
				else
					System.out.println("!Contains:\t "+value);
			}
		}
		
		System.out.println("\n\nThe resulting stack now looks like this:\n"+stack);
		
		
	}

}
