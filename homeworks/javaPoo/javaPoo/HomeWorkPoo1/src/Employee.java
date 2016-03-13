public class Employee {

	private int id;
	private String name;
	private double salary;

	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Employee() {
		id = 0;
		name = " ";
		salary = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double raiseSalary(double rsalary) {
		if (rsalary < 0) {
			System.out.print("Decrease of salary to ");
			return (salary - rsalary);
		} else
			System.out.print("Raise of salary to ");
			return (salary + rsalary);
	}

	public boolean equals(Employee employee)
	{
		if ((id == employee.id) && (name.equals(employee.name)) && (salary == employee.salary))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", salary=" + salary
				+ "]\n";
	}
}