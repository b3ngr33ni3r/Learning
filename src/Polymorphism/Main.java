package Polymorphism;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//Section 1
		Dog max = new Dog();
		max.setAge(6);
		max.setName("max");
		
		//Section 2
		String max_speech = max.speak();
		System.out.println(max_speech);
		
		//Section 3
		Cat kitty = new Cat("Mr. Snuggles",2,"Puuuuuuur");
		
		//Section 4
		System.out.println(kitty.speak());
		
	}

}

/* Polymorphism Tutorial: Take 1. By B3nGr33ni3r.
 * 
 * So i broke the code down into some key sections. Sections 1-4 are in Main.java (this file)
 * and section 5 is in Cat.java. The other files are still really important, but i didn't section-ify
 * them, though i did heavily comment Animal.java. So, lets dive into this, and try and make some sense
 * of what's going on. Basically, we've got a "base class" called [Animal], which is inherited or, to use
 * java terms, "extended" by [Cat] and [Dog]. This is useful in the real world because it allows you to
 * define a bunch of data, methods, and stuff in [Animal], our "base class", and then all those definitions
 * will become part of [Cat] and [Dog]. This allows us to do things like say all [Animal]s get a name, an age,
 * and have the ability to try to speak. I say try, because some animals might simply return nothing for their
 * speak method, which would signify their inability to speak. we've also defined some methods that are commonly
 * called "getters and setters" which allow you to get, or set a private member variable. Basically, these are
 * the "safest" way to access data. It's really just a good habit to get into using "getters and setters". So,
 * Anyway, i've defined some that are as follows:
 * 	[Animal]
 * 	+ getName() : String   				This returns a string, that is the animals name
 *  + setName(String) : void   			This returns nothing, but takes a string that gets set as the animals name
 *  + getAge() : int					This returns an int, which is the animals age
 *  + setAge(int) : void				This returns nothing, but takes an int that gets set as the animals name
 *  
 *  So those will let you access the data in [Animal] really easily.
 *  This means we can call any of those methods on any "class" that is "derived" from [Animal], like [Cat] and [Dog].
 *  
 *  So now that that hopefully makes some sense...Lets look at the 5 sections i've marked, in order.
 *  Section 1)
 *  	This is creating a dog. Then, it set's that dog's age, to 6. then, it names that dog max.
 *  	That's really it. All we're doing is calling the methods defined in [Animal] to set some data.
 *  Section 2)
 *  	This is asking max to speak, by calling the speak method on max. Now, since max is a [Dog], and we
 *  	override speak() in the [Dog] class, we are going to be running that speak method, and not the one
 *  	we define in [Animal] by default. So, the result of this method will be "Woof". and then we save "Woof"
 *  	into a String named max_speech. Then, we go ahead and output that string to the System OutputStream.
 *  Section 3)
 *  	Here's something interesting...we defined a "constructor" for cat, (Detailed in section 5) so here we call it.
 *  	Basically, when we create the cat, we pass it a String name, int age, String speech. These are then set as the
 *  	name, age and what is returned by the speak method. The reason you might wanna do something like this, is so that
 *  	you can save youself time. If you always are defining cats with all this data, rather then making it a multiline
 *  	call to do that, you can simply pass these options to the constructor each time, and save some time.
 *  Section 4)
 *  	This is the same as the max_speech part in section 2, but we combine methods, to output the result of the speak method
 *  	directly. Again, this is just a nicer, more efficient way.
 *  Section 5)
 *  	This is a doozy. Remember, this section is in [Cat] and is the "constructor" for it. Basically, we require some variables
 *  	whenever a new [Cat] is made. These variables are used to set the name, set the age, and save what to respond to when speak()
 *  	is called. Basically, we needed to make a new private variable in the [Cat] class to store the speech, and we save it there 
 *  	when a new [Cat] is made. then, when we call speak() on a cat, we call the overriden method speak() and it returns that cats
 *  	speech variable. This means that different cat's can say different things, a feature that the "base class" [Animal] doesn't have,
 *  	and neither does [Dog].
 *  
 */
