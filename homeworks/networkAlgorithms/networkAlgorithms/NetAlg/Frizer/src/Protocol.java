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
					System.out.println("[srv] automatic client is clipped "
							+ clienti);
					clienti--;
					System.out.println("Nr remaining customers: " + clienti);
					if (clienti == 0)
						System.out
								.println("After the finish, the barber goes to sleep");
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
			System.out.println((scAsteptareOcupate - 5)
					+ "customers are more reach than the number of available jobs. "
					+ (scAsteptareOcupate - 5)
					+ " customers are asked to return");
			clienti = 6;
			scAsteptareOcupate = 5;
		}

		System.out.println("No customer is " + clienti
				+ "(a customer is on lawn chair)");
		System.out.println("Nr seats occupied " + scAsteptareOcupate);
		if (clienti != 0) {
			out = " Is clipped client:" + clienti;
			clienti--;
		}
		return out;
	}

}
