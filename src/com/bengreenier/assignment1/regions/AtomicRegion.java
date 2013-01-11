package com.bengreenier.assignment1.regions;

public class AtomicRegion extends Region {

	/**
	 * the population of this region
	 * protected so that derivations can access it more
	 * easily/traditionally without using the getter/setter.
	 */
	protected int population;
	
	/**
	 * the area of this Region
	 * protected so that derivations can access it more
	 * easily/traditionally without using the getter/setter.
	 */
	protected double area;
	
	/**
	 * constructor
	 * @param name the region name
	 * @param population the region population
	 * @param area the region area
	 */
	public AtomicRegion(String name,int population,double area) {
		super(name);
		this.population = population;
		this.area = area;
	}
	
	@Override
	public int getPopulation() {
		return population;
	}

	@Override
	public double getArea() {
		return area;
	}

	/**
	 * set the population of this atomic region
	 * @param population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/**
	 * set the area of this atomic region
	 * @param area to set
	 */
	public void setArea(double area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		String t = "AtomicRegion: {\n" +
				"\t Name: "+getName() +
				"\n\t Population: "+getPopulation()+
				"\n\t Area: "+getArea()+"\n}";
		return t;
	}

}
