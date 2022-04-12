import java.util.Scanner;

public class Dijkstra {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Main
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] graph = Reader.readMatrix();
		Reader.printDistances(calculateDijkstraFromAllVertices(graph));
	}

	public static int[][] calculateDijkstraFromAllVertices(int[][] graph) {
		int[][] distancesToInits = new int[graph.length][graph.length];
		for (int i = 0; i < graph.length; i++) {
			distancesToInits[i] = DijkstraAlgorithm(graph, i);
		}

		return distancesToInits;
	}

	private static int[] DijkstraAlgorithm(int[][] graph, int initVertex) {
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

		return distancesToInit;
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
