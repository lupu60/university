import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CitireIpSiNr {

	public static String citireIpDialog(int port) {
		String ip = JOptionPane
				.showInputDialog("Enter IP Address of a machine that is\n"
						+ "running the service on port " + port);
		return ip;
	}

	public static int citireNrDialog() {
		String nr = JOptionPane.showInputDialog("Enter number");
		int x = -1;
		try {
			x = Integer.parseInt(nr);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Enter a number", "",
					JOptionPane.ERROR_MESSAGE);
		}
		return x;
	}

	public static void serverPornit() {
		JOptionPane.showMessageDialog(null,
				"Server started. Ready for connection on /n "+Server.getServerSocketString());
	}
}
