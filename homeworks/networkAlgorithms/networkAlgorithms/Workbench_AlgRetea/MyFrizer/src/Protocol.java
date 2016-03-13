import java.net.*;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class Protocol {

	private int clienti;
	private int scAsteptareOcupate;

	public Protocol() {

		TimerTask timer = new TimerTask() {

			@Override
			public void run() {

				if (clienti > 0) {
					System.out.println("[srv] se tunde automat clientul "
							+ clienti);
					clienti--;
					System.out.println("nr clienti ramasi: " + clienti);
					if (clienti == 0)
						System.out
								.println("Dupa ce termina, frizerul se duce la sooooooomn");
				}
			}
		};

		Timer myTimer = new Timer();
		myTimer.scheduleAtFixedRate(timer, 10000, 10000);
	}

	public String frizerie(String theInput) {

		String out = null;

		clienti += Integer.parseInt(theInput); // nr de clienti vechi+cei nou
												// veniti
		scAsteptareOcupate = clienti - 1;

		// sunt doar 5 scaune asteptare
		if (scAsteptareOcupate > 5) {
			System.out.println("Sunt cu " + (scAsteptareOcupate - 5)
					+ " mai multi clienti sositi decat scaune disponibilee. "
					+ (scAsteptareOcupate - 5)
					+ " clienti sunt rugati sa revina");
			clienti = 6;
			scAsteptareOcupate = 5;
		}

		System.out.println("Nr de clienti este " + clienti
				+ "(un client este pe scaunul de tuns)");
		System.out.println("Nr scaune ocupate " + scAsteptareOcupate);
		if (clienti != 0) {
			out = " Se tunde clientul:" + clienti;
			clienti--;
		}
		return out;
	}

}
