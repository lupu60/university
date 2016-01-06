import java.util.*;

public class Bubblesort {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("n=");
		int n = sc.nextInt();
		int[] v = new int[n];
		read(v);
		display(v);
		sort(v);
		display(v);

	}

	public static void read(int v[]) {
		for (int i = 0; i < v.length; i++) {
			v[i] = sc.nextInt();
		}
	}

	public static void display(int v[]) {
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i]);
		}
		System.out.println("\n--------");
	}

	private static void sort(int v[]) {
		int dim = v.length;
		int i;
		boolean suntInv;
		do {
			suntInv = false;
			for (i = 0; i < dim - 1; i++)
				if (v[i] > v[i + 1]) {
					int aux = v[i];
					v[i] = v[i + 1];
					v[i + 1] = aux;
					suntInv = true;
				}
		} while (suntInv == false);
	}
}
