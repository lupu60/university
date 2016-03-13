public class CrudOpt {
//c
	public Employee create(int id, String firstName, String lastName,
			short birthYear, byte birthMonth, byte birthDay, double salary) 
	{
		return new Employee(id, firstName, lastName, salary, new Date(birthDay,
				birthMonth, birthYear));
	}
//r
	public String read(Employee e) {
		return e + "";
	}
//u
	public Employee update(Employee e, int id, String firstName,
			String lastName, short birthYear, byte birthMonth, byte birthDay,
			double salary) {
		e.setId(id);
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setSalary(salary);
		e.setBirthDate(new Date(birthDay, birthMonth, birthYear));
		return e;
	}
//d
	public Employee delete() {
		return null;
	}

}
