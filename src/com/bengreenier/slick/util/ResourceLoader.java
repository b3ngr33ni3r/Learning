package com.bengreenier.slick.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

/**
 * Basic Resource loader, can currently handle Sound and Image and SpriteSheet
 * might not always be perfect.
 * 
 * Singleton class.
 * 
 * 
 * @version 1.3
 * @author B3N
 *
 */
public class ResourceLoader {

	public enum Type{IMAGE,SOUND,SPRITESHEET};
	private class Request{
		public String path;
		public Type type;
		public Vector2i dimension = null;
		public Request(String path,Type type)
		{
			this.type = type;
			this.path = path;
		}
		public Request(String path, Type type, Vector2i dimension)
		{
			this.type = type;
			this.path = path;
			this.dimension = dimension;
		}
	}
	
	public static volatile ResourceLoader singleton=new ResourceLoader();
	private ConcurrentHashMap<String,Object> resources;
	private ConcurrentLinkedQueue<Request> loadRequests;
	
	/**
	 * costruct our singleton class
	 */
	private ResourceLoader()
	{
			resources = new ConcurrentHashMap<String,Object>();	
			loadRequests = new ConcurrentLinkedQueue<Request>();
	}
	
	/**
	 * get our singleton class, constructing it if it isn't constructed
	 * @return ResourceLoader, our singleton class
	 */
	public ResourceLoader getSingleton()
	{
		if (singleton==null)
			singleton = new ResourceLoader();
		
		return singleton;
	}
	
	/**
	 * register an existing (loaded) resource with the ResourceLoader
	 * @param name a human readable name for the resource, used to identify it for untracking later, if needed
	 * @param resource the resource, casted to an Object, since it could be any type
	 */
	public void track(String name, Object resource)
	{
		
		getSingleton().resources.put(name,resource);
	}
	
	/**
	 * unregister an existing (loaded) resource from the ResourceLoader
	 * @param name the human readable name you gave the resource, upon calling track method
	 */
	public void untrack(String name)
	{
		if (getSingleton().resources.containsKey(name))
			getSingleton().resources.remove(name);
	}

	/**
	 * Schedule a resource to be loaded, and retrieve-able after load.
	 * @param path the filepath to the resource (relative to the build location)
	 * @param type the enum Type of the resource, ex: IMAGE or SOUND
	 */
	public void queue(String path,Type type)
	{
		getSingleton().loadRequests.add(new Request(path,type));
	}
	
	/**
	 * load all the loadRequests so that they are retrieve-able
	 * Version 1 of this method, as concurrecy might cause not all to load.
	 * 
	 */
	public void load()
	{
		//this might not always function correctly due to concurrency. 
		while (!getSingleton().loadRequests.isEmpty())
		{
			try
			{
				Request req = getSingleton().loadRequests.poll();
				switch(req.type)
				{
				case SOUND:
					getSingleton().resources.put(req.path, new Sound(req.path));
					break;
				case IMAGE:
					getSingleton().resources.put(req.path, new Image(req.path));
					break;
				case SPRITESHEET:
					getSingleton().resources.put(req.path, new SpriteSheet(new Image(req.path),req.dimension.getX(),req.dimension.getY()));
					break;
				}
				
			}catch(SlickException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * sadly, this retrieve requires you to cast our resource back, after, using 
	 * something like Object o = retrieve("name"); if (o instanceof Image) Image myImage=(Image)o;
	 * @param name the name of the resource, which is the path usually, unless you self track it.
	 * @return the Object looked up via name
	 */
	public Object retrieve(String name)
	{
		return getSingleton().resources.get(name);
	}
	
	/**
	 * populate given the file structure of type:path\n
	 * @param filename the file to open to read this structure of loading
	 */
	public void Populate(String filename)
	{
		Path path = Paths.get(filename);
		
		try (InputStream in = Files.newInputStream(path);
		    BufferedReader reader =
		      new BufferedReader(new InputStreamReader(in))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {

		    	String type = line.split(":")[0];
		    	
		    	if (Type.valueOf(type)==Type.SPRITESHEET)
		    	{
		    		String dim = line.split(":")[1];
		    		Vector2i vec = new Vector2i(Integer.parseInt(dim.split("x")[0]),Integer.parseInt(dim.split("x")[1]));
		    		String filepath = line.split(":")[2];
			    	getSingleton().loadRequests.add(new Request(filepath,Type.valueOf(type),vec));
		    	}else{
		    		String filepath = line.split(":")[1];
			    	getSingleton().loadRequests.add(new Request(filepath,Type.valueOf(type)));
		    	}
		    	
		    	
		    	
		    }
		} catch (IOException x) {
		    x.printStackTrace();
		}
	}
	
}
