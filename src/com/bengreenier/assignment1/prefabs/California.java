package com.bengreenier.assignment1.prefabs;

import com.bengreenier.assignment1.regions.State;

public class California extends State {

	/**
	 * Default constructor, requiring you to add Cities/Regions yourself
	 */
	public California() {
		super("Calfornia", "Jerry Brown");
	}
	
	/**
	 * Constructor, adding a few Cities for you, if autoMake is true.
	 * @param autoMake (generate Cities?)
	 */
	public California(boolean autoMake) {
		super("Calfornia", "Jerry Brown");
		if (autoMake)
			addRegion(new Eureka())
			.addRegion(new SanJose())
			.addRegion(new SanFrancisco())
			.addRegion(new LosAngeles())
			.addRegion(new SanDiego());
	}

}
