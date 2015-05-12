import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		Gifts tgifts = new Gifts();
		EmployeeGiftReciver em = new Manager(13, "alina", "alina", 1500,
				new ArrayList<Gift>());
		
		EmployeeGiftReciver em2 = new Asistent(12, "vasile", "vasile", 1500,
				new ArrayList<Gift>());
		
		EmployeeGiftReciver em3 = new Asistent(15, "ana", "ana",500,
				new ArrayList<Gift>());
		
em.reciveGift(new InstantCoffe(10));
em.reciveGift(new BeansCoffe(100));
em2.reciveGift(new InstantCoffe (13));
em3.reciveGift("flori","lalele",150);
em2.reciveGift("bere","ursus",40);
System.out.println(tgifts.GiftListofEmployee(em));
ArrayList<EmployeeGiftReciver> total = new ArrayList<>();
total.add(em);
total.add(em2);
total.add(em3);
	System.out.println(tgifts.giftListofallEmployee(total));
	}

}
