package GameBasics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Main {

	
	public static void main(String[] args) {
		
		/* so first, lets define our [World]
		 * this will be a JFrame, with given size, that our game will run inside of.
		 */
		World world = new World(600,500);
		
		/*
		 * then, here's our first sprite. its "extending" a [JLabel], filled with an image.
		 * we need to pass the constructor for [Sprite] 3 variables, a String path, and 2 ints, the position: x,y
		 * See the Polymorphism tutorial if this is confusing to you.
		 * then we go ahead and add a [MouseListener] which is a java listener interface
		 * to do something on a mouse action. In this case, we're going to make
		 * something happen on mouseReleased. so we define that something in the
		 * mouseReleased(MouseEvent e) method.
		 */
		
		Sprite sprite = new Sprite("./src/GameBasics/bomb.png",20,20);
		
		sprite.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Boom! @ "+e.getX()+" , "+e.getY());
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		/*
		 * now, let's add that sprite to the world.
		 */
		world.register(sprite);
		
		
		/*
		 * now, you'll notice you have a bomb on the screen, that can be clicked. upon click, erm rather mouseRelease, the
		 * bomb will write Boom! to the console, followed by the local point within the bomb sprite that you clicked. Basically,
		 * if you click the upper left of the bomb its 0,0 and the bottom right is something like 250,250 or whatever.
		 * This is useful! you could also get the world coordinates of the click, and that would allow you to generate an explosion
		 * at that point, or something like that. But this is the basics of a game, with non linear code. 
		 * 
		 * Hopefully this is of some use to someone....
		 * 
		 * 
		 */
		
	}

}

/*
 * Tutorial 2: Game Basics. Take 1. By B3ngr33ni3r
 * Goal: Understand game logic, and implement a basic click based concept.
 */
