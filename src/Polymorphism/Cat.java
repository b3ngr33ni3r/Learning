package Polymorphism;

public class Cat extends Animal {
	private String speech;
	
	//Section 5
	public Cat(String name,int age,String speak)
	{
		setName(name);
		setAge(age);
		speech=speak;
	}
	
	@Override
	public String speak()
	{
		return speech;
	}
}
