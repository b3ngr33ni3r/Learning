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
	
	

}
