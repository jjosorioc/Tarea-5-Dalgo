import java.util.Scanner;

public class FloydWarshall {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int[][] graph = Reader.readMatrix();
		Reader.printDistances(FloydWarshallAlgorithm(graph));
	}

	private static int[][] FloydWarshallAlgorithm(int[][] graph) {
		int[][][] cube = new int[graph.length + 1][graph.length][graph.length];
		cube[0] = graph;
		for (int i = 0; i < cube[0].length; i++) {
			for (int j = 0; j < cube[0].length; j++) {
				if (cube[0][i][j] == -1)
					cube[0][i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 1; i < cube.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				for (int k = 0; k < graph.length; k++) {
					cube[i][j][k] = cube[i - 1][j][k];
					if (cube[i - 1][j][i - 1] != Integer.MAX_VALUE && cube[i - 1][i - 1][k] != Integer.MAX_VALUE) {
						cube[i][j][k] = Math.min(cube[i - 1][j][k], cube[i - 1][j][i - 1] + cube[i - 1][i - 1][k]);
					}
				}
			}
		}

		return cube[cube.length - 1];
	}

}
