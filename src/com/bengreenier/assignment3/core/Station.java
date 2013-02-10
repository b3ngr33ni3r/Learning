package com.bengreenier.assignment3.core;

import java.util.ArrayList;

/**
 * defines a station,
 * which is a node in a route
 * @author B3N
 *
 */
public class Station {

	private ArrayList<Passenger> passengers;
	private String name;
	private Station next,prev;
	private float nextTime,prevTime;
	
	public Station(String name,Station next,Station prev,float nextTime,float prevTime) {
		passengers = new ArrayList<Passenger>();
		this.name = name;
		this.next = next;
		this.prev = prev;
		this.nextTime = nextTime;
		this.prevTime = prevTime;
	}

	/**
	 * @return the passengers
	 */
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	/**
	 * @param passengers the passengers to set
	 */
	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
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
	 * @return the next
	 */
	public Station getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Station next) {
		this.next = next;
	}

	/**
	 * @return the prev
	 */
	public Station getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Station prev) {
		this.prev = prev;
	}

	/**
	 * @return the nextTime
	 */
	public float getNextTime() {
		return nextTime;
	}

	/**
	 * @param nextTime the nextTime to set
	 */
	public void setNextTime(float nextTime) {
		this.nextTime = nextTime;
	}

	/**
	 * @return the prevTime
	 */
	public float getPrevTime() {
		return prevTime;
	}

	/**
	 * @param prevTime the prevTime to set
	 */
	public void setPrevTime(float prevTime) {
		this.prevTime = prevTime;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
