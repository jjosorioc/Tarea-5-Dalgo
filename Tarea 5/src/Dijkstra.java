
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

	public static void DijkstraAlgorithm(int[][] graph, int initVertex) {
		int[] distancesToInit = new int[graph.length];
		boolean[] marked = new boolean[graph.length];

		for (int i = 0; i < distancesToInit.length; i++) {
			distancesToInit[i] = Integer.MAX_VALUE;
			marked[i] = false;
		}

		distancesToInit[initVertex] = 0;

		for (int i = 0; i < graph.length; i++) {
			int closestVertex = findClosestVertex(distancesToInit, marked);

			marked[closestVertex] = true;

			for (int j = 0; j < graph.length; j++) {
				if (graph[closestVertex][j] != -1 && !marked[j] && distancesToInit[closestVertex] != Integer.MAX_VALUE
						&& distancesToInit[closestVertex] + graph[closestVertex][j] < distancesToInit[j])
					distancesToInit[j] = distancesToInit[closestVertex] + graph[closestVertex][j];
			}
		}
	}

	private static int findClosestVertex(int[] distancesToInit, boolean[] marked) {
		int minValueToVertex = Integer.MAX_VALUE;
		int index = -1;

		for (int i = 0; i < distancesToInit.length; i++) {
			if (!marked[i] && distancesToInit[i] <= minValueToVertex) {
				minValueToVertex = distancesToInit[i];
				index = i;
			}
		}

		return index;
	}
}
