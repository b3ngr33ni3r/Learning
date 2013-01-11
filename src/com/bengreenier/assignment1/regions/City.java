package com.bengreenier.assignment1.regions;

public class City extends AtomicRegion {

	protected String mayorName;
	protected int buildingCount;
	
	/**
	 * one constructor, no building count (set to 0)
	 * @param name
	 * @param population
	 * @param area
	 * @param mayorName
	 */
	public City(String name, int population, double area,String mayorName) {
		super(name, population, area);
		this.buildingCount=0;
	}
	
	/**
	 * one constructor, with building count
	 * @param name
	 * @param population
	 * @param area
	 * @param mayorName
	 * @param buildingCount
	 */
	public City(String name, int population, double area,String mayorName,int buildingCount) {
		super(name, population, area);
		this.buildingCount=buildingCount;
	}

	/**
	 * @return the mayorName
	 */
	public String getMayorName() {
		return mayorName;
	}

	/**
	 * @param mayorName the mayorName to set
	 */
	public void setMayorName(String mayorName) {
		this.mayorName = mayorName;
	}

	/**
	 * @return the buildingCount
	 */
	public int getBuildingCount() {
		return buildingCount;
	}

	/**
	 * @param buildingCount the buildingCount to set
	 */
	public void setBuildingCount(int buildingCount) {
		this.buildingCount = buildingCount;
	}
	
	@Override
	public String toString() {
		String t = "City: {\n" +
				"\t Name: "+getName() +
				"\n\t Population: "+getPopulation()+
				"\n\t Area: "+getArea()+
				"\n\t Mayor Name: "+getMayorName()+
				"\n\t Building Count: "+getBuildingCount()+"\n}";
		return t;
	}
	

}
