Networking2
==========

Again, i'm gunna try and keep it pretty brief, but basically we're going to build off of *Networking* tutorial,
to create a server/client chatroom system. 

Okay. So first things first. we're going to look at Main, which is the server instance. when running Main's main method,
it starts a server. Clients main method starts the client. anyway, we need to do essentially the same things we do in the
other tutorial, but we are going to tweak the listener a bit. checkout around line 49, in Main. Here we are going to
iterate all connections to the server, and broadcast the received message to everyone, except the original sender.
Lines 49-51 handle that, and it's really that simple. Then, we ouput the message to the server System.out, so that
the server can also see what's being said. That's really it for the server, we just need to be sure to shutdown before
we finish the application, so that the threaded server kryonet process finishes.

Onto the client! It's pretty much the same thing, except we simply System.out the received message in the listener,
and we allow specifying -server ADDRESS in the command line. this way you can specify a server, otherwise it will
search the localnet for a valid server. We also use the same basic while loop style Scanner setup that we used in Networking,
so it's all what you've seen before.

Okay, so to demo this, its best to run it from the console. to do this, you can simply run do the following:
- download the jar files, from the same folder that this document is in on github.
- open cmd, and cd to the location of the jar files.
- run ```java -jar server-win.jar``` (to launch the windows server)
- repeat the above process, but run ```java -jar client-win.jar``` instead of ```java -jar server-win.jar```.
- optionally, you can provide -server ADDRESS to the client jar, like this: ```java -jar client-win.jar -server 192.168.1.2```
- you should be able to type into the client, and see the server log it (when you hit enter). also, if you run multiple clients, or have friends run it,
you'll be able to talk/chat with eachother!
- type ```end```  or ```shutdown``` in either the server or client windows to stop the server or client.

Note: use the -win.jar files for windows, and the other files for any other os, or if you're using cygwin.