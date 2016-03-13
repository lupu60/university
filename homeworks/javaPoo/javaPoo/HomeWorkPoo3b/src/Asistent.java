import java.util.ArrayList;


public class Asistent extends EmployeeGiftReciver {

	public Asistent(int id, String firstName, String lastName, double salary,
			ArrayList<Gift> giftList) {
		super(id, firstName, lastName, salary, giftList);
	}

	@Override
	public String toString() {
		return "Asistent"+super.toString();
	}

}
