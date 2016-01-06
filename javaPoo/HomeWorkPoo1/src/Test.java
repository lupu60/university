import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {


	ArrayList<Employee> staff1=new ArrayList<>();
	staff1.add(new Employee(1, "MADALINA", 300));
	staff1.add(new Employee(2, "GINA", 350));
	staff1.add(new Employee(3, "IULIA", 200));
    staff1.add(new Employee(4, "CORNEL", 900));	
	Manager manager1 = new Manager(0, "BOSS", 2500, "VANZARI", staff1);
	  System.out.println(  manager1.toString());
	manager1.addEmployee(new Employee(5,"ANETA", 123));
	manager1.removeEmployee(new Employee(3, "IULIA", 200));
	  System.out.println(  manager1.toString());


	
	
	
	
	
}
}
