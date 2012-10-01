package GameBasics2;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class GameObject extends JLabel {
	/**
	 * define a stupid serialVersionUID so that java is happy. 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vec2i position;
	
	public GameObject()
	{
		super();
		position = new Vec2i();
		this.setFocusable(true);
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				requestFocusInWindow();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		instantiate();
		
	}
	
	public void instantiate() {
		//TODO override this method on initialization of GameObject's if you want to configure something internally.
		//For instance, this can be overridden to configure keyMethod movement. see main (cause i do this)
	}

	

	public void setImage(String path) {
		ImageIcon icon = new ImageIcon(path);
		
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
		this.setIcon(icon);
		this.setBounds(getPosition().x, getPosition().y, getPosition().x + this.getIcon().getIconWidth(), getPosition().y+this.getIcon().getIconHeight());
	}

	public Vec2i getPosition() {
		return position;
	}

	public void setPosition(Vec2i position) {
		this.position = position;
		this.setLocation(position.x, position.y);
	}
	


}
