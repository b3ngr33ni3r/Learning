package Networking2;

import java.io.IOException;
import java.util.Scanner;

public class Client {
	private com.esotericsoftware.kryonet.Client client;
	private String server_addr;
	
	public Client() throws IOException
	{
		client = new com.esotericsoftware.kryonet.Client();
		instantiate();
	}
	
	public Client(String server) throws IOException
	{
		client = new com.esotericsoftware.kryonet.Client();
		server_addr = server;
		instantiate();
	}
	
	public void instantiate() throws IOException
	{
		//TODO override to create the main.
	}
	
	public String getServerAddr()
	{
		return server_addr;
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//create a listening server, that sends all connected clients IPADDR : MESSAGE
		String serverstring="";
		
		for (int i=0; i<args.length; i++)
			if (args[i].equals("-server"))
			{
				serverstring = args[i+1];
			}
		
		Client main = new Client(serverstring){
			
			@Override
			public void instantiate() throws IOException
			{
				
				
				
				getClient().start();
				
				if (getServerAddr().equals(""))
					getClient().connect(5000, getClient().discoverHost(54777, 5000), 54555, 54777);
				else
					getClient().connect(5000, getServerAddr(), 54555, 54777);
				
				System.out.println("CLIENT UP");
				com.esotericsoftware.kryo.Kryo kryo = getClient().getKryo();
				kryo.register(String.class);
				
				getClient().addListener(new com.esotericsoftware.kryonet.Listener() {
					   public void received (com.esotericsoftware.kryonet.Connection connection, Object object) {
					      if (object instanceof String) {
					         String request = (String)object;
					        System.out.println(request);
					         
					         
					         
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
			else
			{
				main.getClient().sendTCP(t);
			}
		}
		
		//last thing, before ending
		in.close();
		main.shutdown();
		System.out.println("CLIENT DOWN");

	}

	public com.esotericsoftware.kryonet.Client getClient() {
		return client;
	}

	public void setClient(com.esotericsoftware.kryonet.Client server) {
		this.client = server;
	}
	
	public void shutdown()
	{
		getClient().stop();
	}

}
