import java.util.Scanner;


public class main2 {

	private static Scanner sc;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.random());
		int m[][]= new int[4][4];
		sc = new Scanner(System.in);
		for (int i = 0; i < m.length; i++) {
			m[i][i]=sc.nextInt();
		}
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i][i]);
		}

	}}
