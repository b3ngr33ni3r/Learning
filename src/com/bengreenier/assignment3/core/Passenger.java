package com.bengreenier.assignment3.core;

/**
 * Behavior for a Passenger
 * @author B3N
 *
 */
public class Passenger {

	private String name;
	private Station dest;
	private float speed;
	
	public Passenger(String name,float speed,Station dest) {
		this.name = name;
		this.dest = dest;
		this.speed = speed;
	}
	
	public String getName() {
		return name;
	}
	
	public Station getDestination() {
		return dest;
	}
	
	public float getSpeed() {
		return speed;
	}
}
