import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Connectare extends Thread {

	//protected DataInputStream in;
	//protected DataOutputStream out;
	DataInputStream in;
	PrintStream out;
	Socket socketClient;

	public Connectare(Socket socket_client) {

		socketClient = socket_client;

		try {
			//in = new DataInputStream(socketClient.getInputStream());
			// out = new DataOutputStream(socketClient.getOutputStream());
			in = new DataInputStream(new BufferedInputStream(
					socketClient.getInputStream()));
			out = new PrintStream(new BufferedOutputStream(
					socketClient.getOutputStream(), 1024), false);
		} catch (IOException e0) {
			try {
				socketClient.close();
			} catch (IOException e1) {
				;
			}
			System.err.println("Server citire socket " + e0);
			return;
		}
		this.start();
	}

	public static boolean isFilenameValid(String file) {
		File f = new File(file);
		try {
			f.getCanonicalPath();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public void run() {
		try {
			// int nr_oct = in.readInt();
			// byte[] b = new byte[nr_oct];
			// String director = new String(b, 0);
			// System.out.println(director);

			String director = in.readLine();
			System.out.println("server_"+director+"_");
			if (isFilenameValid(director)) {
				File f = new File(director);
				System.out.println("este un directory");
				if (f.isDirectory()) {
					String[] rezumat = f.list();
				
					String s = new String();
					for (int i = 0; i < rezumat.length; i++)
						s += rezumat[i] + "\n";
					System.out.println("rezumat_"+s+"_");
					// b = new byte[s.length()];
					// s.getBytes(0, s.length(), b, 0);

					// out.writeInt(s.length());
					// out.write(b);
					out.println(s);
				}
			} else
				System.out.println("Input-ul dvs nu corespunde unui director");
		} catch (IOException e0) {
			;
		} finally {
			try {
				socketClient.close();
			} catch (IOException e1) {
				;
			}
		}
	}
}
