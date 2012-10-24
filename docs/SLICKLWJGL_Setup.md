Configuring Slick+LWJGL in Eclipse
===================================
+ __Download__ [slick](http://slick.cokeandcode.com/downloads/slick.jar) and [lwjgl](http://sourceforge.net/projects/java-game-lib/files/Official%20Releases/LWJGL%202.8.4/lwjgl-2.8.4.zip/download)
+ __Copy__ slick.jar and the lwjgl-version (currently called lwjgl-2.8.4) folder inside the lwjgl zip you downloaded to ```<yourProject>/lib``` create the folder lib if needed.
+ __Open your project__ in eclipse.
+ __Verify__ the lib folder is visible in the package explorer (left side of screen), if it isn't, refresh (right click project, choose refesh [protip: hit f5]).
+ __View your project properties__ (right click your project, choose properties [protip: hit alt+enter]).
+ __Navigate to the ```Java Build Path```__ pane in properties (on the left side of the window).
+ Choose librarys tab, and hit add jar. Navigate to ```<yourProject>/lib``` and choose lwjgl.jar and slick.jar [protip: hold shift and select both], hit ok.
+ Now they're both in the list, hit the drop down arror on the left of "lwjgl.jar" to edit that jar's properties.
+ __Highlight ```Native Library Location```__ and hit edit. in the popup choose workspace, then ```<yourProject>/lib/lwjgl-version/natives/<yourOs>```. then close that popup.
+ Now you're back in the properties window, and ```Native Library Location``` has a value. good. close out of properties.
+ Fire up some slick/lwjgl code and be sure everythings working!
<br>
<br>
Test Code
-------
Some example code to test things are working (Paste into a file named Main.java)
<br>
<code>

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;



public class Main {

	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
		// TODO Auto-generated method stub
		AppGameContainer app = new AppGameContainer(new BasicGame(""){

			@Override
			public void render(GameContainer arg0, Graphics arg1)
					throws SlickException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void init(GameContainer arg0) throws SlickException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void update(GameContainer arg0, int arg1)
					throws SlickException {
				// TODO Auto-generated method stub
				
			}
			
		});
		app.setVerbose(false);
		app.setDisplayMode(800, 600, false);
		app.start();
	}

}

</code>
<br>
<br>
<br>

_I'll edit this as i find deviations from these directions are needed_ (as i'm sure they will be).