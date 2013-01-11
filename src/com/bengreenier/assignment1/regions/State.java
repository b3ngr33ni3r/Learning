package com.bengreenier.assignment1.regions;

public class State extends ContainerRegion {

	protected String governorName;
	
	/**
	 * our constructor
	 * @param name
	 * @param governorName
	 */
	public State(String name,String governorName) {
		super(name);
		this.governorName = governorName;
	}

	/**
	 * @return the governorName
	 */
	public String getGovernorName() {
		return governorName;
	}

	/**
	 * @param governorName the governorName to set
	 */
	public void setGovernorName(String governorName) {
		this.governorName = governorName;
	}
	
	@Override
	public String toString() {
		String t = "State: {\n" +
				"\t Name: "+getName() +
				"\n\t Population: "+getPopulation()+
				"\n\t Area: "+getArea()+
				"\n\t Governor Name: "+getGovernorName()+"\n}";
		return t;
	}

}
