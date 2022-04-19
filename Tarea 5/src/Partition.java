public class Partition {

	final private int numVertices;

	private int[] parents;

	private int heights[];

	/*
	 * Constructor que asigna inicialmente a cada vertice su padre como sí mismo y
	 * la altura como 1
	 * para ir haciendo los arboles correspondientes
	 */

	public Partition(MapaCiudad mapa) {
		numVertices = mapa.getVertices().size();
		parents = new int[numVertices];
		heights = new int[numVertices];

		for (int i = 0; i < numVertices; i++) {
			parents[i] = i;
			heights[i] = 1;

		}

	}

	/*
	 * Encuentra el nodo padre del arbol de recubrimiento
	 */

	public int findParentNode(int vertex) {
		int parentVertex = parents[vertex];
		if (parentVertex == vertex)
			return vertex;

		int s = findParentNode(parentVertex);
		parents[vertex] = s;
		return s;
	}

	/*
	 * une dos vertices que pueden hacer parte del arbol de costos mínimos
	 */

	public void union(int v1, int v2) {
		int s1 = findParentNode(v1);
		int s2 = findParentNode(v2);

		if (heights[s1] < heights[s2])
			parents[s1] = s2;
		else {
			parents[s2] = s1;

			if (heights[s1] == heights[s2])
				heights[s2] = heights[s2] + 1;
		}
	}

}
