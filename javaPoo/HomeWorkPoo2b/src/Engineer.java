public class Engineer extends Employee
{
	public Engineer()
	{
		super();
	}

	public Engineer(int id, String name, double salary)
	{
		super(id, name, salary);
	}

	public boolean equals(Engineer e)
	{
		if ((this.getId() == e.getId()) && (this.getName().equals(e.getName()))
				&& (this.getSalary() == e.getSalary()))
			return true;
		return false;
	}
}
