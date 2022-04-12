import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Graph {
	private Map<Integer, Boolean> vertices;
	private int[][] adjMatrix;

	public Graph(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
		this.vertices = new HashMap<Integer, Boolean>();
		for (int i = 0; i < this.adjMatrix.length; i++)
			this.vertices.put(i, false);
	}

	public int getEdgeWeight(int startVertex, int endVertex) {
		int value = 0;
		if (startVertex > this.adjMatrix.length - 1 || endVertex > this.adjMatrix.length - 1)
			value = Integer.MIN_VALUE;
		else
			value = adjMatrix[startVertex][endVertex];

		return value;
	}

	public Set<Integer> getVertices() {
		return vertices.keySet();
	}

	public void markVertex(int vertex) {
		if (vertices.containsKey(vertex))
			vertices.put(vertex, true);
	}
}