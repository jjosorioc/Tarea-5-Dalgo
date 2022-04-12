import java.util.Map;
import java.util.HashMap;

public class Graph {
	private Map<Integer, Boolean> vertices;
	private int[][] adjMatrix;

	public Graph(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
		for (int i = 0; i < this.adjMatrix.length; i++)
			this.vertices.put(i, false);
	}
}