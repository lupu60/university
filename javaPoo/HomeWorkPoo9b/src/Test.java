
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> codeList = new ArrayList<>();
		codeList.add("1S01");
		codeList.add("1S02");
		codeList.add("1M01");
		codeList.add("1S02");
		codeList.add("1M02");
		codeList.add("1S01");
		codeList.add("1L01");
		codeList.add("1L02");
		codeList.add("1XL01");
		codeList.add("1M02");
		codeList.add("1XL02");

		Map<String, String> products = new HashMap<>();
		products.put("1S01", "Tricou negru marimea S");
		products.put("1M01", "Tricou negru marimea M");
		products.put("1L01", "Tricou negru marimea L");
		products.put("1XL01", "Tricou negru marimea XL");
		products.put("1S02", "Tricou alb marimea S");
		products.put("1M02", "Tricou alb marimea M");
		products.put("1L02", "Tricou alb marimea L");
		products.put("1XL02", "Tricou alb marimea XL");

		TreeMap<Articol, NumberOfElements> raport = new TreeMap<>(
				new Comparator<Articol>() {
					@Override
					public int compare(Articol o1, Articol o2) {
						return (-o1.compareTo(o2));
					}
				});

		for (String cod : codeList) {
			Articol art = new Articol(cod, products.get(cod));
			if (raport.containsKey(art))
				raport.get(art).setNumber(raport.get(art).getNumber() + 1);
			else
				raport.put(art, new NumberOfElements(1));

		}
		
		// System.out.println("Tricou negru marimea XL".compareTo("Tricou negru marimea M"));
		// Iteram TreeMap
		for (Map.Entry<Articol, NumberOfElements> entry : raport.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		/*
		 * for (String string : codeList) { if(raport.containsKey(string))
		 * raport. }
		 */

	}

}
