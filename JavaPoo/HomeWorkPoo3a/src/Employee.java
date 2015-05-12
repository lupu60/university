import java.text.NumberFormat;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	private Date birthDate;

	public Employee(int id, String firstName, String lastName, double salary,
			Date birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public Employee() {
		this.id = 0;
		this.firstName = null;
		this.lastName = null;
		this.salary = 0;
		this.birthDate = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return " \n Employee id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", salary="
				+ NumberFormat.getCurrencyInstance().format(salary)
				+ ", birthDate=" + birthDate + "]";
	}

}
