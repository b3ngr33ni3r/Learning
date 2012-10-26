/**
 * Vector class designed to store two integers. Provides basic math operation methods,
 * for instance adding, subtracting, etc. Additionally contains static methods for Vector2i basic
 * math operations, in the event you wish you to math without modifying either Vector2i.
 * 
 * Very lightweight, and powerful. Most useful for storing position vectors for a pixel based environment
 * where a location is integer x, integer y.
 * 
 * Note: The static methods take arguments logically, so the first argument is the left of the operand, 2nd is the right. 
 * 
 * @version 1
 * @author B3N
 *
 */
public class Vector2i {
	private int x;
	private int y;
	
	/**
	 * default constructor, will set x and y to 0.
	 */
	public Vector2i()
	{
		x=0;
		y=0;
	}
	
	/**
	 * common constructor, requires and x and y
	 * @param x the x location you wish to store
	 * @param y the y location you wish to store
	 */
	public Vector2i(int x,int y)
	{
		this.x=x;
		this.y=y;
	}

	/**
	 * a getter for the privately stored x value
	 * @return the stored x value
	 */
	public int getX() {
		return x;
	}

	/**
	 * a setter for the privately stored x value
	 * @param x the x value you wish to store
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * a getter for the privately stored y value
	 * @return the stored y value
	 */
	public int getY() {
		return y;
	}

	/**
	 * a setter for the privately stored y value
	 * @param y the y value you wish to store
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * addition method, adds the given vector to the referenced vector, storing the result in the referenced one.
	 * @param other
	 */
	public void add(Vector2i other)
	{
		this.x+=other.getX();
		this.y+=other.getY();
	}
	
	/**
	 * multiplication method, multiplies the given vector by the referenced vector, storing the result in the referenced one.
	 * @param other
	 */
	public void multiply(Vector2i other)
	{
		this.x*=other.getX();
		this.y*=other.getY();
	}
	
	/**
	 * subtraction method, subtracts the given vector from the referenced vector, storing the result in the referenced one.
	 * @param other
	 */
	public void subtract(Vector2i other)
	{
		this.x-=other.getX();
		this.y-=other.getY();
	}
	
	/**
	 * division method, divides the referenced vector by the given vector , storing the result in the referenced one, casted to an int.
	 * @param other
	 */
	public void divide(Vector2i other)
	{
		this.x= (int) getX() / other.getX();
		this.y= (int) getY() / other.getY();
	}
	
	@Override
	public String toString()
	{
		return "Vector2i["+getX()+","+getY()+"]";
	}
	
	/**
	 * statically add two Vector2i's, and return the result as a Vector2i
	 * @param one a given Vector2i
	 * @param other a given Vector2i
	 * @return the resulting Vector2i
	 */
	public static Vector2i add(Vector2i one, Vector2i other)
	{
		return new Vector2i(one.getX()+other.getX(),one.getY()+other.getY());
	}
	
	/**
	 * statically multiply two Vector2i's, and return the result as a Vector2i
	 * @param one a given Vector2i
	 * @param other a given Vector2i
	 * @return the resulting Vector2i
	 */
	public static Vector2i multiply(Vector2i one, Vector2i other)
	{
		return new Vector2i(one.getX()*other.getX(),one.getY()*other.getY());
	}
	
	/**
	 * statically subtract two Vector2i's, and return the result as a Vector2i
	 * @param one a given Vector2i
	 * @param other a given Vector2i
	 * @return the resulting Vector2i
	 */
	public static Vector2i subtract(Vector2i one, Vector2i other)
	{
		return new Vector2i(one.getX()-other.getX(),one.getY()-other.getY());
	}
	
	/**
	 * statically divide two Vector2i's, and return the result (casted to ints) as a Vector2i
	 * @param one a given Vector2i
	 * @param other a given Vector2i
	 * @return the resulting Vector2i
	 */
	public static Vector2i divide(Vector2i one, Vector2i other)
	{
		return new Vector2i((int)one.getX()/other.getX(),(int)one.getY()/other.getY());
	}
}
