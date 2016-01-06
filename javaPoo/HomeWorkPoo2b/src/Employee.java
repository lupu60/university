
import java.text.NumberFormat;
public class Employee
{
	private int id;
	private String name;
	private double salary;

	public Employee(int id, String name, double salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Employee()
	{
		id = 0;
		name = " ";
		salary = 0;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setId(int setez)
	{
		this.id = setez;
	}

	public void setName(String name_setez)
	{
		this.name = name_setez;
	}

	public void setSalary(double setez)
	{
		this.salary = setez;
	}

	public String toString()
	{
		return "Employee ID" + this.getId() + " " + "Name " + this.getName()
				+ " " + "salary" +NumberFormat.getCurrencyInstance().format(this.getSalary())+this.getClass().getSimpleName();
	}

	public double raiseSalary(double suma)
	{
		if (suma < 0)
		{
			System.out.println("suma este ptr scadere de salariu");
			return salary;
		} else
			return (salary + suma);
	}

	public boolean equals(Employee e)
	{
		if ((id == e.id) && (name.equals(e.name)) && (salary == e.salary))
			return true;
		return false;
	}
}
