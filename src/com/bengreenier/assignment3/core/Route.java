package com.bengreenier.assignment3.core;

import java.util.Scanner;

public class Route {

	private Station head;
	private Train train;
	private String name;
	private int size;
	
	public Route(String name) {
		this.name = name;
		this.head = null;
		this.train = new Train(100);
		this.size = 0;
	}
	
	
	public void add(String name,float nextTime,float prevTime) {
		if (head == null) {
			head = new Station(name,null,null,nextTime,prevTime);
			train.setNextStation(head);
			//train.setTimeUntilNext(nextTime);
		} else {
			Station n = head;
			while (n.getNext() != null)
				n = n.getNext();
			n.setNext(new Station(name,null,n,nextTime,prevTime));
		}
			
		size++;
	}
	
	public void remove(Station s) {
		if (head == null)
			return;
		Station n = head;
		while (n.getNext() != null) {
			if (n.equals(s)) {
				n.getPrev().setNext(n.getNext());
				n.getNext().setPrev(n.getPrev());
			}	
			n = n.getNext();
		}
		size--;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Route["+size()+"]{\n");
		Station n = head;
		sb.append(n.toString()+" , ");
		while (n.getNext() != null) {
			n = n.getNext();
			sb.append(n.toString()+" , ");
			
		}
		return sb.toString();
	}

	/**
	 * @return the train
	 */
	public Train getTrain() {
		return train;
	}

	/**
	 * @param train the train to set
	 */
	public void setTrain(Train train) {
		this.train = train;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	

	public void disperseRandomPassengers(int max) {
		int make = (int)(Math.random()*max);
		for (int i=0;i<make;i++) {
			int genid = (int)(Math.random()*getSize());
			Station n = head;
			int count=0;
			while (n.getNext() != null && count < genid) {
				n = n.getNext();
				count++;
			}
			int genid2 = (int)(Math.random()*getSize());
			Station randomStation = head;
			int count2=0;
			while (n.getNext() != null && count2 < genid2) {
				n = n.getNext();
				count2++;
			}
			n.getPassengers().add(new Passenger("Pass"+i,0,randomStation));
		}
			
			
	}
	
	public static void main(String[] args) {
		Route route = new Route("E Line");
		route.add("Copley",100,0);
		route.add("Prudential",56,100);
		route.add("Symphony",200,56);
		route.add("Northeastern",0,200);
		
		System.out.println(route);
	
		Scanner in = new Scanner(System.in);
		int count = 0;
		while (true) {
			
			//generating up here means we get ALOT of passengers, despite us capping it to ten at a time.
			//this is because we call this EVERY iteration of the loop.
			route.disperseRandomPassengers(10);
			
			
			if (count>0) {
				count--;
				route.getTrain().advance();
				
				System.out.println(route.getTrain().getTimeUntilNext()+" until "+route.getTrain().getNextStation()+
						"\n\t passengers on train: "+route.getTrain().getPassengers().size());
			} else {
				
				
				System.out.print("iterate or type 'stop': ");
				String i = in.next();
				if (i.equals("stop")) {
					in.close();
					System.exit(0);
				}else{
					count = Integer.parseInt(i);
				}
					
			}
		}
		
		//route.reverse();
		//System.out.println(route);
		//System.out.println(route.getTrain().getTimeUntilNext()+" "+route.getTrain().getNextStation());
		
		
		
	}

}
