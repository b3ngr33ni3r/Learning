package Polymorphism;

//this is our base class
public class Animal {
	
	//Store a name for the animal
	private String name;
	
	//Store an age for the animal
	private int age;
	
	//The default animal constructor, sets initial variables
	public Animal()
	{
		this.name="Unknown Species";//cause a generic animal has no name
	}
	
	//Get the animals speak text
	public String speak()
	{
		return "";
	}
	
	//Return the name of the animal
	public String getName()
	{
		return this.name;
	}
	
	//Set the animals name
	public void setName(String name)
	{
		this.name = name;
	}

	//Get the animals age
	public int getAge() 
	{
		return age;
	}

	//Set the animals age
	public void setAge(int age) 
	{
		this.age = age;
	}
}
