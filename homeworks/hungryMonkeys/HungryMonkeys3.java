
public class HungryMonkeys3 {
	public static int maxim(int x, int y) {
		return x > y ? x : y;
	}

	public static int howManyBananas(Integer... hungerLevels) {
		int[] bananasMonkey = new int[hungerLevels.length];
		int bananas;
		for (int i = 0; i < hungerLevels.length; ++i) {
			int curent, urmator, contor = 1;
			curent = i;
			urmator = i + 1;
			while ((urmator < hungerLevels.length) && (hungerLevels[curent] > hungerLevels[urmator])) {
				++contor;
				curent = urmator;
				urmator++;
			}
			while (contor > 0) {
				bananasMonkey[i] = contor;
				i++;
				contor--;
			}
			i--;
		}
		bananas = bananasMonkey[0];
		for (int i = 1; i < hungerLevels.length; ++i) {
			if (hungerLevels[i] > hungerLevels[i - 1]) {
				bananasMonkey[i] = maxim(bananasMonkey[i - 1] + 1, bananasMonkey[i]);
			}
			bananas += bananasMonkey[i];
		}
		return bananas;
	}

	public static void main(String[] args) {
		System.out.println("Let the hunger games begin!");
		// GO GO GO
		System.out.println("Testing for [1, 2, 3, 2, 1]");
		System.out.println(howManyBananas(1, 2, 3, 2, 1));

		System.out.println("Testing for [1, 2, 2]");
		System.out.println(howManyBananas(1, 2, 2));

		System.out.println("Testing for [1, 2, 3, 4]");
		System.out.println(howManyBananas(1, 2, 3, 4));

		System.out.println("Testing for [1, 2, 3, 4, 2, 1, 1, 5]");
		System.out.println(howManyBananas(1, 2, 3, 4, 2, 1, 1, 5));

		System.out.println("Testing for [1, 4, 3, 2, 1]");
		System.out.println(howManyBananas(1, 4, 3, 2, 1));

		System.out.println("Testing for [1, 2, 3, 4, 3, 2, 1]");
		System.out.println(howManyBananas(1, 2, 3, 4, 3, 2, 1));
	}

}
