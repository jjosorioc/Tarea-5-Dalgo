
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Dijkstra {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Primera línea
		String[] currentLine = sc.nextLine().split("\t");

		int[][] grafo = new int[currentLine.length][currentLine.length];

		// Se crea el grafo
		for (int fila = 0; fila < currentLine.length; fila++) {
			for (int columna = 0; columna < currentLine.length; columna++) {
				grafo[fila][columna] = Integer.parseInt(currentLine[columna]);
			}

			try {
				currentLine = sc.nextLine().split("\t");
			} catch (NoSuchElementException e) {
				break;
			}
		}

	}
}
