
public class Director extends Manager
{
	private double budget;

	public Director()
	{
		budget = 0;
	}

	public Director(int id, String name, double salary, String departmentName,
			double budget)
	{
		super(id, name, salary, departmentName);
		this.budget = budget;

	}

	public double getBudget()
	{
		return budget;
	}

	void setBudget(double setez)
	{
		budget = setez;
	}

	public String toString()
	{
		return super.toString() + "Budget" + this.getBudget();
	}

	public boolean equals(Director d)
	{
		if ((this.getId() == d.getId()) && (this.getName().equals(d.getName()))
				&& (this.getSalary() == d.getSalary())
				&& (this.getDepartmentName().equals(d.getDepartmentName()))
				&& (this.getBudget() == d.getBudget()))
			return true;
		return false;
	}
}
