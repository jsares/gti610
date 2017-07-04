package serveur;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.server.SocketSecurityException;

public class Serveur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			ServerSocket ss = new ServerSocket(2009);
			Socket infoClient;
			String msgFromClient;
			DataOutputStream writer;

			infoClient = ss.accept();
					
			BufferedReader br = new BufferedReader (new InputStreamReader (infoClient.getInputStream()));
			msgFromClient = br.readLine();
			
			System.out.println(msgFromClient);
			
			writer = new DataOutputStream(infoClient.getOutputStream());
			writer.writeBytes("fhhjgcjhg");
			
			//writer.flush();
			//ss.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
