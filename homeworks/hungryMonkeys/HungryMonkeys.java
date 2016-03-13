
public class HungryMonkeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Let the hunger games begin!");
		// GO GO GO
		// assert howManyBananas(1, 2, 3, 2, 1) == 9;
		// assert howManyBananas(1, 2, 2) == 4;
		// assert howManyBananas(1, 2, 3, 4) == 10;
		// assert howManyBananas(1, 2, 3, 4, 2, 1, 1, 5) == 16;

		System.out.println("Testing for [1, 2, 3, 2, 1]");
		System.out.println(howManyBananas(1, 2, 3, 2, 1));

		System.out.println("Testing for [1, 2, 2]");
		System.out.println(howManyBananas(1, 2, 2));

		System.out.println("Testing for [1, 2, 3, 4]");
		System.out.println(howManyBananas(1, 2, 3, 4));

		System.out.println("Testing for [1, 2, 3, 4, 2, 1, 1, 5]");
		System.out.println(howManyBananas(1, 2, 3, 4, 2, 1, 1, 5));
		System.out.println("Testing for [1, 4,3,2,1]");
		System.out.println(howManyBananas(1, 4, 3, 2, 1));

	}

	// Trebuie sa hranesti N maimute infometate asezate in linie
	// Pentru fiecare maimuta, nivelul de infometare e reprezentat de un numar
	// intreg pozitiv
	// Ex: [1, 2, 3, 2, 1]
	// - fiecare maimuta primeste cel putin o banana
	// - daca o maimuta are nivelul de infometare mai mare decat al unui vecin
	// direct, va primi mai multe banane decat acesta
	//
	// Care este numarul minim de banane necesar pentru a hrani maimutele.
	// Exemple:
	// [1, 2, 5, 2, 1] - 9 banane
	// [1, 2, 2] - 4 banane
	// [1, 2, 3, 4] - 10 banane

	private static int howManyBananas(Integer... hungerLevels) {
		int nr = 0;
		int[] bananas = new int[hungerLevels.length];

		for (int i = 0; i < bananas.length; i++) {
			bananas[i] = 1;
		}

		for (int i = 1; i < hungerLevels.length - 1; i++) {
			if (hungerLevels[i] > hungerLevels[i + 1]) {
				bananas[i] = bananas[i + 1] + 1;

			}
			if (hungerLevels[i] > hungerLevels[i - 1]) {
				bananas[i] = bananas[i - 1] + 1;
			}
		}

		if (hungerLevels[0] > hungerLevels[1]) {
			bananas[0] = bananas[1] + 1;
		}
		if (hungerLevels[hungerLevels.length - 1] > hungerLevels[hungerLevels.length - 2]) {
			bananas[hungerLevels.length - 1] = bananas[hungerLevels.length - 2] + 1;

		}
		for (int i = 0; i < bananas.length; i++) {
			nr = nr + bananas[i];

		}
		return nr;
	}

}
