import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) throws IOException {

		Socket echoSocket = null;
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
			echoSocket = new Socket(ip, 5500);
			out = new DataOutputStream(echoSocket.getOutputStream());
			in = new DataInputStream(echoSocket.getInputStream());
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't connect ");
			System.exit(1);
		}

		DataInputStream stdIn = new DataInputStream(System.in);
		String userInput = "";

		while ((userInput = stdIn.readLine()) != null) {

			out.writeBytes(userInput);
			out.writeByte('\n');
		}

		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}
