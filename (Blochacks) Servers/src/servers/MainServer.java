package servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	 private ServerSocket server;
	 public MainServer() {
	
		try {
			server = new ServerSocket(4242);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		listenToNewConnections();
	 }
	
	
	public  void listenToNewConnections() {
	
		while(true)
		{
			try {
				Socket x = server.accept();
				System.out.println("connection established");
				new MainHandler(x);
				} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	
}
