ArrayList
==========
__What is it?__
	An ArrayList is a built in class, that is located in java.util, that provides a list like datatype, similar to a c++ vector.
	__Basically__, this class is an array, that is dynamic in size, and can therefore store an infinite (read: a whole lot) of things.
	We can specify what type of data the ArrayList stores, when we declare it, by using the templated arguments (which java calls Generics),
	which look like this: ```ArrayList<int> intList = new ArrayList<int>();``` so, that code creates a variable, and constructs an ArrayList 
	that stores int's. Relatively useful, fairly simple. Then, you might also want to add things to the list: ```intList.add(3);```, or maybe
	remove them: ```intList.remove(3);```, or maybe get the lists size: ```intList.size();```. Woah, pretty straight forward, huh? 
	
	I commonly use ArrayList's to store GameObject's, in a game enviroment where you may need to access created objects, time and time again. This
	way, you can dynamically add or remove things from your game, without needing to use silly arrays, and try to resize arrays, which is a mess.
	
	ArrayList's will also become useful (well, a derived ArrayList class) when we talk about Threading. :)