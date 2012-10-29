package com.bengreenier.slick.util;

import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;

/**
 * REQUIRES: SLICK LIBRARY!!
 * 
 * DataGameContainer wraps GameContainer from org.newdawn.slick.GameContainer to 
 * allow the inclusion of a userData Object. this way, you can pass around a DataGameContainer
 * and have access to everything a GameContainer has, plus some other object. Pretty useful.
 * @author B3n
 *
 */
public abstract class DataGameContainer extends GameContainer {

	/**
	 * the userData we can optionally store
	 */
	private Object userData=null;
	
	/**
	 * our constructor, simply matching the GameContainer constructor
	 * @param game an instance of org.newdawn.slick.Game which is required by the GameContainer constructor, and therefore, our DataGameContainer constructor
	 */
	public DataGameContainer(Game game) {
		super(game);
		instantiate();
	}
	
	
	/**
	 * default empty method that can optionally be overridden, to better configure this class when it's used as an anonymous inner class.
	 */
	public void instantiate()
	{
		//TODO override this if you wish.
	}
	
	/**
	 * store some userData
	 * @param data Object you wish to store
	 */
	public void setUserData(Object data)
	{
		userData = data;
	}
	
	/**
	 * get some userData
	 * @return userData, an Object stored.
	 */
	public Object getUserData()
	{
		return userData;
	}
}
