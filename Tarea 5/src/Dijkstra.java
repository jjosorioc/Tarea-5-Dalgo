public class Dijkstra {

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

		// Initialize all distances to infinite and all vertices to not marked
		for (int i = 0; i < distancesToInit.length; i++) {
			distancesToInit[i] = Integer.MAX_VALUE;
			marked[i] = false;
		}

		// Distance from initail vertex to same vertex is 0
		distancesToInit[initVertex] = 0;

		for (int i = 0; i < graph.length; i++) {
			// Find the next closest not marked vertex based on distance
			int closestVertex = findClosestVertex(distancesToInit, marked);

			marked[closestVertex] = true;

			for (int j = 0; j < graph.length; j++) {

				// If vertices are connected, vertex is not marked, distance is not infinite and
				// distance of new path is less than old path
				if (graph[closestVertex][j] != -1 && !marked[j] && distancesToInit[closestVertex] != Integer.MAX_VALUE
						&& distancesToInit[closestVertex] + graph[closestVertex][j] < distancesToInit[j])
					distancesToInit[j] = distancesToInit[closestVertex] + graph[closestVertex][j];
			}
		}

		return distancesToInit;
	}

	private static int findClosestVertex(int[] distancesToInit, boolean[] marked) {
		int minDistanceFound = Integer.MAX_VALUE;
		int index = -1;

		// Iterates over all found distances to get the smallest distance
		for (int i = 0; i < distancesToInit.length; i++) {
			if (!marked[i] && distancesToInit[i] <= minDistanceFound) {
				minDistanceFound = distancesToInit[i];
				index = i;
			}
		}

		return index;
	}
}
