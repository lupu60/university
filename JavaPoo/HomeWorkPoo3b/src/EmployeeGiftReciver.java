import java.util.ArrayList;

public class EmployeeGiftReciver extends Employee {
	private ArrayList<Gift> giftList;

	public EmployeeGiftReciver(int id, String firstName, String lastName,
			double salary, ArrayList<Gift> giftList) {
		super(id, firstName, lastName, salary);
		this.giftList=giftList;
	}

	public ArrayList<Gift> getGiftList() {
		return giftList;
	}

	public void setGiftList(ArrayList<Gift> giftList) {
		this.giftList = giftList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((giftList == null) ? 0 : giftList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeGiftReciver other = (EmployeeGiftReciver) obj;
		if (giftList == null) {
			if (other.giftList != null)
				return false;
		} else if (!giftList.equals(other.giftList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	public void reciveGift(Gift gift) {
		giftList.add(gift);
	}
	public void reciveGift(String name, String description, double price) {
		giftList.add(new Gift(name, description,price));
	}
}
