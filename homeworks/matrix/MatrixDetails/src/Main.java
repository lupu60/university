import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		ReadMatrix readMatrix = new ReadMatrix("array.txt");

		WorkMatrix workSquare = new WorkMatrix(readMatrix.getMatrix());

		PrintWriter writer = new PrintWriter("src/out.txt", "UTF-8");
		int[][] matrix = readMatrix.getMatrix();
		
		
		writer.print(readMatrix.toString());
		// Sum matrix
		writer.println("Sum matrix= " + workSquare.SumMatrix(matrix));
		// Even numbers
		writer.print("Even numbers : ");
		for (int i = 0; i < workSquare.Even(matrix).length; i++) {
			writer.print(workSquare.Even(matrix)[i] + " ");
		}
		writer.println();
		// Odd numbers
		writer.print("Odd numbers : ");
		for (int i = 0; i < workSquare.Odd(matrix).length; i++) {
			writer.print(workSquare.Odd(matrix)[i] + " ");
		}
		
		
		writer.close();
	}
}