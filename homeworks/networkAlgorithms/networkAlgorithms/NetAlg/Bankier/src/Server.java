import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		boolean listening = true;
		Protocol kkp = new Protocol();

		try {
			serverSocket = new ServerSocket(5500);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 5500.");
			System.exit(-1);
		}

		while (listening) {

			new MultiServerThread(serverSocket.accept(), kkp).start();
		}
		serverSocket.close();
	}
}
