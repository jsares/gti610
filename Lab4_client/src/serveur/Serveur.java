package serveur;
import java.io.IOException;
import java.net.ServerSocket;

public class Serveur {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(2009);
			
			System.out.println("Server running...");
			
			while (true) {
				new ServeurThread(ss.accept()).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
