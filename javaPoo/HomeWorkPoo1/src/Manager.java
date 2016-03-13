import java.util.ArrayList;

public class Manager extends Employee {
	private String departametName;
	private ArrayList<Employee> staff;
	private int nremployees;

	public Manager() {
		super();
		this.departametName = " ";
	}

	public Manager(int id, String name, double salary, String departamentName,ArrayList<Employee> staff) {
		super(id, name, salary);
		this.departametName = departamentName;
		this.staff = staff;
		this.nremployees = staff.size();
	}

	public String getDepartametName() {
		return departametName;
	}

	public void setDepartametName(String departametName) {
		this.departametName = departametName;
	}

	public ArrayList<Employee> getStaff() {
		return staff;
	}

	public void setStaff(ArrayList<Employee> staff) {
		this.staff = staff;
	}

	public int getNremployees() {
		return nremployees;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (departametName == null) {
			if (other.departametName != null)
				return false;
		} else if (!departametName.equals(other.departametName))
			return false;
		if (nremployees != other.nremployees)
			return false;
		if (staff == null) {
			if (other.staff != null)
				return false;
		} else if (!staff.equals(other.staff))
			return false;
		return true;
	}

	public int findEmployee(Employee employee) {
		for (Employee employee1 : staff) {
			if (employee.equals(employee1)) {
				return employee1.getId();
			}
         
		}
		return -1;
	}

	public void addEmployee(Employee employee) {
		if (findEmployee(employee) == -1)
			staff.add(employee);
		else
			System.out.println("Employee exist!");
	}

	public void removeEmployee(Employee employee) {
		if (findEmployee(employee) != -1)
			staff.remove(employee.getId()-1);
		else
			System.out.println("Employee does not exist!");
	}

	
	@Override
	public String toString() {
		return "Manager [departametName=" + departametName + ", staff=" + staff
				+ ", nremployees=" + nremployees + "]";
	}

	public String printStaffDetails() {
		return "Manager:" + super.getName()+"\tDepartament Name:"
				+ departametName + "\nStaff:\n "+staff;
	
	}
}