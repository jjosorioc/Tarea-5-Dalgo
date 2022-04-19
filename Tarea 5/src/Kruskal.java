import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {

	private MapaCiudad mapa;

	private ArrayList<Edge> ejes = new ArrayList<Edge>();

	public Kruskal(MapaCiudad mapa) {

		this.mapa = mapa;
		this.ejes = mapa.getEjes();

	}

	/*
	 * Ordena los ejes de acuerdo a su peso
	 */

	private void sortEdges() {
		Collections.sort(ejes, (o1, o2) -> (o1.getWeight()).compareTo(o2.getWeight()));
	}

	/*
	 * Algoritmo de Kruskal
	 */

	public ArrayList<Edge> KruskalAlgorithm() {
		Partition S = new Partition(mapa);
		ArrayList<Edge> resultado = new ArrayList<Edge>();
		sortEdges();

		for (Edge e : ejes) {
			if (S.findParentNode(e.getInitialVertex()) != S.findParentNode(e.getFinalVertex())) {
				resultado.add(e);
				S.union(e.getInitialVertex(), e.getFinalVertex());
			}
		}

		return resultado;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		MapaCiudad mapa = new MapaCiudad();
		mapa.cargarArchivo();
		Kruskal prueba = new Kruskal(mapa);

		ArrayList<Edge> kruskal = prueba.KruskalAlgorithm();

		System.out.println("Ejes a convertir");

		for (Edge e : kruskal) {
			System.out.println(e.toString());
		}
	}

}
