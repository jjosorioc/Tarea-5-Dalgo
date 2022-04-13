public class BellmanFord {

	public static void main(String[] args) {
		int[][] graph = Reader.readMatrix();
		Reader.printDistances(calculateBellmanFordFromAllVerices(graph));
	}

	public static int[][] calculateBellmanFordFromAllVerices(int[][] graph) {
		int[][] distancesToInits = new int[graph.length][graph.length];
		for (int i = 0; i < graph.length; i++) {
			distancesToInits[i] = BellmanFordAlgorithm(graph, i);
		}

		return distancesToInits;

	}

	private static int[] BellmanFordAlgorithm(int[][] graph, int initVertex) {
		int[] distancesToInit = new int[graph.length];
		for (int i = 0; i < graph.length; i++)
			distancesToInit[i] = Integer.MAX_VALUE;

		distancesToInit[initVertex] = 0;

		for (int iteration = 0; iteration < graph.length; iteration++) {
			for (int startVert = 0; startVert < graph.length; startVert++) {
				for (int endVert = 0; endVert < graph.length; endVert++) {
					if (graph[startVert][endVert] != -1 && distancesToInit[startVert] != Integer.MAX_VALUE
							&& distancesToInit[startVert] + graph[startVert][endVert] < distancesToInit[endVert])
						distancesToInit[endVert] = distancesToInit[startVert] + graph[startVert][endVert];
				}
			}
		}

		return distancesToInit;
	}
}