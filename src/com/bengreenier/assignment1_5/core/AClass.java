package com.bengreenier.assignment1_5.core;

public class AClass<T> {
	  private T data;
	  public AClass(T inA){ data=inA; }
	  public T getA() { return data; }
	  public void setA(T inA) { data=inA; }
	  public String toString() { return "data " + data; }

	  public static void main(String[] args) {
	      Integer myData = new Integer(100);
	      AClass<Integer> myAClass = new AClass<Integer>(myData);
	      System.out.println(myAClass);
	      
	      String myData2 = "hello there";
	      AClass<String> myAClass2 = new AClass<String>(myData2);
	      System.out.println(myAClass2);
	      
	      
	  }
	}
