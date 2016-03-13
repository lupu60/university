import java.util.ArrayList;

public class Director extends Manager {
	private double buget;

	public Director() {
		buget = 0;
	}

	public Director(int id, String name, double salary, String departamentName,
			ArrayList<Employee> staff, double buget) {
		super(id, name, salary, departamentName, staff);
		this.buget = buget;

	}

	public double getBuget() {
		return buget;
	}

	public void setBuget(double buget) {
		this.buget = buget;
	}

	@Override
	public String toString() {
		return "Director [buget=" + buget + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		if (Double.doubleToLongBits(buget) != Double
				.doubleToLongBits(other.buget))
			return false;
		return true;
	}
	
}
