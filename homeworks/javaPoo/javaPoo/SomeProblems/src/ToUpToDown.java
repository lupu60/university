import java.util.Scanner;


public class ToUpToDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("String=");
		String s=sc.nextLine();
		System.out.println("1----ToLowerCase \n2----ToUpperCase");
		int opt=sc.nextInt();
		switch (opt) {
		case 1:
			System.out.println(s.toLowerCase());
			break;
		case 2:
			System.out.println(s.toUpperCase());
			break;
		default:
			break;
		}
	
	}

}
