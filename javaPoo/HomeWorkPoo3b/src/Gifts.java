import java.text.NumberFormat;
import java.util.ArrayList;

public class Gifts {
	private double tprice;
    private String l;
    private double totprice;
	public String GiftListofEmployee(EmployeeGiftReciver em) {
		l = em + "\n";
		tprice = 0;
		for (Gift gift : em.getGiftList()) {
			l += gift.toString() + "\n";
			tprice += gift.getPrice();
		}
		return l + "total "
				+ NumberFormat.getCurrencyInstance().format(tprice);
	}
	public String giftListofallEmployee(ArrayList<EmployeeGiftReciver> emlist){
		l="";
		totprice=0;
			for (EmployeeGiftReciver employeeGiftReciver : emlist) {
			l+=GiftListofEmployee(employeeGiftReciver)+"\n";
			totprice+=tprice;
			
		}
			return l+"total price"+NumberFormat.getCurrencyInstance().format(totprice);
	}
}
