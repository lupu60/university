import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReadandWrite {
	public static String shuffle(String input) {
		ArrayList<Character> characters = new ArrayList<Character>();
		for (char c : input.toCharArray()) {
			characters.add(c);
		}
		StringBuilder output = new StringBuilder(input.length());
		while (characters.size() != 0) {
			int randPicker = (int) (Math.random() * characters.size());
			output.append(characters.remove(randPicker));
		
		}

		return output.toString();
	}

	public static void main(String[] args) {
		String input = "input.txt";
		String output = "output.txt";
		String line = null;

		try {
			FileReader fileReader = new FileReader(input);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileWriter fileWriter = new FileWriter(output);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			while ((line = bufferedReader.readLine()) != null) {
				String newline = "";
				System.out.println("---------Old line---------\n" + line
						+ "\n---------New line---------");
				// split
				String[] words = line.split(" ");
				for (String word : words) {
					if (word.length() > 3) {
						char c1 = word.charAt(0);
						char c2;
						if (Character.toString(word.charAt(word.length() - 1)) == ".") {
							c2 = word.charAt(word.length() - 2);
						} else {
							c2 = word.charAt(word.length() - 1);
						}
						word = c1
								+ shuffle(word.substring(1, word.length() - 1))
								+ c2;
					}
					System.out.println(word);
					newline = newline + word + " ";
				}
				bufferedWriter.write("---------Old line---------");
				bufferedWriter.newLine();
				bufferedWriter.write(line);
				bufferedWriter.newLine();
				bufferedWriter.write("---------New line---------");
				bufferedWriter.newLine();
				bufferedWriter.write(newline);
				bufferedWriter.newLine();
				bufferedWriter.newLine();
			}

			bufferedReader.close();
			bufferedWriter.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + input + "'");
		} catch (IOException ex) {
			System.out.println("Error");
		}
		System.out.println("\nCheck the file 'output.txt'");
	}

}
