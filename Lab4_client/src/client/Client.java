package client;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String msgFromServer;
			String msgToServer = "bitch conneckt moua";
			
			Socket clientSocket = new Socket("localhost",2009);
			
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());		
			outToServer.writeBytes(msgToServer);
	
			/*BufferedReader read = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
			msgFromServer = read.readLine();
			
			System.out.println("msg du serveur: " + msgFromServer);*/
			
			clientSocket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
