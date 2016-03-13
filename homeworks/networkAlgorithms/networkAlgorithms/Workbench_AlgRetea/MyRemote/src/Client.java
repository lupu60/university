import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client extends Applet {

	public static final int PORT = 8899;
	Socket s;
	//DataInputStream in;
	//DataOutputStream out;
	DataInputStream in;
	PrintStream out;
	
	TextField director;
	TextArea rezumat;
	DeAsteptare de_asteptare;
	String ip = "";

	public void init() {
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(
					System.in));
			System.out
					.print("Introduceti ip-ul serverului, dupa care se va incarca si applet-ul: ");
			try {
				ip = read.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			s = new Socket(ip, PORT);
			//in = new DataInputStream(s.getInputStream());
			//out = new DataOutputStream(s.getOutputStream());
			in = new DataInputStream(new BufferedInputStream(
					s.getInputStream()));
			out = new PrintStream(new BufferedOutputStream(
					s.getOutputStream(), 1024), false);

			director = new TextField();
			rezumat = new TextArea();
			rezumat.setEditable(false);

			this.setLayout(new BorderLayout());
			this.add("North", director);
			this.add("Center", rezumat);
			this.setSize(300, 500);
			
			System.out.println(getBackground());
			setBackground(Color.GREEN);
			System.out.println(getBackground());
			update(getGraphics());
			de_asteptare = new DeAsteptare(in, rezumat);
			
			this.showStatus("Client conectat la: "
					+ s.getInetAddress().getHostName() + " : " + s.getPort());
		} catch (Exception e) {
			this.showStatus(e.toString());
		}
	}


	public boolean action(Event e, Object ceva) {
		if (e.target == director) {
			String dir = (String) e.arg;
			//int nr_oct = dir.length();
		//	byte[] b = new byte[nr_oct];
			//dir.getBytes(0, dir.length(), b, 0);
			try {
				System.out.println("client dir_"+dir+"_");
				try{
					out.println(dir);
				}
				catch(Exception ex){
					System.out.println("exceptie scriere client");
					ex.printStackTrace();
				}
			//	out.writeInt(dir.length());
				//out.write(b);
			} catch (Exception exception) {
				this.showStatus(exception.toString());
			}
			director.setText("");
			return true;
		}
		return false;
	}

}