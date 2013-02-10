package com.bengreenier.assignment3.core;

import java.lang.reflect.Array;

/**
 * I guess what i'm not seeing
 * here is why this is circular..
 * is there something wrong with my 
 * implementation? because if there's
 * no way to loop an array, from what
 * i'm seeing, with these methods.
 * I could make some .getNext methods
 * that would loop, but....
 * 
 * @author B3N
 *
 * @param <T>
 */
public class CircularArrayQueue<T> implements Queue<T> {

	private T[] array;
	private int front;//the highest index thats in use +1. (this is also length)
	
	public CircularArrayQueue() {
		front = 0;
	}
	
	@Override
	public void clear() {
		for (int i=0; i<front; i++)
			array[i] = null;
		
		front = 0;
	}

	@Override
	public boolean isEmpty() {
		return (front == 0 )? true : false;
	}

	@Override
	public boolean contains(T data) {
		for (int i=0; i<front; i++)
			if (array[i].equals(data))
				return true;
		
		return false;
	}

	@SuppressWarnings("unchecked") //cause Array.newInstance() cast is bad..
	@Override
	public void enqueue(T data) {
		if (array == null) {
			array = (T[]) Array.newInstance(data.getClass(), 1);
			array[0] = data;
		} else {
			T[] t = (T[]) Array.newInstance(data.getClass(), array.length*2);
			for (int i=0; i<front; i++)
				t[i] = array[i];
			t[front] = data;
			array = t;
		}
		front++;
	}

	@Override
	public T dequeue() {
		T d = array[0];
		for (int i = 1; i<front; i++)
			array[i-1] = array[i];
		front--;
		return d;
	}

	@Override
	public int size() {
		return front;
	}
	
	@Override
	public String toString() {
		String r = "CircularArrayQueue["+size()+"] {\n";
		for (int i=0;i<front; i++)
			r += array[i].toString()+" , ";
		r+= "\n}";
		return r;
	}
	
	/**
	 * the test for the "circular" array queue
	 * @param args
	 */
	public static void main(String[] args) {
		CircularArrayQueue<Integer> test = new CircularArrayQueue<Integer>();
		test.enqueue(8);
		test.enqueue(6);
		test.enqueue(14);
		System.out.println(test);
		System.out.println("Dequeue: "+test.dequeue());
		System.out.println("size: "+test.size());
		System.out.println(test);
		
	}

	

}
