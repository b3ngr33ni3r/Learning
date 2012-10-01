package GameBasics2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Main {

	private ArrayList<GameObject> objects;
	private JFrame frame;
	
	public Main()
	{
		objects = new ArrayList<GameObject>();
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(600,500);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void register(GameObject obj)
	{
		objects.add(obj);
		frame.getContentPane().add(obj);
		obj.repaint();
	}
	
	public boolean unregister(GameObject obj)
	{
		frame.getContentPane().remove(obj);
		return objects.remove(obj);
	}
	
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.register(new GameObject(){

			/**
			 * gotta do this every time we generate a game object because java is silly.
			 */
			private static final long serialVersionUID = 1L;
			
			/*
			 * override the default instantiate method, to configure the keyboard movement for this guy.
			 * @see GameBasics2.GameObject#instantiate()
			 */
			@Override
			public void instantiate()
			{
				
				//set the position, and the image.
				setPosition(new Vec2i(40,40));
				setImage("./src/GameBasics/bomb.png");
				
				
				//add a key listener, so we can define some key actions
				addKeyListener(new KeyListener(){

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode()==87)//87 is the keycode for w
							setPosition(Vec2i.adder(getPosition(),new Vec2i(0,-1)));
						if (e.getKeyCode()==83)//keycode for s
							setPosition(Vec2i.adder(getPosition(),new Vec2i(0,1)));
						if (e.getKeyCode()==65)//keycode for a
							setPosition(Vec2i.adder(getPosition(),new Vec2i(-1,0)));
						if (e.getKeyCode()==68)//keycode for d
							setPosition(Vec2i.adder(getPosition(),new Vec2i(1,0)));
						//we've moved the position above, so we need to redraw
						repaint();
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				//once we're all defined, repaint the damn thing!
				repaint();
			}
			
		});
		
	}

}

/* Tutorial 3: GameBasics2 by B3nGr33ni3r
 * Goal: Manufacture a JComponent class that can be added to a JFrame, and manipulated via the Keyboard
 * Markdown doc: see docs/GameBasics2/Tutorial.md
 * 
 */
