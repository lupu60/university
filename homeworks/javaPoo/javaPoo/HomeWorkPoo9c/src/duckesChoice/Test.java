package duckesChoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<String, Tricouri> gamaDeTricouri = new HashMap<>();
		gamaDeTricouri.put("1S01", new Tricouri("1S01", "Tricou polo", "alb",
				"S", 20));
		gamaDeTricouri.put("1M01", new Tricouri("1M01", "Tricou polo", "alb",
				"M", 5));
		gamaDeTricouri.put("1XL01", new Tricouri("1XL01", "Tricou polo", "alb",
				"XL", 10));
		gamaDeTricouri.put("2S01", new Tricouri("2S02", "Tricou sport", "alb",
				"S", 30));
		gamaDeTricouri.put("2L01", new Tricouri("2L01", "Tricou sport", "alb",
				"L", 4));

		Queue<Tranzactie> tranzactii = new ArrayBlockingQueue<>(1000);

		System.out.println("----Daca doriti sa realizati"
				+ " tranzactii cu tricouri introduceti da-----");
		String flag = sc.next();
		System.out.println("---Aceasta este gama de tricouri---");
		for (Map.Entry<String, Tricouri> prduse : gamaDeTricouri.entrySet()) {
			System.out.println(prduse.getValue() + " Bucati disponibile "
					+ prduse.getValue().getNrBucati());
		}
		while (flag.equals("da")) {
			String flagIntern, valCod;
			int nrBuc;
			System.out
					.println("----Spuneti ce fel de tranzactie vreti sa faceti"
							+ " push/pop; codul produsului si numerul de bucati");
			flagIntern = sc.next();
			valCod = sc.next();
			nrBuc = sc.nextInt();
			switch (flagIntern) {
			case "push":
				if (gamaDeTricouri.containsKey(valCod)) {
					gamaDeTricouri.get(valCod).pushTricou(nrBuc);
					tranzactii.add(new Tranzactie(valCod, "input", nrBuc));
				} else
					System.out.println("Cod incorect");
				break;
			case "pop":
				if (gamaDeTricouri.containsKey(valCod)) {
					gamaDeTricouri.get(valCod).popTricou(nrBuc);
					tranzactii.add(new Tranzactie(valCod, "output", nrBuc));
				} else
					System.out.println("Cod incorect");
				break;
			}
			System.out.println("----Vreti sa continuati tranzactile? da----");
			flag = sc.next();

		}

		// Realizare raport
		ArrayList<Tricouri> raportPeBucati = new ArrayList<>(
				gamaDeTricouri.size());
		for (Map.Entry<String, Tricouri> prduse : gamaDeTricouri.entrySet()) {
			Tricouri tr = prduse.getValue();
			raportPeBucati.add(tr);
		}

		// Se sorteaza rapoartele
		Collections.sort(raportPeBucati, new Comparator<Tricouri>() {

			@Override
			public int compare(Tricouri o1, Tricouri o2) {
				// TODO Auto-generated method stub
				return o1.compareToNrBuc(o2);
			}

		});

		System.out.println("Raport pe buc");
		for (Tricouri tricouri : raportPeBucati) {
			System.out.println(tricouri + " " + tricouri.getNrBucati());
		}
		Collections.sort(raportPeBucati, new Comparator<Tricouri>() {

			@Override
			public int compare(Tricouri o1, Tricouri o2) {
				// TODO Auto-generated method stub
				return o1.compareToDescriere(o2);
			}

		});
		System.out.println("Raport pe descriere");
		for (Tricouri tricouri : raportPeBucati) {
			System.out.println(tricouri + " " + tricouri.getNrBucati());
		}

	}

}
