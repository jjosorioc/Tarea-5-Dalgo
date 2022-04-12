import java.util.Scanner;
import java.util.Arrays;

public class Reader {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] matrix = readMatrix();
		for (int[] row : matrix)
			System.out.println(Arrays.toString(row));
	}

	public static int[][] readMatrix() {
		int[][] matrix = new int[0][0];
		boolean checked = false;
		int i = 0;
		String line = sc.nextLine();
		while (!line.isBlank()) {
			String[] row = line.split("\t");
			if (!checked) {
				matrix = new int[row.length][row.length];
				checked = true;
			}

			for (int j = 0; j < row.length; j++) {
				int num = Integer.parseInt(row[j]);
				matrix[i][j] = num == -1 ? Integer.MAX_VALUE : num;
			}

			i++;
			line = sc.hasNextLine() ? sc.nextLine() : "";
		}

		return matrix;
	}
}