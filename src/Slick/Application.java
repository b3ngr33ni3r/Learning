package Slick;

import java.util.HashMap;

import net.phys2d.math.Vector2f;
import net.phys2d.raw.World;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

//suppress unused for now, since kinematics and dynamics aren't used
@SuppressWarnings("unused")
public class Application extends BasicGame {

	/**
	 * an Actor, which manages all things needed to create a 2d platformer style controlled game element. This is the main player.
	 */
	private Actor player=null;

	/**
	 * an Array, which holds Kinematic elements, which are motion enabled game elements that cannot be interacted with.
	 */
	private Kinematic[] kinematics=null;

	/**
	 * an Array, which holds Dynamic elements, which are game elements that interactable via the player. no constant motion, but are tied to rigidbodies.
	 */
	private Dynamic[] dynamics=null;

	/**
	 * a physics space, were simulations occur.
	 */
	private World world=null;
	
	/**
	 * our constructor that we generally use, to create a new Application.
	 * @param title
	 */
	public Application(String title) {
		super(title);

	}

	/**
	 * our default constructor, that can be used to create an Application.
	 */
	public Application()
	{
		//if it's default, no name given, so name it "Unnamed Application".
		super("Unnamed Application");
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		
		//renders the player
		player.render(arg0, arg1);
		
		//call the render method of all child dynamics
		if (dynamics != null)
		for (Dynamic dyn : dynamics)
		{
			dyn.render(arg0,arg1);
		}
		

	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		
		//create a hashmap, for the playerSprite image locations (can be found on github in the docs/slick/res folder)
		HashMap<String,String> playerSprites = new HashMap<String,String>();
		playerSprites.put("forward","docs/Slick/res/player.png");
		playerSprites.put("reverse", "docs/Slick/res/player-reverse.png");
		playerSprites.put("side", "docs/Slick/res/player-side.png");
		playerSprites.put("fade", "docs/Slick/res/player-fade.png");
		
		//create the player with defined playerSprites hashmap
		player = new Actor(playerSprites);
		
		//create the world (gravity direction, iterations)
		world = new World(new Vector2f(0,10), 20);
		
		//create something to test collisions with
		dynamics = new Dynamic[1];
		dynamics[0]=new Dynamic(Dynamic.Shape.Box, new Vector2f(32,32), new Vector2f(40,40), "docs/Slick/res/box.png");
		
		//add the player to the physics world
		world.add(player.body);
		
		//add the test dynamic to the world
		world.add(dynamics[0].body);

	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		//update the physical world
		world.step(arg1);
		
		
		//update the player
		player.update(arg0,arg1);
		
		//update  all child dynamics
		if (dynamics != null)
		for (Dynamic dyn : dynamics)
		{
			dyn.update(arg0,arg1);
		}
		
		//check if escape is pressed, and if it is, quit.
		if (arg0.getInput().isKeyPressed(Input.KEY_ESCAPE))
			arg0.exit();

	}

}
