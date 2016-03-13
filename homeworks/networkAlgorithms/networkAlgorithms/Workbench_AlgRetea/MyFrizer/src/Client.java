import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) throws IOException {

		Socket clientSocket = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		String ip = "";
		
		BufferedReader read = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Introduceti ip-ul: ");
		try {
			ip = read.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			
			clientSocket = new Socket(ip, 5500);
			out = new DataOutputStream(clientSocket.getOutputStream());
			in = new DataInputStream(clientSocket.getInputStream());

		} catch (UnknownHostException e) {
			System.err.println("Don't know about host "+ip);
			System.exit(1);
		} catch (IOException e) {
			System.err
					.println("Couldn't get I/O for the connection to "+ip );
			System.exit(1);
		}

		System.out
				.println("Frizerul doarme! Cati clienti tocmai au intrat si l-au trezit? ");
		DataInputStream stdIn = new DataInputStream(System.in);
		String userInput;

		while ((userInput = stdIn.readLine()) != null) {
			System.out.println("Au venit " + userInput + " clienti");
			out.writeBytes(userInput + "\n");
			System.out.println("echo: " + in.readLine());
		}

		out.close();
		in.close();
		stdIn.close();
		clientSocket.close();
	}
}
