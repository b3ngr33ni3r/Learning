package com.bengreenier.slick.util;

import org.newdawn.slick.geom.Shape;


/**
 * REQUIRES GameMethods!!!
 * defines the basic behaviors of a game element, such as positioning, physics bodies, etc.
 * @author B3n
 *
 */
public abstract class GameObject implements GameMethods {
	
	/**
	 * define the different states that a GameObject can be in.
	 * Frozen = motion shouldn't occur
	 * Visible = can render
	 * Hidden = cannot render
	 * @author B3n
	 *
	 */
	public enum State{VISIBLE,HIDDEN,FROZEN};
	
	/**
	 * positioning data
	 */
	private Vector2i position=null;
	
	/**
	 * (optional) userData, if not used, set to null
	 */
	private Object userData=null;
	
	/**
	 * GameObject State. see State enums.
	 */
	private State state=State.VISIBLE;
	
	/**
	 * Shape to verify things
	 */
	public Shape shape = null;
	
	/**
	 * our constructor, nothing special here
	 * @param position the on screen location you wish this element to draw to.
	 */
	public GameObject(Vector2i position)
	{
		this.position = position;
		instantiate();
	}
	
	@Override
	public void instantiate()
	{
		//Do nothing, cause this is a base abstract class
	}

	/**
	 * gets the position Vector2i
	 * @return position Vector2i
	 */
	public Vector2i getPosition() {
		return position;
	}

	/**
	 * set the position Vector2i
	 * @param position a Vector2i to replace our current position with
	 */
	public void setPosition(Vector2i position) {
		this.position = position;
	}

	/**
	 * get the userData Object (may be null)
	 * @return userData Object (may be null)
	 */
	public Object getUserData() {
		return userData;
	}

	/**
	 * set the userData Object
	 * @param userData an Object to replace our current userData with
	 */
	public void setUserData(Object userData) {
		this.userData = userData;
	}

	/**
	 * get the state State
	 * @return state State
	 */
	public State getState() {
		return state;
	}

	/**
	 * set the state State
	 * @param state a State to replace our current state with
	 */
	public void setState(State state) {
		this.state = state;
	}
}
