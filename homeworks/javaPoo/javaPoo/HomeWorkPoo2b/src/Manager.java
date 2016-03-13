
public class Manager extends Employee
{
	private String departmentName;
	private Employee[] staff;
	private int count = 0;

	public Manager(int id, String name, double salary, String departmentName)
	{
		super(id, name, salary);
		this.departmentName = departmentName;
		this.staff = new Employee[20];
		count++;
	}

	public Manager()
	{
		super();
		this.departmentName = " ";
	}

	public String getDepartmentName()
	{
		return departmentName;

	}

	void setDepartmentName(String nume_setez)
	{
		departmentName = nume_setez;
	}

	public boolean equals(Manager m)
	{
		if ((this.getId() == m.getId()) && (this.getName().equals(m.getName()))
				&& (this.getSalary() == m.getSalary())
				&& (this.getDepartmentName().equals(m.getDepartmentName())))
			return true;
		return false;
	}

	public String toString()
	{
		return super.toString() + "DeparmentName" + this.getDepartmentName();
	}

	public int findEmployee(Employee e)
	{
		for (int i = 0; i < count; i++)
			if (staff[i].equals(e))
				return i;
		return -1;
	}
}
