import java.util.Scanner;

public class Palindrom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("s=");
		String s = sc.nextLine();
		System.out.println(palindrom(s));

	}

	public static String palindrom(String s) {
		boolean flag = true;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i))
				flag = false;

		}
		if (flag == true)
			return "este palindrom";
		else
			return "nu este";
	}

}
