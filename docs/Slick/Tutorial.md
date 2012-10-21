Slick Tutorial
==============
Okay, so this tutorial is going to be about building a basic game using the [slick](http://slick.cokeandcode.com) game engine.
This engine is based on the [lwjgl](http://lwjgl.com) so it's pretty simple to work with, and is low level enough to stay out of
your way when you need it to. 

Alright, so right off the bat we need to define an ```AppGameContainer``` that will be constructed, using a custom class
called ```Application``` that takes it's own argument, which is a string, to be used as the window title. then, we set the screen
display mode, to resize the window, and not to use vsync. then, we start the application. 

Our Application class is extending slicks BasicGame class, so that we can use and define all the functionality neccessary for
a game to work and function. the flow of the code in the Application class begins in the ```init(GameContainer arg0)``` method.
We create the player, from a hashmap of image paths. We also create the physical world, and add both the player, and a box to this
world, so that we can demonstrate collisions. The Application's render method, defines what happens to draw to the window, which in our 
case is as simple as calling the render methods of the elements of our game (namely: player and dynamics[0]). also, our update method
is called asap, at a given time interval of arg1. In this method we first step the world, then call update on the player, and then
on all the dynamics elements. We also check to see if the Escape key is pressed, and if it is we close the application.

Our Actor class is wrapping the functionality of a controlable player in our game, and is what we create in the ```Application.init()``` method.
We parse through the hashMap on construction of the Actor, and we create image's from all the given paths, meaning that all the images get loaded once,
and then stored. the render method of Actor draws one of these images to the screen, in position, based on the user input, and currently facing directions.
the update method handles creation of motion, and handles which sprite should be drawn on the screen. For instance, using the side image occurs when the a or
d keys are pressed. 

Our Dynamic class handles the storage and creation of any dynamic elements of the game, that can be of any of several defined shapes. For now, i've only defined the
box shape, because this is all i need to test collisions. When you create a Dynamic, the constructor is called, given the arguments defined. Basically we require
a shape enum, a size vector, a position vecotr, and an image string. We then load the image from that imageString, and then we create and configure the body
based on the shape enum we're given. The render, and update methods work just as they work everywhere else, update here simply updates the position from the
physical simulation body position. The render method simply draws the image created from imageString.

So, i realize this tutorial writeup isn't particularly in depth, but i did comment all the code, using javadoc, and regular comments. Also, i'm sick, and a little tired.
Perhaps i'll get back to this soon.