package Networking2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	private com.esotericsoftware.kryonet.Server server;
	
	public Main() throws IOException
	{
		server = new com.esotericsoftware.kryonet.Server();
		instantiate();
	}
	
	public void instantiate() throws IOException
	{
		//TODO override to create the main.
	}
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//create a listening server, that sends all connected clients IPADDR : MESSAGE
		Main main = new Main(){
			
			@Override
			public void instantiate() throws IOException
			{
				
				
				
				getServer().start();
				getServer().bind(54555, 54777);
				System.out.println("SERVER UP");
				
				com.esotericsoftware.kryo.Kryo kryo = getServer().getKryo();
				kryo.register(String.class);
				
				getServer().addListener(new com.esotericsoftware.kryonet.Listener() {
					   public void received (com.esotericsoftware.kryonet.Connection connection, Object object) {
					      if (object instanceof String) {
					         String request = (String)object;
					         
					         //send to all clients
					         for (com.esotericsoftware.kryonet.Connection obj : getServer().getConnections())
					        	 if (!obj.equals(connection))
					        	 obj.sendTCP(connection.getRemoteAddressTCP().getAddress()+" : "+request);
					         
					         System.out.println(connection.getRemoteAddressTCP().getAddress()+" : "+request);
					         
					         
					      }
					   }
					});
			}
			
		};
		
		boolean done=false;
		Scanner in = new Scanner(System.in);
		in.useDelimiter("\r\n");//for windows
		while (!done)
		{
			String t = in.next();
			if (t.equals("end") || t.equals("shutdown"))
				done=true;
		}
		
		//last thing, before ending
		in.close();
		main.shutdown();
		System.out.println("SERVER DOWN");
		

	}

	public com.esotericsoftware.kryonet.Server getServer() {
		return server;
	}

	public void setServer(com.esotericsoftware.kryonet.Server server) {
		this.server = server;
	}
	
	public void shutdown()
	{
		getServer().stop();
	}

}
