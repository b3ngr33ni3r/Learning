package GameBasics;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

public class World {
	private Dimension windowSize;
	private JFrame windowFrame;
	
	//given the width/height of the window, create it.
	public World(int w,int h)
	{
		//set the size
		windowSize = new Dimension(w,h);
		
		//create the jframe
		windowFrame = new JFrame();
		
		//don't use a layout, use absolute positioning
		windowFrame.setLayout(null);
		
		//tell the jframe to use windowSize for its size
		windowFrame.setSize(windowSize);
		
		//tell the jframe to exit the application when you x-out of it
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make the jframe visible, and not resizable
		windowFrame.setVisible(true);
		windowFrame.setResizable(false);
		
	}
	
	//call this method when you want to add something to the world, like a sprite
	public void register(Component comp)
	{
		windowFrame.getContentPane().add(comp);
		comp.repaint();
	}
	
}
