import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Server extends Thread {

	protected static ServerSocket serverSocket;
	private int port;
	private Stocare stoc;

	public Server(Stocare stoc, int port) {
		this.stoc = stoc;
		this.port = port;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.start();
	}

	public void run() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				JOptionPane.showMessageDialog(null, "Am fost contactat de "
						+ socket.getInetAddress(), "",
						JOptionPane.PLAIN_MESSAGE);
				Cmmdc c = new Cmmdc(stoc, socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getServerSocketString() {
		return serverSocket.toString();
	}

}
