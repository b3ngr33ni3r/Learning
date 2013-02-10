package com.bengreenier.assignment3.core;

import java.util.ArrayList;

/**
 * Behavior for a train
 * @author B3N
 *
 */
public class Train {

	private int capacity;
	private float timeUntilNext;
	private ArrayList<Passenger> passengers;
	private Station nextStation;
	private boolean reverse;
	
	public Train(int capacity) {
		this.capacity = capacity;
		this.timeUntilNext = 0;
		this.nextStation = null;
		this.reverse = false;
		passengers = new ArrayList<Passenger>();
	}
	
	public void advance() {
		timeUntilNext--;
		
		if (timeUntilNext<=0) {
			stoppingAt();
			if (!reverse && nextStation.getNext() == null) {
				reverse = true;
				timeUntilNext = nextStation.getPrevTime();
				nextStation = nextStation.getPrev();
				return;
			}
			
			if (reverse && nextStation.getPrev() == null) {
				reverse = false;
				timeUntilNext = nextStation.getNextTime();
				nextStation = nextStation.getNext();
				return;
			}
			
			if (reverse) {
				timeUntilNext = nextStation.getPrevTime();
				nextStation = nextStation.getPrev();
			} else {
				timeUntilNext = nextStation.getNextTime();
				nextStation = nextStation.getNext();
			}
				
			
		}
		
	}
	
	private void stoppingAt() {
		ArrayList<Passenger> clonedPassengers = new ArrayList<Passenger>(passengers);
		int offset = passengers.size();
		
		for (Passenger p : clonedPassengers)
			if (p.getDestination().equals(nextStation))
				passengers.remove(p);
		
		offset -= passengers.size();

		System.out.println(offset+" passengers got off at "+nextStation.getName());
		
		int gotOn = 0;
		
		for (int i=0; i<nextStation.getPassengers().size(); i++)
			if (capacity > passengers.size()) {
				gotOn++;
				passengers.add(nextStation.getPassengers().remove(i));
			}
		
		System.out.println(gotOn+" passengers got on, as well.");
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the timeUntilNext
	 */
	public float getTimeUntilNext() {
		return timeUntilNext;
	}

	/**
	 * @param timeUntilNext the timeUntilNext to set
	 */
	public void setTimeUntilNext(float timeUntilNext) {
		this.timeUntilNext = timeUntilNext;
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
	 * @return the nextStation
	 */
	public Station getNextStation() {
		return nextStation;
	}

	/**
	 * @param nextStation the nextStation to set
	 */
	public void setNextStation(Station nextStation) {
		this.nextStation = nextStation;
	}
	
	
	
}
