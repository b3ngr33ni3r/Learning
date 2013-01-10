package com.bengreenier.assignment1.regions;

public abstract class Region {

	/**
	 * a representation of the region name   ex: Texas
	 * protected so that derivations can access it more
	 * easily/traditionally without using the getter/setter.
	 */
	protected String name;
	
	/**
	 * Cosntructor
	 * @param name of the region
	 */
	public Region(String name) {
		this.name = name;
	}
	
	/**
	 * a method to return the population of this region
	 * @return population of region
	 */
	abstract public int getPopulation();
	
	/**
	 * a method to return the area of this region
	 * @return area of region
	 */
	abstract public double getArea();

	/**
	 * a method to return the name of this region
	 * @return name of region
	 */
	public String getName() {
		return name;
	}

	/**
	 * method to set the name of this region
	 * @param name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
