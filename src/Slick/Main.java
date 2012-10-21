package Slick;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	/**
	 * @deprecated
	 * when set to true, debug messages i define will be printed to System.out. (turns out i don't really use this...)
	 */
	public static Boolean enableDebug=false;
	
	/**
	 * @param args
	 * @author B3N
	 * Throws Slick Exception, so that game elements can throw all the way up the stack.
	 * 
	 */
	public static void main(String[] args) throws SlickException {
		
		//parse the command line arguments, to enable debugging
		for (String arg: args)
			if (arg.equals("debug") || arg.equals("-debug"))
				Main.enableDebug=true;
		
		//create an Application instance  windowname
		AppGameContainer app = new AppGameContainer(new Application("Demo Game"));
		
		//set app display state
		app.setDisplayMode(800,600,false);
		
		
		//start the application
		app.start();
		
	}

}
