import java.util.Scanner;


public class Main {
	public static void main(String args[])
	{   Scanner sc= new Scanner(System.in);
	
		 Complex[][] m = new Complex[3][3];
		for (int i = 0; i < m.length; i++) {
			m[i][i]=new Complex(sc.nextDouble(),sc.nextDouble());
		}
		 Complex[][] m2 = new Complex[3][3];
		for (int i = 0; i < m2.length; i++) {
			m2[i][i]=new Complex(sc.nextDouble(),sc.nextDouble());
		}

		for (int i = 0; i < m.length; i++) {
			m[i][i].suma(m2[i][i]);
            System.out.println(m[i][i].toString());
		}
	}
	}

