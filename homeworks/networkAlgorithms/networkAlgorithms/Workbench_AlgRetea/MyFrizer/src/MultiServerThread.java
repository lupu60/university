import java.net.*;
import java.io.*;

public class MultiServerThread extends Thread {

	private Socket socket = null;
	private Protocol protocol;

	public MultiServerThread(Socket socket, Protocol p) {
		super("MultiServerThread");
		this.socket = socket;
		this.protocol = p;
	}

	public void run() {

		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(
					socket.getInputStream()));
			PrintStream out = new PrintStream(new BufferedOutputStream(
					socket.getOutputStream(), 1024), false);

			String inputLine, outputLine;

			while ((inputLine = in.readLine()) != null) {
				System.out.println("--------");
				System.out
						.println("Informatii primite de la clientul cu ip-ul "
								+ socket.getInetAddress());
				outputLine = protocol.frizerie(inputLine);
				out.println(outputLine);
				out.flush();
			}

			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
