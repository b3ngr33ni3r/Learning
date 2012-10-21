package Slick;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.shapes.Box;

public class Dynamic {
	//the defined available shapes.
	enum Shape{Circle,Box,Line,Rectangle,Triangle,Capsule};
	
	public Body body = null;
	public Image image = null;
	public Vector2f position = new Vector2f();
	/**
	 * our constructor to create dynamic bodies, that will be capable of generating basically any user interactive object.
	 * @param shape
	 * @param size
	 * @param position
	 * @param imagePath
	 * @throws SlickException
	 */
	public Dynamic(Shape shape, Vector2f size, Vector2f position, String imagePath) throws SlickException
	{
		//set the image from the imagePath, scaled to size
		image = new Image(imagePath).getScaledCopy((int)size.getX(), (int)size.getY());
		
		//set the position to the given position
		this.position = position;
		
		//create the body for a box, using mass=1
		if (shape == Shape.Box)
		{
			body = new Body(new Box(size.getX(),size.getY()),1);
			body.setPosition(position.getX(),position.getY());
		}
	}

	/**
	 * the render method, which draws the Dynamic
	 * @param arg0
	 * @param arg1
	 */
	public void render(GameContainer arg0, Graphics arg1) {
		if (image != null)
			image.draw(position.getX(),position.getY(),1);
		
	}

	/**
	 * update the dynamics situation, calld on application update.
	 * @param arg0
	 * @param arg1
	 */
	public void update(GameContainer arg0, int arg1) {
		position.set(body.getPosition());
		
	}
	
}
