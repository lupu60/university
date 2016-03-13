import java.util.ArrayList;


public class Manager extends EmployeeGiftReciver{

	public Manager(int id, String firstName, String lastName, double salary,
			ArrayList<Gift> giftList) {
		super(id, firstName, lastName, salary, giftList);
	}

	@Override
	public String toString() {
		return "Manager"+super.toString();
	}

}
