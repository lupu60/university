import java.text.DecimalFormat;
import java.util.*;

public class Matrice {

	private static Scanner sc = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("#");

	public static void read(double m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = sc.nextDouble();
			}
		}
	}

	public static void write(double m[][]) {
		for (int i = 0; i < m.length; i++) {
			System.out.println();
			for (int j = 0; j < m.length; j++) {

				System.out.print(df.format(m[i][j]) + " ");
			}
		}
		System.out.println();
	}

	public static void sum(double m[][]) {
		double s;
		for (int i = 0; i < m.length; i++) {
			s = 0;
			for (int j = 0; j < m.length; j++) {
				s += m[j][i];
			}
			System.out.println("c" + i + " :s=" + df.format(s));
		}

	}

	public static void prod(double m[][]) {
		double p = 1;
		for (int i = 0; i < m.length; i++) {
			p *= m[i][i];
		}
		System.out.println("p=" + df.format(p));
	}

	public static void main(String[] args) {

		System.out.println("n=");
		int n = sc.nextInt();
		double[][] m = new double[n][n];
		read(m);
		write(m);
		sum(m);
		prod(m);
	}

}
