package GameBasics3;

public class Target extends GameObject {

	/**
	 * happy java now. 
	 */
	private static final long serialVersionUID = 1L;

	public Target(int x,int y)
	{
		super();
		setPosition(new Vec2i(x,y));
		instantiate();
	}
	
	@Override
	public void instantiate()
	{
		
	}
}
