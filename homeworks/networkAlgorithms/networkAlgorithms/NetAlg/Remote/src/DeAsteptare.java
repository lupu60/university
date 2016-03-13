import java.awt.TextArea;
import java.io.DataInputStream;


public  class DeAsteptare extends Thread
{
    DataInputStream in;
    TextArea rezumat;
    
    public DeAsteptare(DataInputStream in, TextArea rezumat)
    {
        this.in = in;
        this.rezumat = rezumat;
        this.start();
    }
    
    public void run()
    {
        try
        {
           // int nr_oct = in.readInt();
           // byte[] b = new byte[nr_oct];
           // in.read(b);
        	String dir=in.readLine();
           // rezumat.setText(new String(b,0));
        	System.out.println("client de asteptare_"+dir+"_");
        	rezumat.setText(dir);
        }
        catch(Exception exception)
        {
            rezumat.setText(exception.toString());
        }
    }
}
