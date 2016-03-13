import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		// var
		String opt = null;
		// hr
		ArrayList<Employee> employeeList = new ArrayList<>();
		CrudOpt crud = new CrudOpt();
		employeeList.add(crud.create(0, "fanica", "fanica", (short) 1993,
				(byte) 3, (byte) 23, 2000));
		employeeList.add(crud.create(1, "alina", "alina", (short) 1990,
				(byte) 5, (byte) 12, 1654));
		employeeList.add(crud.create(2, "ana", "ana", (short) 1995, (byte) 6,
				(byte) 5, 1500));
		employeeList.add(crud.create(3, "costel", "costel", (short) 1989,
				(byte) 8, (byte) 29, 1245));
		employeeList.add(crud.create(4, "gigel", "gigel", (short) 1988,
				(byte) 12, (byte) 14, 1543));
		employeeList.add(crud.create(5, "em1", "em1", (short) 1993, (byte) 3,
				(byte) 8, 15540));

		while (opt != "e") {
			System.out
					.print(" #c Create \n #r Read \n #u Update \n #d Delete \n +++++++++++\n #s Show list \n #e Exit \n #?=");
			opt = keyboard.next();
			switch (opt.toLowerCase()) {
			// create
			case "c":
				System.out.println("+++++++\nCreate\n+++++++");
				System.out
						.println(" New Employee \n int:id| String firstName| String lastName| year| month| day| double salary ");
				employeeList.add(crud.create(keyboard.nextInt(),
						keyboard.next(), keyboard.next(), keyboard.nextShort(),
						keyboard.nextByte(), keyboard.nextByte(),
						keyboard.nextDouble()));
				System.out.println("Ok!\n");
				break;
			// read
			case "r":
				System.out.println("+++++++\nRead\n+++++++");
				System.out.println("String firstName| String lastName");
				String firstName = keyboard.next();
				String lastName = keyboard.next();
				boolean found = false;

				for (Employee employee : employeeList) {
					if (employee.getFirstName().equals(firstName)
							&& employee.getLastName().equals(lastName)) {
						System.out.println(crud.read(employee));
						found = true;
						break;
					}
				}
				if (found == false)
					System.out.println("Employee does not exist!\n");

				break;
			// update
			case "u":
				System.out.println("+++++++\nUpdate\n+++++++");
				System.out.println("String firstName| String lastName");
				firstName = keyboard.next();
				lastName = keyboard.next();
				found = false;

				for (Employee employee : employeeList) {
					if (employee.getFirstName().equals(firstName)
							&& employee.getLastName().equals(lastName)) {
						System.out
								.println(" New Employee \n int:id| String firstName| String lastName| year| month| day| double salary ");
						employeeList.add(crud.create(keyboard.nextInt(),
								keyboard.next(), keyboard.next(),
								keyboard.nextShort(), keyboard.nextByte(),
								keyboard.nextByte(), keyboard.nextDouble()));
						System.out.println("Ok!\n");
						found = true;
						break;
					}
				}
				if (found == false)
					System.out.println("Employee does not exist!\n");

				break;
			// delete
			case "d":
				System.out.println("+++++++\nDelete\n+++++++");
				System.out.println("String firstName| String lastName");
				firstName = keyboard.next();
				lastName = keyboard.next();
				found = false;

				for (Employee employee : employeeList) {
					if (employee.getFirstName().equals(firstName)
							&& employee.getLastName().equals(lastName)) {
						employeeList.remove(employee);
						System.out.println("Ok!\n");
						found = true;
						break;
					}
				}
				if (found == false)
					System.out.println("Employee does not exist!\n");

				break;
			case "s":
				System.out.println("+++++++\nShow list\n+++++++");
				System.out.println(employeeList.toString());
				System.out.println("\n");
				break;
			case "e":
				System.out.println("Goodbye");
				opt="e";
				break;
			default:
				System.out.println("Wrong #!");
				break;
			}
		}
	}
}
