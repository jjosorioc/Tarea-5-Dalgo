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
		// Primera línea
		String[] currentLine = sc.nextLine().split("\t");

		int[][] grafo = new int[currentLine.length][currentLine.length];

		// Se crea el grafo
		for (int fila = 0; fila < currentLine.length; fila++) {
			for (int columna = 0; columna < currentLine.length; columna++) {
				grafo[fila][columna] = Integer.parseInt(currentLine[columna]);
			}

			currentLine = sc.hasNextLine() ? sc.nextLine().split("\t") : "".split("\t");
		}

		return grafo;
	}

	public static void printDistances(int[][] distancesToInits) {
		for (int i = 0; i < distancesToInits.length; i++)
			System.out.println(i + ". " + Arrays.toString(distancesToInits[i]));
	}
}
