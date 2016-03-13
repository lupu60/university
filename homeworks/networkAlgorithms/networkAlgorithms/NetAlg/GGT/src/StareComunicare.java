import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

//initiaza conexiunea dintre un client si un server cu ip=ul si portul din constructor
//stoc apartine clientului, cpntine nr citit de la tastura si ip-urile amibilor vecini

public class StareComunicare extends Thread {

	private Stocare stoc;
	private String ip;
	private int port;

	public StareComunicare(String ip, int port, Stocare stoc) {
		this.ip = ip;
		this.port = port;
		this.stoc = stoc;
		this.start();
	}

	public void run() {
		boolean connected = false;
		Socket s = new Socket();
		PrintWriter out;
		try {
			s = new Socket(ip, port);
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					s.getOutputStream())), true);
			out.println(stoc.getNrClient());
			out.close();
			s.close();
			connected = true;
		} catch (IOException e) {
			System.out.println("M: I could not connect to the server port "
					+ port);
		}
		
		isSocketConnected(connected, s.getInetAddress(), s.getPort());		
	}

	private void isSocketConnected(boolean val, InetAddress ip, int port) {

		if (val)
			System.out
					.println("M: I made a connection with neighbors and have communicated my number to "
							+ ip
							+ " "
							+ " PORTUL "
							+ port);
		else {
			System.out.println("M: wait five seconds ...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			run();
		}
	}
}