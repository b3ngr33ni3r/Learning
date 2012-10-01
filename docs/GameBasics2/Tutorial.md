Keyboard Motion
===============

Basically, we're going to tweak the GameBasics Tutorial, with some new features.
We want to define our own JComponent, which is a class that can be added to a JFrame.
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
	+ Stores an Image, which is created from an ImageIcon, and this is what should be displayed as the visual representation of GameObject
	+ Can have ```addKeyListener(new KeyListener(){});``` called and defined on it, so that the visual element can be controlled (moved) via keys
- Vec2i
	+ A utility class, that stores public ints x,y which are used to store integer positions.
	+ Implements a static Vec2i adder method, ```Vec2i adder(Vec2i one, Vec2i two)`` that adds two Vec2i's.
	+ Implements a shift method, ```void shift(Vec2i val)``` to shift a Vec2i instance by another. Essentially adding the val to what we already have.
