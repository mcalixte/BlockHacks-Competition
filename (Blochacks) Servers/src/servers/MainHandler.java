package servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import refugees.Refugee;

public class MainHandler implements Runnable {
	protected PrintWriter writeToClient;
	protected Socket client;
	protected Scanner kb;
	private static ArrayList <Refugee> mia_refugee = new ArrayList<Refugee>();
	
	public void addToArrayList(Refugee o)
	{
		
	}
	
	
	public MainHandler(Socket s){
		client = s;
		System.out.println("client connected to handler");
		
		try {
			kb = new Scanner(client.getInputStream());
			Thread.sleep(1000);
			writeToClient = new PrintWriter(client.getOutputStream());
		} catch (IOException | InterruptedException e) {
			System.out.println("Couldnt connect");
			e.printStackTrace();
		}
		Thread thread = new Thread(this);
		thread.start();
	}
    public void run() {
		System.out.println("thread is running");
			processRequest();
				}
	public void processRequest() {
		{
			while(true)
			{
				if(kb.hasNext())
				{
					String key = kb.next();
					if(key.equalsIgnoreCase("SendingRefugeeto:")) {
						sendInformation();
					}
					else if(key.equalsIgnoreCase("StoreMIARefugee:"))
						storeInformation();
					else if(key.equalsIgnoreCase("SearchforRefugee:"))
					{
						long fingerPrint=kb.nextLong();
						Refugee tempRef = findRefugee(fingerPrint);
						if(tempRef==null)
							writeToClient.println("Cannotfindfingerprint:");
						else
							writeToClient.println(tempRef);
					}
					writeToClient.flush();
				}
			
					
			}
	
	}
		
	}
	public void sendInformation() {   	
		try {
		   	String ipAddress = kb.next();
		   	int port=kb.nextInt();
			Socket s = new Socket(ipAddress,port);
			writeToClient=new PrintWriter(s.getOutputStream());
			
			
			writeToClient.println("CreatenewRefugee: ");
			writeToClient.println(new Refugee(kb));
			
			writeToClient.flush();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		}
	public Refugee  findRefugee(long fingerPrint) {
		for(int i=0;i<mia_refugee.size();i++)
		{
			if(mia_refugee.get(i).getFingerprint() == fingerPrint)
			{
				writeToClient.println("RefugeeFound: "+mia_refugee.get(i));
				writeToClient.flush();
			}
		}
		return null;
	}
	
	public void storeInformation() {
		System.out.println("store here");
		Refugee temp = new Refugee(kb);
		addToArrayList(temp);
		//System.out.println(temp);
	}
	public void delete(Refugee refugee) {
		for(int i=0;i<mia_refugee.size();i++) {
			if(mia_refugee.get(i).getFingerprint()==refugee.getFingerprint())
				mia_refugee.remove(i);
		}
		
	}

}
