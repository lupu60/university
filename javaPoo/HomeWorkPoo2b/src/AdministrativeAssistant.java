public class AdministrativeAssistant extends Employee
{
	public AdministrativeAssistant()
	{
		super();
	}

	public AdministrativeAssistant(int id, String name, double salary)
	{
		super(id, name, salary);
	}

	public boolean equals(AdministrativeAssistant a)
	{
		if ((this.getId() == a.getId()) && (this.getName().equals(a.getName()))
				&& (this.getSalary() == a.getSalary()))
			return true;
		return false;
	}
}