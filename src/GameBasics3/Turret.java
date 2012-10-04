package GameBasics3;

public class Turret extends GameObject {

	/**
	 * friggen make java happy
	 */
	private static final long serialVersionUID = 1L;

	private float bulletSpeed;
	private float movementSpeed;
	private int range;
	
	public Turret(int x,int y)
	{
		super();
		setPosition(new Vec2i(x,y));
		instantiate();
	}
	
	@Override
	public void instantiate()
	{
		//override the GameObjects instantiate with this one...
		setBulletSpeed(8);//arbitrary float system
		setMovementSpeed(4);//arbitrary float system
		setRange(300);//range in pixels
		this.setImage("./src/GameBasics3/turret.png");
	}

	public float getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(float bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}

	public float getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}
	
	
}
