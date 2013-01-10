package com.bengreenier.assignment1.core;

import com.bengreenier.assignment1.regions.City;
import com.bengreenier.assignment1.regions.Country;
import com.bengreenier.assignment1.regions.Region;
import com.bengreenier.assignment1.regions.State;

public class Main {

	//ENTRY POINT, create a Main instance, and start it.
	public static void main(String args[]) {
		
		//define a main instance for prefab demos
		//--BEGIN PREFAB MAIN
		Main prefab = new Main(args){
			@Override
			public void start() {
				//this instance of Main is configured to make
				//the usa, and add california to it, with a few
				//major cities. It uses the prefab package to 
				//create these things, since they are constants.
				com.bengreenier.assignment1.prefabs.Usa usa = new com.bengreenier.assignment1.prefabs.Usa();
				usa.addRegion(new com.bengreenier.assignment1.prefabs.California(true));
				
				//output the data that is now directly encapsulated inside usa.
				System.out.println(usa.getName()+" Leader: "+usa.getLeaderName());
				System.out.println(usa.getName()+" Population: "+usa.getPopulation());
				System.out.println(usa.getName()+" Area: "+usa.getArea());
				
				//output the data that is indirectly encapsulated inside usa.
				for (Region r : usa.getRegions()) {
					System.out.println(r.getName()+" Population: "+r.getPopulation());
					System.out.println(r.getName()+" Area: "+r.getArea());
					if (r instanceof City) {
						System.out.println(r.getName()+" is a city");
						System.out.println(r.getName()+" Mayor: "+((City)r).getMayorName());
						System.out.println(r.getName()+" Building Count: "+((City)r).getBuildingCount());
					} else if (r instanceof Country) {
						System.out.println(r.getName()+" is a country");
						System.out.println(r.getName()+" Leader: "+((Country)r).getLeaderName());
					} else if (r instanceof State) {
						System.out.println(r.getName()+" is a state");
						System.out.println(r.getName()+" Governor: "+((State)r).getGovernorName());
					}
					
					System.out.println(r.getName()+" Population: "+r.getPopulation());
					System.out.println(r.getName()+" Area: "+r.getArea());
				}
				
				//end data output
			}
		};
		//--END PREFAB MAIN
		
		//define a mina instance for default demos
		//--BEGIN DEMO MAIN
		Main demo = new Main(args) {
			@Override
			public void start() {
				Country c = new Country("France", "François Hollande");
				//configure the country with 2 states, each with one city.
				c.addRegion(new State("FranceState","GovernorFranceState").addRegion(new City("Paris", 34545, 22.3, "French Dude")))
				.addRegion(new State("StateDeFrance","ImportantMan").addRegion(new City("Alaque",49459,44.3,"Mayor Guy")));
				
				//output the data that is now directly encapsulated inside c.
				System.out.println(c.getName()+" Leader: "+c.getLeaderName());
				System.out.println(c.getName()+" Population: "+c.getPopulation());
				System.out.println(c.getName()+" Area: "+c.getArea());
				
				//output the data that is indirectly encapsulated inside usa.
				for (Region r : c.getRegions()) {
					System.out.println(r.getName()+" Population: "+r.getPopulation());
					System.out.println(r.getName()+" Area: "+r.getArea());
					if (r instanceof City) {
						System.out.println(r.getName()+" is a city");
						System.out.println(r.getName()+" Mayor: "+((City)r).getMayorName());
						System.out.println(r.getName()+" Building Count: "+((City)r).getBuildingCount());
					} else if (r instanceof Country) {
						System.out.println(r.getName()+" is a country");
						System.out.println(r.getName()+" Leader: "+((Country)r).getLeaderName());
					} else if (r instanceof State) {
						System.out.println(r.getName()+" is a state");
						System.out.println(r.getName()+" Governor: "+((State)r).getGovernorName());
					}
					
					System.out.println(r.getName()+" Population: "+r.getPopulation());
					System.out.println(r.getName()+" Area: "+r.getArea());
				}
				
				//end data output
			}
		};
		//-END DEMO MAIN
		
		//sequentially run our demos, first demo, then prefab, then exit.
		demo.start();
		prefab.start();
		
		//please note everything is working perfectly, though the display of the data is not perfect, and not really pretty either.
		//but, the fields and methods are all functioning perfectly.
	}
	
	//arguments, just in case.
	@SuppressWarnings("unused")
	private String[] args;
	
	//constructor
	public Main(String args[]) {
		this.args = args;
		
	}
	
	//executor
	public void start() {
		//override this to define Main instance behavior
		System.out.println("Main Instance Behavior Not Overriden");
	}
}
