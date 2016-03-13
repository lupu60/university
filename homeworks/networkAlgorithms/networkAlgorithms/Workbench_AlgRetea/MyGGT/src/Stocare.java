
public class Stocare {

	private int cmmdcActual;
	
	private int nrClient;
	
	private String ip1;
	private String ip2;

	private int port1;
	private int port2;
	
	public Stocare( int nrClient) {
		this.nrClient = nrClient;
	}
	
	public void setIp1(String ip1) {
		this.ip1 = ip1;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	public String getIp1() {
		return ip1;
	}

	public String getIp2() {
		return ip2;
	}

	public int getPort1() {
		return port1;
	}

	public int getPort2() {
		return port2;
	}

	public void setPort1(int port1) {
		this.port1 = port1;
	}

	public void setPort2(int port2) {
		this.port2 = port2;
	}

	public void setCmmdcActual(int cmmdcActual) {
		this.cmmdcActual = cmmdcActual;
	}

	public void setNrClient(int nrClient) {
		this.nrClient= nrClient;
	}

	public int getCmmdcActual() {
		return cmmdcActual;
	}

	public int getNrClient() {
		return nrClient;
	}
	
}
