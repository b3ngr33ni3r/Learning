package GameBasics;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sprite extends JLabel {
	

	/**
	 * This serialVersionUID is so that java is happy. its not important to game logic, basics or anything.
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon icon;
	
	//the sprite constructor give it the path to the image, and the position to create it at.
	public Sprite(String path,int x,int y)
	{
		//call the jlabel constructor
		super();
		
		//create the icon
		icon = new ImageIcon(path);
		
		//verify the icon loaded. using built in java stuff
		if (icon.getImageLoadStatus()==java.awt.MediaTracker.ERRORED || icon.getImageLoadStatus()==java.awt.MediaTracker.ABORTED)
		{
			try
			{
				//if it didn't load, throw an exception, which we then catch below
				throw new Exception("ImageIcon Load Error.");
			}
			catch(Exception e)
			{
				//this is the catching of the above error, if it is throw. 
				e.printStackTrace();
				//this closes the application, cause the above error was thrown, meaning something wouldn't be working right.
				System.exit(-100);
			}
		}
		
		//set the jlabel parents icon to our given icon
		super.setIcon(icon);
		
		//set the bounds of the jlabel parent, to the position, size of the image
		super.setBounds(x,y,x+icon.getIconWidth(),y+icon.getIconHeight());
	}
	
	//allow the sprite to be warped. changing its position
	public void warp(int x,int y)
	{
		setLocation(x, y);
		super.repaint();
	}
	
	//hide the sprite
	public void hide()
	{
		setVisible(false);
	}
	
	//show the sprite
	public void show()
	{
		setVisible(true);
	}
	
	
	
}
