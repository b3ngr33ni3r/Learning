package Networking;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("********************************");
		System.out.println("* Local server/client response *");
		System.out.println("* demo, server always says yum *");
		System.out.println("* printlns document what is    *");
		System.out.println("* actually happening. -B3n     *");
		System.out.println("********************************");
		
		com.esotericsoftware.kryonet.Server server = new com.esotericsoftware.kryonet.Server();
		server.start();
		server.bind(54555, 54777);
		
		com.esotericsoftware.kryo.Kryo kryo = server.getKryo();
		kryo.register(String.class);
		
		server.addListener(new com.esotericsoftware.kryonet.Listener() {
			   public void received (com.esotericsoftware.kryonet.Connection connection, Object object) {
			      if (object instanceof String) {
			         String request = (String)object;
			         System.out.println("Server GOT: "+request);

			         String response = "Yum";
			         connection.sendTCP(response);
			      }
			   }
			});
		
		
		com.esotericsoftware.kryonet.Client client = new com.esotericsoftware.kryonet.Client();
		client.start();
		client.connect(5000, "127.0.0.1", 54555, 54777);
		
		client.addListener(new com.esotericsoftware.kryonet.Listener() {
			   public void received (com.esotericsoftware.kryonet.Connection connection, Object object) {
			      if (object instanceof String) {
			         String request = (String)object;
			         System.out.println("client GOT: "+request);
			      }
			   }
			});
		
		Scanner in = new Scanner(System.in);//a scanner
		in.useDelimiter("\r\n");//for windows!
		boolean done=false;
		while(!done)
		{
			String t = in.next();
			System.out.print("User said: "+t+"\n");
			
			if (t.equals("EXIT"))
				done=true;
			else
				client.sendTCP(t);
		}
		System.out.println("TERMINATED SERVER SYSTEM.");
		System.out.println("TERMINATED CLIENT SETUP.");
		client.stop();
		server.stop();
		in.close();
		System.out.println("APP HALTED.");
		return;
	}

	


}
