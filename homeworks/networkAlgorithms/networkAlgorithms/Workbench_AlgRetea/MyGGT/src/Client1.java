import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Client1 {

	public static void main(String[] args) {

		int port = 8000;

		String ip1 = "", ip2 = "";

		ip1=CitireIpSiNr.citireIpDialog( 9000);
		ip2=CitireIpSiNr.citireIpDialog( 7000);

		Stocare stoc = new Stocare(0);
		Server s = new Server(stoc, port);		
		CitireIpSiNr.serverPornit();

		int x = -1;
		while (x < 0) {
			 x = CitireIpSiNr.citireNrDialog();
		}
		
		stoc.setNrClient(x);
		stoc.setCmmdcActual(x);

		stoc.setIp1(ip1);
		stoc.setIp2(ip2);

		stoc.setPort1(9000);
		stoc.setPort2(7000);
	}

}
