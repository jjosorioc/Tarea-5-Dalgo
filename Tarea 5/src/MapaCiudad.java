import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MapaCiudad {

	private Scanner sc = new Scanner(System.in);

	private HashSet<Edge> ejesCiudad = new HashSet<Edge>();

	private HashSet<Integer> vertices = new HashSet<Integer>();

	public HashSet<Integer> getVertices() {
		return vertices;
	}

	public ArrayList<Edge> getEjes() {
		ArrayList<Edge> ejes = new ArrayList<Edge>();

		for (Edge e : ejesCiudad) {
			ejes.add(e);
		}

		return ejes;
	}

	public void cargarArchivo() {

		HashSet<Edge> infoEjes = new HashSet<Edge>();
		HashSet<Integer> listaVertices = new HashSet<Integer>();

		sc.nextLine();

		String linea = sc.nextLine();
		while (linea != "") {

			String[] partes = linea.split(";");
			Integer verticeInicial = Integer.parseInt(partes[0]);
			Integer verticeFinal = Integer.parseInt(partes[1]);
			Integer costoConstruccion = Integer.parseInt(partes[2]);

			Edge eje = new Edge(verticeInicial, verticeFinal, costoConstruccion);
			infoEjes.add(eje);

			if (!listaVertices.contains(verticeInicial)) {
				listaVertices.add(verticeInicial);
			}

			if (!listaVertices.contains(verticeFinal)) {
				listaVertices.add(verticeFinal);
			}

			linea = sc.hasNextLine() ? sc.nextLine() : "";
		}

		sc.close();

		vertices = listaVertices;
		ejesCiudad = infoEjes;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		MapaCiudad mapa = new MapaCiudad();
		mapa.cargarArchivo();

		for (Edge e : mapa.ejesCiudad) {
			System.out.println(e.toString());
		}

		for (Integer e : mapa.vertices) {
			System.out.println(e);
		}

	}

}