What are ENUMS?
===========

An enum type is a type whose fields consist of a fixed set of constants. 
Common examples include compass directions (values of NORTH, SOUTH, EAST, and WEST) and the days of the week.
Because they are constants, the names of an enum type's fields are in uppercase letters.
[via docs.oracle.com](http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)

Why use ENUMS?
==========

 - Cause you can!! ENUMS can simplify alot of code, by allowing you to define a set of constants
 - ENUMS can be used to make code more readable! because instead of checking some obscure variable, you can simply store an enum.
 - ENUMS are commonly used; a good example is the bodytype enum in box2d body. They use enums KINEMATIC,STATIC,DYNAMIC.
 - ENUMS are ridiculously easy to read and understand, most people will understand your code better.
 
What does a java enum look like?
=======
Well, if you're in eclipse, you can simply create a new->Enum and name it appropriately.
Then you just need to define the Enum constants, in capital letters, inside the ```{}``` without any trailing character (read: no semicolon)
Basically it looks like this: ``` public enum Products { CAKE,PIE,BREAD }``` and thats it! now you can define a new variable of type ```Products``` and set it equal to
```Products.CAKE``` for example. You can also check if a given Products variable equals a certain enum. a simply if statement will work, or a switch if you wish to
do something based on which Products enum the variable contains. For instance: ``` if (myProductEnum == Products.CAKE) System.out.println("I Love Cake!");```
It's pretty simple, and worth using.




- By [B3nGr33ni3r](http://twitter.com/b3ngr33ni3r)
