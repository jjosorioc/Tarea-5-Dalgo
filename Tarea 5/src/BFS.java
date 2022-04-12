import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Primera l�nea
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
		HashSet<HashSet<Integer>> answerHashSet = breadthFirst(grafo);

		System.out.println(answerHashSet);
	}

	/**
	 * Breadth First Search de un grafo. Retorna un HashSet que contiene
	 * subconjuntos del grafo que est�n conectados.
	 * 
	 * @param grafo
	 * @return
	 */
	public static HashSet<HashSet<Integer>> breadthFirst(int[][] grafo) {
		// HashSet de respuesta
		HashSet<HashSet<Integer>> answerHashSet = new HashSet<>();

		// Queue para BFS
		Queue<Integer> queue = new LinkedList<>();

		// Arreglo que indica cu�les son los v�rtices visitados
		boolean[] visited = new boolean[grafo.length];

		// Se empieza con el nodo 0 del grafo

		queue.add(0);
		visited[0] = true;

		while (queue.size() > 0) {
			// Subconjunto del grafo con v�rtices conectados
			HashSet<Integer> caminoHashSet = new HashSet<>();

			int next = queue.remove();

			/**
			 * En esta parte del programa se verifica si el v�rtice ya pertenece a un
			 * subconjunto.
			 * 
			 * Si no pertenece a alg�n subconjunto se crea uno nuevo con este elemento.
			 */

			boolean yaPertenece = false;

			for (HashSet<Integer> h : answerHashSet) {
				if (h.contains(next))
					yaPertenece = true;
			}

			// Agregar el v�rtice next si no se encuentra en los subconjuntos
			if (!yaPertenece)
				caminoHashSet.add(next);

			// V�rtices conectados con el v�rtice next
			ArrayList<Integer> edgesDeNext = edges(grafo, next);

			for (int v : edgesDeNext) {
				// Si el v�rtice conectado con NEXT no ha sido visitado
				if (!visited[v]) {
					queue.add(v);
					visited[v] = true;

					// Se agrega al nuevo subconjunto
					if (!yaPertenece)
						caminoHashSet.add(v);

					// Se agrega al subconjunto que ya existe
					else {
						for (HashSet<Integer> h : answerHashSet) {
							if (h.contains(next))
								h.add(v);
						}
					}
				}

			}

			// Si el nuevo subconjunto NO est� vac�o
			if (!caminoHashSet.isEmpty())
				answerHashSet.add(caminoHashSet);

			/**
			 * Se busca un nuevo v�rtice que no ha sido visitado y que no pertenece a ning�n
			 * subconjunto
			 */
			else {
				int newNext = findNext(visited); // Nuevo v�rtice
				if (newNext != -1) {
					queue.add(newNext);
					visited[newNext] = true;
				}
			}
		}

		return answerHashSet;
	}

	/**
	 * Encuentra el siguiente v�rtice del grafo que no haya sido visitado. Retorna
	 * -1 si no encuentra v�rtices.
	 * 
	 * @param visited
	 * @return
	 */
	private static int findNext(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				return i;

			}
		}
		return -1;
	}

	/**
	 * Retorna los v�rtices conectados a un v�rtice inicial.
	 * 
	 * @param grafo
	 * @param vertex
	 * @return
	 */
	public static ArrayList<Integer> edges(int[][] grafo, int vertex) {
		ArrayList<Integer> edgesVertex = new ArrayList<>();

		for (int i = 0; i < grafo.length; i++) {
			// Si los v�rtices est�n conectados.
			if (grafo[vertex][i] == 1) {
				edgesVertex.add(i);
			}
		}

		return edgesVertex;
	}

}
