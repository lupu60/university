import java.util.Arrays;

public class WorkMatrix {
	private int[][] matrix;

	public WorkMatrix(int[][] matrix) {
		this.setMatrix(matrix);
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	int[] addElement(int[] org, int added) {
		int[] result = Arrays.copyOf(org, org.length + 1);
		result[org.length] = added;
		return result;
	}

	public int SumMatrix(int[][] matrix) {
		int s = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				s = s + matrix[i][j];
			}
		}
		return s;
	}

	public int[] Odd(int[][] matrix) {
		int[] temp = new int[0];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] % 2 != 0) {
					temp = addElement(temp, matrix[i][j]);
				}
			}
		}
		return temp;
	}

	public int[] Even(int[][] matrix) {
		int[] temp = new int[0];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] % 2 == 0) {
					temp = addElement(temp, matrix[i][j]);
				}
			}
		}
		return temp;
	}


}