package GameBasics3;

//Custom class to store an integer position vector.
public class Vec2i {
	public int x;
	public int y;
	
	public Vec2i()
	{
		x=0;
		y=0;
	}
	
	public Vec2i(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	//shift the current Vec2i by the given Vec2i. updating the initial one's values.
	public void shift(Vec2i val)
	{
		this.x = this.x+val.x;
		this.y = this.y+val.y;
	}
	
	//statically adds two vec2i's and returns the result
	static public Vec2i adder(Vec2i one,Vec2i two)
	{
		return new Vec2i(one.x+two.x,one.y+two.y);
	}
}
