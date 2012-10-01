Keyboard Motion
===============

Basically, we're going to tweak the GameBasics Tutorial, with some new features.
We want to define our own JLabel, which is a class that can be added to a JFrame.
This way, we can configure a GameObject class, but without needing to worry about dirty, hacky code, to accomplish what we want.
Then we can configure KeyListener's to control the object, allowing user controlled motion.
So, lets begin...

Some classes:
=============
- Main
	+ The class that holds all game runtime configurations, such as a JFrame, and a list of all registered GameObjects
	+ Initialized from ```main(String[] args)``` when we create ```Main main = new Main();```
	+ All GameObject's must be added to the JFrame using ```Main```'s ```register()``` method
- GameObject
	+ The class that defines a game element, that consists of an image that we configure to be key controlled
	+ Uses ```Vec2i``` class to store its position data
	+ a JLabel, which is created from an ImageIcon, and this is what should be displayed as the visual representation of GameObject
	+ Can have ```addKeyListener(new KeyListener(){});``` called and defined on it, so that the visual element can be controlled (moved) via keys
- Vec2i
	+ A utility class, that stores public ints x,y which are used to store integer positions.
	+ Implements a static Vec2i adder method, ```Vec2i adder(Vec2i one, Vec2i two)`` that adds two Vec2i's.
	+ Implements a shift method, ```void shift(Vec2i val)``` to shift a Vec2i instance by another. Essentially adding the val to what we already have.

Explanation:
============
So first off, you might notice that i abandoned the [World] in favor of creating a JFrame in Main. This is cause it simply is
easier, and i didn't feel the need to wrap a JFrame just cause it creates more confusion (and there is plenty of that already)
But, if you want to use the World system, from the GameBasics tutorial, simply use it! xD By that i mean, implement it as a
private member of Main, and instead of doing ```frame.getContentPane().add(obj);``` when you ```main.register()``` do a ```world.register(obj);```
so that the register permiates all the layers. Basically that method would register to main, and then to world. or something simliar.
Anyway, you'll also notice i've ditched Sprite for a more useful class, [GameObject]. This class is way better imo, because it allows more
customization, and could act as a base class for every visiable element of your game. 

So, let's begin to make our way through the code, explaining as we move. We're gunna start at ```public static void main(String[] args) {``` 
as this is the entry point for the program. So, right away, you notice we create a new instance of [Main], called main. Now, i'm sure this is
potentially confusing, as now there is three different things named some variation of main. [Main] is a class, then there is the static method main, which is the program entry point, 
and then there is main, the instance we just created. Take a moment, and try to understand that cause, it's important. Ok. So, moving along, you'll see that the next line is calling register
on the main instance we just made, and passing it a new GameObject, with some defined code. Woah, crazy right? No. If you're stuck, go checkout my
Polymorphism tutorial, and realize that we're doing essentially the same thing that is possible due to polymorphism, with an [annonymous inner class](http://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html).
Basically, we're going to configure the GameObject, without wasting the time doing something like: ```GameObject t = new GameObject(); t.setCrap(); t.configureMoreCrap(); t.etc(); ```
because this way is more streamlined, and we don't need to create a local variable to do it. So, moving along, you see the stupid static final long serialVersionUID which is set to the default value,
because it's not useful to us right now, but eclipse get's sad if we don't put it there. So, really not too important yet, can pretty much just be ignored.
Then, we get the the Overriden method, ```instantiate()```. Basically, this is a method that get's called when the object is created, allowing us to define
code that will execute internally on creation. If you go look in GameObject, you'll notice that the constructor for that class configures some basic stuff, and then calls instantiate().
So, any code we put in the overriden method we are creating back in main, will be called and executed at that point. So we go ahead and configure the Position of
our game element, and set the image, to configure the visual part, so that the user can see, use and interact with our object, because otherwise it's pretty useless. xD
So, now that we've defined where our game object will start, and what it will look like, it's time to configure how the user will control and interact with it.
So to do this, we can simply define a KeyListener, that will take affect when the user clicks on the object. (This behavior is defined in [GameObject] and we'll talk about it later).
So we go ahead and create this new KeyListener, which is an interface, so we need to implement some methods for it. These you can see below, and are documented well [here](http://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html)
Now if you go down to the keyPressed method, you see that we actually do stuff! we handle movement, in one direction at a time (not a good idea for production, but ok for now, till we get there later).
So, the key codes are being retrieved from the given KeyEvent, and then checked against the values for W,A,S,D so that we can control motion via WASD.
each if case calls setPosition (on the GameObject) and then uses the static Vec2i adder, to create a Vec2i that is +/-1 up down left or right of the current position.
This way, when the user holds a key down, the GameObject will move at a rate of 1px every ms (?? might not be a set time, because of how coding works, but its close to that)
and looks like nice fluid movement. More or less. You'll notice that diagonals don't work, and you therefore you can't move in two directions. We'll do that next time.
The we repaint the [GameObject] so that the graphic moves.

To try this out, you'll notice you can't immediately move the object! this is because the object doesn't have focus, and focus is required to have KeyEvents occur.
If you wanted the object to have immediate focus when the game starts, you could simply add ```setFocusable(true); requestFocusInWindow();``` to the instantiate method.
But for now, i've configured it so that the object requires you to click it before you can move it. This is useful for the type of top down games, that have multiple units or towers, or characters under the user's control.
To understand how i've done that, goto the [GameObject] constructor, and see the addMouseListener section, where i tell it to ```requestFocusInWindow();``` on mouseClicked. 
This is a common way to implement focus, so i've done it that way.

Hopefully this provides you a pretty good understanding of the code, but if somethings not clear, here's what i recommend:
- Tweet at [me](http://twitter.com/b3ngr33ni3r)
- Submit an issue on [github](https://github.com/b3ngr33ni3r/Learning/issues/new) with something telling me what tutorial/part you don't get.
- [Google it](http://lmgtfy.com/?q=java+problems)
- Cry openly
- Ask someone else for help!