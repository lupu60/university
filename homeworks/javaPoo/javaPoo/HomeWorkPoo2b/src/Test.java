

public class Test
{

	public static void printEmployee(Employee e)
	{
		System.out.println("Employee ID " + e.getId());
		System.out.println("Employee Name " + e.getName());
		System.out.println("Employee Salary " + e.getSalary());

	}

	public static void main(String[] args)
	{

		Employee[] staff1 = new Employee[4];
		staff1[0] = new Employee(1, "iulia", 130);
		staff1[1] = new Employee(2, "claudiu", 2000);
		staff1[2] = new Employee(3, "maria", 700);
		staff1[3] = new Employee(4, "marius", 2300);
		Manager manager1 = new Manager(12, "Marian", 30000, "vanzari");

		Employee[] staff2 = new Employee[2];
		staff2[0] = new Employee(13, "Matei", 1000);
		staff2[1] = new Employee(14, "Camelia", 2300);
		Manager manager2 = new Manager(122, "Ioana", 2400, "administrare");

		Director director = new Director(123, "ioan", 10000, "vanzari", 4000);
		Engineer inginer1 = new Engineer(112, "george", 300);
		AdministrativeAssistant asistent1 = new AdministrativeAssistant(223,
				"raluca", 800);

		System.out.println(staff1[0].getSalary());
		System.out.println(staff1[0].toString());
		staff1[0].raiseSalary(2000);
		System.out.println(staff1[0].toString());
		System.out.println(staff2[1].toString());
		staff2[1].setName("carmen");
		System.out.println(staff2[1].getName());

	}

}
