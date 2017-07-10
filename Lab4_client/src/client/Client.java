package client;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		System.out.println("Client running...");
		// TODO Auto-generated method stub
		try {
			boolean run = true;
			while (run) {
				Socket clientSocket = new Socket("localhost", 2009);
				String msgFromServer;
				
				BufferedReader readSystem = new BufferedReader (new InputStreamReader (System.in));
				String msgToServer = readSystem.readLine();
				
				if (!msgToServer.equals("/stop")) {
					PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
					printWriter.println(msgToServer);
			
					BufferedReader read = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
					msgFromServer = read.readLine();
					
					System.out.println("msg du serveur: " + msgFromServer);
				} else {
					run = false;
				}
				clientSocket.close();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
