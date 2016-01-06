import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class ValidSemicolon {

	/**
	 * @param args
	 */
	public static boolean correctSemicolons(String str) {
		Deque<Character> semicolon = new ArrayDeque<>();
		try {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(')
					semicolon.push('(');
				if (str.charAt(i) == ')')
					semicolon.pop();
			}
			return semicolon.isEmpty();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "if ((a == b) && (x != y));", str1 = "if ((a == b) && (x != y)));";
		System.out.println("Expresia 1:-----> " + correctSemicolons(str));
		System.out.println("Expresia 2:-----> " + correctSemicolons(str1));

	}

}
