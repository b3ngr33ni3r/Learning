package com.bengreenier.slick.util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * REQUIRES SLICK!!!
 * 
 * Interface defining the GameMethods that all elements MUST have.
 * @author B3n
 *
 */
public interface GameMethods {
	/**
	 * called each frame to render the element
	 * @param gc GameContainer this is inside
	 * @param g Graphics buffer to draw to
	 */
	public void render(GameContainer gc, Graphics g);
	
	/**
	 * called asap (each game loop) to do whatever
	 * @param gc GameContainer this is inside
	 * @param delta time since last call
	 */
	public void update(GameContainer gc,int delta);
	
	/**
	 * called on program default execute, can be recalled. should load/initialize things
	 * @param gc GameContainer this is inside
	 */
	public void init(GameContainer gc);
	
	/**
	 * called as the last line in each game elements constructor (Or, should be, if the game element is to spec)
	 */
	public void instantiate();
}
