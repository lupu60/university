import java.io.*;
import java.net.Socket;

public class Client3 {
	public static void main(String[] args) {

		// listen port
		int port = 7000;
		String ip1 = "", ip2 = "";

		ip1=CitireIpSiNr.citireIpDialog( 8000);
		ip2=CitireIpSiNr.citireIpDialog( 9000);

		Stocare m = new Stocare(0);
		Server s = new Server(m, port);
		CitireIpSiNr.serverPornit();

		int x = -1;
		while (x < 0) {
			x = CitireIpSiNr.citireNrDialog();
		}

		m.setCmmdcActual(x);
		m.setNrClient(x);

		m.setPort1(8000);
		m.setPort2(9000);

		new StareComunicare(ip1, m.getPort1(), m);
		new StareComunicare(ip2, m.getPort2(), m);
	}
}
