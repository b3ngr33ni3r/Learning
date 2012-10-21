package Slick;

import java.util.HashMap;

import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.shapes.Box;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Actor {

	public static float MOTION_SPEED=0.6f;


	public Vector2f position=new Vector2f(0,0);
	public Vector2f velocity=new Vector2f(0,0);
	public Vector2f size = new Vector2f(2,2);
	public Body body = new Body(new Box(size.getX(),size.getY()),0);
	private HashMap<String,Image> sprites=null;
	private Image curImage=null;
	

	/**
	 * our default constructor, which uses defaults for all data.
	 * @throws SlickException 
	 */
	public Actor() 
	{
		
	}

	/**
	 * our constructor that is commonly used, requiring an imagePath to define what the Actor will look like.
	 * @param sprites
	 * @throws SlickException 
	 */
	public Actor(HashMap<String,String> givenSprites) throws SlickException
	{
		//create Image's for the given paths, for the givenSprites entries.
		sprites = new HashMap<String,Image>();
		for (String set : givenSprites.keySet())
		{
			sprites.put(set, new Image(givenSprites.get(set)));
		}
		
		//assume the forward key holds the default image
		if (sprites.get("forward") != null)
			curImage = sprites.get("forward");
	}
	/**
	 * handles all the rendering required to show the Actor on the screen.
	 * @param arg0
	 * @param arg1
	 */
	public void render(GameContainer gc, Graphics graphics)
	{
		
		//if the current image is not null, draw it with a scale of 1, at the Actor.position
		if (curImage != null)
			curImage.draw(position.getX(), position.getY(), 1);
		
	}

	/**
	 * handles all logic pertinent to player control/motion. NOT interaction with others.
	 * @param arg0
	 * @param arg1
	 */
	public void update(GameContainer gc, int delta) {
		Input input = gc.getInput();

		if (input.isKeyDown(Input.KEY_W))
		{
			position.add(new Vector2f(0,-MOTION_SPEED*delta));
			body.setPosition(position.getX(),position.getY());
			if (sprites.get("reverse") != null)
				curImage = sprites.get("reverse");
		}

		if (input.isKeyDown(Input.KEY_A))
		{
			position.add(new Vector2f(-MOTION_SPEED*delta,0));
			body.setPosition(position.getX(),position.getY());
			if (sprites.get("side") != null)
				curImage = sprites.get("side");
		}

		if (input.isKeyDown(Input.KEY_S))
		{
			position.add(new Vector2f(0,MOTION_SPEED*delta));
			body.setPosition(position.getX(),position.getY());
			if (sprites.get("forward") != null)
				curImage = sprites.get("forward");
		}

		if (input.isKeyDown(Input.KEY_D))
		{
			position.add(new Vector2f(MOTION_SPEED*delta,0));
			body.setPosition(position.getX(),position.getY());
			if (sprites.get("side") != null)
				curImage = sprites.get("side");
		}
	}

}
