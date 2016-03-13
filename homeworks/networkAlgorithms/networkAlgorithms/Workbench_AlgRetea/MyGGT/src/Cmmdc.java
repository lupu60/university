import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Cmmdc extends Thread {

	private Stocare stoc;
	private Socket clientSocket;
	private BufferedReader in;

	public Cmmdc(Stocare stoc, Socket clientSocket) {
		this.stoc = stoc; // vecinii clientSocket-ului, nr citit pt
							// clientSocket-ul respectiv, actualul cmmdc
		this.clientSocket = clientSocket;
		this.start();
	}

	public void run() {

		try {
			in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		int nr = 0;
		try {
			nr = Integer.parseInt(in.readLine()); // nr primit de la client
		} catch (IOException e) {
			e.printStackTrace();
		}

		isNumberIntroduced(stoc.getNrClient());
		int cmmdcNou = cmmdc(nr, stoc.getCmmdcActual());

		if (cmmdcNou == stoc.getCmmdcActual())
			JOptionPane.showMessageDialog(null, "GGT " + stoc.getCmmdcActual());
		else {
			stoc.setCmmdcActual(cmmdcNou);
			updatareStocareVecini(stoc.getIp1(), stoc.getPort1(), cmmdcNou);
			updatareStocareVecini(stoc.getIp2(), stoc.getPort2(), cmmdcNou);

		}
	}

	private void isNumberIntroduced(int nr) {
		boolean nrIntrodus = false;
		while (!nrIntrodus) {
			if (nr == 0) {
				try {
					System.out
							.println("Inca nu am numar cu care sa calculez, mai astept 5 sec");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else
				nrIntrodus = true; // a primit un nr cu care poate calcula
		}
	}

	private void updatareStocareVecini(String ip, int port, int cmmdcNou) {
		try {
			Socket strim = new Socket(ip, port);
			PrintWriter outtrim = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(strim.getOutputStream())), true);
			outtrim.println(cmmdcNou);
			outtrim.close();
			strim.close();
			JOptionPane.showMessageDialog(null,
					"GGT is  " + stoc.getCmmdcActual());

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null,
					"Nu am putut trimite raspuns pe ip-ul " + ip + " port "
							+ port);
		}
	}

	private int cmmdc(int a, int b) {
		if (a == b)
			return a;
		else if (a > b)
			return cmmdc(a - b, b);
		else
			return cmmdc(a, b - a);
	}
}
