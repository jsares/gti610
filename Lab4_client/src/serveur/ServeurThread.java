package serveur;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServeurThread extends Thread {
	private Socket infoClient;
	
	public ServeurThread(Socket _infoClient) {
		infoClient = _infoClient;
	}
	
	public void run() {
		System.out.println("Server thread running for " + infoClient.getRemoteSocketAddress() + "...");
		
		try {
			String msgFromClient;
			
			BufferedReader br = new BufferedReader (new InputStreamReader (infoClient.getInputStream()));
			msgFromClient = br.readLine();
			
			System.out.println("Serveur: " + msgFromClient);
			
			PrintWriter printWriter = new PrintWriter(infoClient.getOutputStream(), true);
			printWriter.println(msgFromClient.toUpperCase());
			
			System.out.println("Serveur: " + msgFromClient.toUpperCase());
			
			infoClient.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			try {
				System.out.println("Client aborted connection!");
				infoClient.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
