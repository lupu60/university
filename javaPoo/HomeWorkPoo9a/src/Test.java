import java.util.Iterator;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IdArray ids = new IdArray();
		ids.add("001");
		ids.add("002");
		ids.add("003");
		ids.add("004");
		ids.add("005");
		ids.add("006");
		ids.add("007");
		ids.add("008");
		ids.add("009");
		ids.add("010");

		System.out.println("---Lista ordonata natural---");
		for (String string : ids) {
			System.out.println(string);

		}

		// Iterator<String> it= ids.new IteratorThree(ids);
		System.out.println("----Iteratorul din 3 in 3-----");
		for (Iterator<String> iterator = ids.new IteratorThree(); iterator
				.hasNext();) {
			String str = iterator.next();
				System.out.println(str);

		}

		System.out.println("----Iteratorul primul ultimu---");
		for (Iterator<String> iterator = ids.new IteratorFirstLast(); iterator
				.hasNext();) {
			System.out.println(iterator.next());

		}

	}

}
