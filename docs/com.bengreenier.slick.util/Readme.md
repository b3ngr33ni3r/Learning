com.bengreenier.slick.util
=========================

Basically, these classes define some common utilities that i find to be good habits when
working with slick. See what each one does below.




DataGameContainer
-----------------

Implements the functionality of ```org.newdawn.slick.GameContainer``` but also adds the
ability to store ```userData``` within the class, meaning you can easily pass anything to any of
the existing methods that take ```org.newdawn.slick.GameContainer``` as an argument.
To do this, simply create a new ```DataGameContainer```, and when you want to access ```userData```,
cast the methods instance of ```org.newdawn.slick.GameContainer``` back to a ```DataGameContainer``` and call 
```getUserData()``` like so: ```((DataGameContainer) gc).getUserData()``` (where gc is ```org.newdawn.slick.GameContainer```)
There you have it. ```userData```. Oh, to be sure you only cast ```org.newdawn.slick.GameContainer``` to ```DataGameContainer```
when it actually is one, you could check like this: ```if (gc instanceof DataGameContainer)``` then cast.


GameMethods
------------

Defines some key methods to make each ```GameObject``` better handle its own tasks. Basically, we require implementation of
render,update,init, and instantiate as methods. These methods are used in the same context they get used in a ```org.newdawn.slick.Game```
but you first need to define the calls to them in your derived instance of ```org.newdawn.slick.Game```. Basically it looks like this:
```public void update(GameContainer gc,int delta){ for (GameObject obj : GameObjectsArrayList) obj.update(gc,delta); }``` and the same
style for the other methods, except instantiate. Please note that for this to work, your ```org.newdawn.slick.Game``` must be keeping
some sort of ```Collection``` of all ```GameObject```'s added to it. For instantiate, we define this method so that it can be 
```@Override```n, and we then want to be sure each derived ```GameObject```'s constructor calls it, as the last line. This way,
we can better modify a new ```GameObject``` from an anonymous inner class.


GameObject
----------

Abstract class, pulling together all the other ```com.bengreenier.slick.util.*``` to define how a ```GameObject``` should behave.
We basically create this class with a given ```Vector2i``` position, and then we are able to define rendering,update,and init methods
to generate the look and feel we want the ```GameObject``` to have.


Vector2i
--------

Vector class designed to store two integers. Provides basic math operation methods,
for instance adding, subtracting, etc. Additionally contains static methods for ```Vector2i``` basic
math operations, in the event you wish you to math without modifying either ```Vector2i```. We create this class with
two integers, x,y which become the stored values.


ResourceLoader
--------------

ResourceLoading for slick, can currently load ```Image```,```Sound```,and ```SpriteSheet```. The most useful way to use this imo, is to
configure the ResourceLoader to populate from a .res file, and then call the load method to load all the resources needed atm, in the init
method of the game, or the game state you need them for. For instance, i use it as follows:
+ ```com.bengreenier.slick.util.ResourceLoader.singleton.Populate("res/resources.res");``` to tell it what resources to use
+ ```com.bengreenier.slick.util.ResourceLoader.singleton.load();``` on game ```init``` to load all the resources into memory
+ ```Image bkg = (Image) ResourceLoader.singleton.retrieve("res/bkg-solid-white.png");``` to access an ```Image```.

The loader can also be used with existing resources, by calling ```track(<PATH>,<RESOURCE>)``` on them, though this isn't really
that useful. 

If you wish to hardcode all the resources you need to load, rather then Populate from a file,
you can call ```queue(<PATH>,<TYPE>)``` where type is ```ResourceLoader.Type```.

However, if you use .res files, as i do, here is the format for one:
<pre>

IMAGE:res/image.png
IMAGE:res/image2.filetype
SOUND:res/sound.mp3
SOUND:res/sound2.filetype
SPRITESHEET:10x10:res/sheet.png

</pre>
You'll notice that its straightforward, but spritesheet's get the dimensions of a sprite before the path.
Generally its just ```ResourceLoader.Type```:```<FILE PATH>```. One entry per line.