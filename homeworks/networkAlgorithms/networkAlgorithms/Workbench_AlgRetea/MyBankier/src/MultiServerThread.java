import java.net.*;
import java.util.UUID;
import java.io.*;

public class MultiServerThread extends Thread {

	private Socket socket = null;
	Protocol kkp;

	public MultiServerThread(Socket socket, Protocol protocol) {
		super("MultiServerThread");
		this.socket = socket;
		this.kkp = protocol;
	}

	public void run() {

		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(
					socket.getInputStream()));
			PrintStream out = new PrintStream(new BufferedOutputStream(
					socket.getOutputStream(), 1024), false);

			String inputLine, outputLine;

			System.out.println("----------------------------");
			System.out.println("Server side corespunzatoare clientului cu ip "
					+ socket.getInetAddress());

			int[] nrProcRes = new int[2];
			nrProcRes[0] = Protocol.getNrProcese();
			nrProcRes[1] = Protocol.getNrResurse();

			int[] vectorRD = Protocol.getResurseDispnibile();

			if (nrProcRes[0] + nrProcRes[1] == 0)
				System.out
						.println("Trebuie introdus nr de procese si nr de resurse");
			else
				System.out.println("Nr procese " + nrProcRes[0]
						+ " ; nr resurse " + nrProcRes[1]);

			if (vectorRD != null)
				System.out.println("Vector resurse disponibile "
						+ Protocol.displayArray(vectorRD));
			else
				System.out
						.println("Trebuie introdus vectorul de resurse disponibile");

			System.out
					.println("Trebuie introdusi vectorul de resurse ocupate, respectiv cel de resurse cerute specifice clientului cu ip ul"
							+ socket.getInetAddress());

			int[] vectorRO = null; // resurse ocupate
			int[] vectorRC = null; // resurse cerute

			UUID idGenerate = UUID.randomUUID();
			String serial = idGenerate.toString();

			while ((inputLine = in.readLine()) != "0") {

				if (inputLine.equals("Bye"))
					kkp.doProcessing();

				else {
					System.out.println("Am primit de la client: " + inputLine);

					if (nrProcRes[0] + nrProcRes[1] == 0) {
						nrProcRes = kkp.parseVector(inputLine);
						kkp.creareMatrici(nrProcRes);
					} else if (vectorRD == null) {
						vectorRD = kkp.parseVector(inputLine);
						kkp.addToResurseDisponibile(vectorRD);

					} else if (vectorRO == null) {
						vectorRO = kkp.parseVector(inputLine);
						kkp.addToResurseOcupate(serial, vectorRO);

					} else {
						vectorRC = kkp.parseVector(inputLine);
						kkp.addToResurseCerute(serial, vectorRC);	
						Protocol.addClientId(serial, socket.getInetAddress()
								.toString());
					}

					if (vectorRO != null && vectorRC != null) {
						idGenerate = UUID.randomUUID();
						serial = idGenerate.toString();
					}

					Protocol.displayHMClientId();

					out.println(inputLine);
					out.flush();
				}
			}
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
