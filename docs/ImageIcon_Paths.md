ImageIcon Pathing
=================
Since I've been using ImageIcon's in my last two tutorials, i thought it only fair that i explain how the pathing works.
Basically to load the image you should use relative pathing, so that the location for the icon isn't tied to the computer
you're currently on! To do this, you first need to know the path in which your program is running. To get this info, you
can simply paste this line anywhere into your code: ```System.out.println(System.getProperty("user.dir"));```. So that's
where the base of your paths begin. for instance, if my user.dir=b3n/code/java and i give an ImageIcon a path of "./pie.png"
it's saying that the image is located in "b3n/code/java/pie.png". This concept is fairly important, because i had instead
specified a path of "b3n/code/java/pie.png" the program probably would've been unable to find the image, since your system
isn't structured like mine is.