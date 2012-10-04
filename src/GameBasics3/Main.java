package GameBasics3;

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
		main.register(new Turret(30,30));//turret is stationary, shoots bullets.
		main.register(new Target(100,100));//target is draggable.
		
	}

}

/* Tutorial 4: GameBasics3 by B3nGr33ni3r
 * Goal: Have a Turret, that shoots at a moveable Target
 * Markdown doc: see docs/GameBasics3/Tutorial.md
 * 
 */
