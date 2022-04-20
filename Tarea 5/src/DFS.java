import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
	private static Scanner sc = new Scanner(System.in);

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

		// Respuesta

		ArrayList<Integer> answer = depthFirst(grafo);
		System.out.println(answer);

	}

	/**
	 * 
	 * @param grafo
	 * @return
	 */
	public static ArrayList<Integer> depthFirst(int[][] grafo) {
		ArrayList<Integer> answer = new ArrayList<>(grafo.length);

		Stack<Integer> stack = new Stack<>();

		boolean[] visited = new boolean[grafo.length];

		// Se inicia con el vértice 0
		stack.push(0);
		visited[0] = true;

		while (stack.size() > 0) {
			int next = stack.pop();
			answer.add(next);

			// Vértices conectados con el vértice next
			ArrayList<Integer> edgesDeNext = edges(grafo, next);

			for (int v : edgesDeNext) {
				if (!visited[v]) {
					stack.push(v);
					visited[v] = true;
				}

				// Se encuentra un ciclo
				else {
					System.out.println("HAY UN CICLO\nNodo repetido: " + v);
					answer.add(v);
					return answer;
				}
			}
		}
		return answer;
	}

	/**
	 * Retorna los vértices conectados a un vértice inicial.
	 * 
	 * @param grafo
	 * @param vertex
	 * @return
	 */
	public static ArrayList<Integer> edges(int[][] grafo, int vertex) {
		ArrayList<Integer> edgesVertex = new ArrayList<>();

		for (int i = 0; i < grafo.length; i++) {
			// Si los vértices están conectados.
			if (grafo[vertex][i] > 0) {
				edgesVertex.add(i);
			}
		}

		return edgesVertex;
	}
}
