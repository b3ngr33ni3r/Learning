package com.bengreenier.assignment1.regions;

public class ContainerRegion extends Region {

	/**
	 * Array of all the regions inside this container region
	 * wish this was an ArrayList
	 * protected so that derivations can access it more
	 * easily/traditionally without using the getter/setter.
	 */
	protected Region[] regions;
	
	/**
	 * Constructor
	 * @param name of region
	 */
	public ContainerRegion(String name) {
		super(name);
	}
	
	@Override
	public int getPopulation() {
		int counter = 0;
		for (Region r : regions)
			counter+= r.getPopulation();
		
		return counter;
	}

	@Override
	public double getArea() {
		double counter = 0;
		for (Region r : regions)
			counter+= r.getArea();
		
		return counter;
	}

	/**
	 * a method to set the region array for this container
	 * @param regions array to set
	 */
	public void setRegions(Region[] regions) {
		//cloning should allow the regions to be destroyed,
		//instead of having to stay in memory. Potentially
		//more efficient i believe.
		this.regions = regions.clone();
	}
	
	/**
	 * a method to get the region array for this container
	 * @return regions array
	 */
	public Region[] getRegions() {
		return this.regions;
	}
	
	/**
	 * a method to add a region to the region array for this container
	 * @param region to add to regions array
	 */
	public ContainerRegion addRegion(Region region) {
		Region[] t;
		if (regions!=null) {
			t = new Region[regions.length + 1];
			int index=0;
			for (Region r: regions)
			{
				t[index] = r;
				index++;
			}
			
			t[index]=region;
		}else {
			t = new Region[1];
			t[0] = region;
		}
		
		//cloning should allow the regions to be destroyed,
		//instead of having to stay in memory. Potentially
		//more efficient i believe.
		regions = t.clone();
		
		//doing this allow chain-ability for these commands.
		//so you can .addRegion().addRegion().addRegion().getPopulation()
		//if you so desire. otherwise, ignore the returned instance.
		return this;
	}
	
	
	

}
