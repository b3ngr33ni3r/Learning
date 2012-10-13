Networking
=========

Hey, so this is a quick and dirty networking server/client tutorial, USING [KRYONET](http://code.google.com/p/kryonet/).
Basically it makes the serialization, transmission, reception, and deserialization of objects over the network, easier.
I decided to use kryonet and the kryo suite because i didn't want to take the time required to convert my objects to serialized
byte arrays, just so that i could use java's built in api. 

so we link in the kryonet library, then we are good to code.

First, create a ```com.esotericsoftware.kryonet.Server``` which will control and configure our server.
Then, we ```.start()``` the server, and ```.bind()``` it to our tcp,udp ports.
Then we create a ```com.esotericsoftware.kryo.Kryo``` object, to assist in the serialization of our objects.
Calling ```.register()``` on this object allows us to specify the classes that we want to be able to transmit, in 
this example, a String is all we use. Then, we add a listener to the server, to define the behavior when a transmission is
received. In our example, we simply output the recieved string, and send back a new string, "yum". Thats all there is to the server.

Then, we create a ```com.esotericsoftware.kryonet.Client``` which controls and configures our client. We ```.start()``` that,
and then ```.connect()``` giving a timeout in ms, an ip (localhost in our example) and tcp,udp ports. then we add a listener
to the client, the define the behavior when a transmission is received from the server. in our case we simply output the
received string.

Finally, we configure a ```Scanner``` to read input from System.in, so that the client can send messages to the server.
We need to set the delimiter for the Scanner to the windows newline delimiter (\r\n) so that it takes a string up until the
user hits enter. We use a while loop to constantly read input, until the user types "EXIT", then we break the loop, ending 
the ability to type data and transmit it to the server. 

Then, simply stop the server and client, and close our Scanner, and we're done, and all cleaned up.

Simple, easy, quick, dirty, etc Networking over tcp.