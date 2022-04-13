public class FloydWarshall {
	public static void main(String[] args) throws Exception {
		int[][] graph = Reader.readMatrix();
		Reader.printDistances(FloydWarshallAlgorithm(graph));
	}

	private static int[][] FloydWarshallAlgorithm(int[][] graph) {
		int[][][] cube = new int[graph.length + 1][graph.length][graph.length];
		System.out.println(cube.length);
		System.out.println(cube[0].length);
		System.out.println(cube[0][0].length);
		cube[0] = graph;
		for (int i = 1; i < cube.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				for (int k = 0; k < graph.length; k++) {
					if (cube[i - 1][j][i - 1] != Integer.MAX_VALUE || cube[i - 1][i - 1][k] != Integer.MAX_VALUE) {
						cube[i][j][k] = Math.min(cube[i - 1][j][k], cube[i - 1][j][i - 1] + cube[i - 1][i - 1][k]);
					}
				}
			}
		}

		return cube[cube.length - 1];
	}

}
