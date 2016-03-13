import java.io.*;
import java.net.*;

public class Server extends Thread {

	public final static int PORT = 8899;
	protected ServerSocket serverSocket;

	public static void fail(Exception e, String mesaj) {
		System.err.println("ServerRemoteDir" + mesaj + ": " + e);
		System.exit(1);
	}

	public Server() {
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			fail(e, "ERR Creare");
		}
		System.out.println("Server-ul asteapta conexiuni: portul " + PORT);
		this.start();
	}

	public void run() {
		Socket socket_client;
		try {
			for (;;) {
				socket_client = serverSocket.accept();
				Connectare c = new Connectare(socket_client);
			}
		} catch (IOException e) {
			fail(e, "accept");
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}


