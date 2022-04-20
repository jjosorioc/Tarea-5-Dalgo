PARTE 1:
	Para ejecutar los programas en el punto 1 se debe primero compilar el archivo
	"Reader.java" ya que este es el archivo que se encarga de recibir las entradas
	y mostrar las salidas. Seguido de esto, compile los archivos:
	- "Dijkstra.java"
	- "BellmanFord.java"
	- "FloydWarshall.java"

	De ahi puede correr cualquiera de los algormitos con el comando:
	"java _______.java < _______.txt > out.txt"
	reemplazando en la primera linea el nombre del algoritmo que quiera correr y
	en la segunda linea el nombre del archivo con la matriz de adjacencia que
	quiera meter al algoritmo.

	El resultado se guardara en el archivo "out.txt" y se mostrara en consola.
	El resultado es una matriz en las cuales las filas representan vertices
	de los cuales se empieza el algoritmo y las columnas vertices al que se quiere
	llegar. La interseccion entre una fila y una columna hace referencia a la
	distancia que hay desde el vertice que representa la fila hasta el vertice
	que representa la columna. El numero de filas y columnas empiezan en 0, lo
	cual significa que tanto la primera fila como la primera columna hacen
	referencia al vertice "0".

	El numero "2147483647" hace referencia a infinito.

	En terminos de complejidad el algoritmo de Dijkstra es el mas rapido, seguido
	del algoritmo de Bellman-Ford y el mas lento es el algoritmo de Floyd-Warshall.


PARTE 2:
	Para ejecutar el programa de la parte 2 se debe compilar el archivo llamado "BFS.java" con
	el comando "javac BFS.java". Para esto, debe estar en el directorio donde se encuentra el
	archivo.

	Después de compilarlo, ejecute el programa con el siguiente comando en su terminal: "java BFS < bfs.txt",
	sin las comillas.
	Al ejecutarlo, se imprimirá el resultado en su terminal. Si prefiere que el resultado se
	guarde en un archivo de texto, ejecute el siguiente comando: "java BFS < bfs.txt > out.txt",
	sin las comillas.

	El resultado de la prueba debería ser "[[0, 2, 3], [1, 5], [4, 6]]", donde cada [] es una
	partición de los vértices donde cada par de elementos del subconjunto de la partición existe un
	camino en el grafo.

	Cabe resaltar que, como ejemplo, se utilizo el archivo bfs.txt; sin embargo, puede ingresar el
	archivo de texto que desee.


PARTE 3:
	Para ejecutar el programa de la parte 3 se debe compilar el archivo llamado "DFS.java" con
	el comando "javac DFS.java". Para esto, debe estar en el directorio donde se encuentra el
	archivo

	Después de compilarlo, ejecute el programa con el siguiente comando en su terminal: "java DFS < _____.txt",
	sin las comillas, reemplazando en el "_____" el nombre del archivo con la matriz de adjacencia
	que quiera ingresar.

	Para que el resultado se guarde en un archivo de texto ejecute el siguiente comando:
	"java DFS < _____.txt > ####.txt", donde "####" es el nombre del archivo en el que desea
	que se guarde el resultado.


PARTE 4:
	Para ejecutar el problems de la parte 4 se debe compilar el archivo llamado "Kruskal.txt", esto se puede realizar
	por una consola ejecutando el comando "java Kruskal.java < mapaCiudad.txt", sin las comillas.

	El problema recibe un archivo de texto con las esquinas de las calles (como enteros) y los costos de convertir las
	calles a dobles v�as. Este archivo se llama mapaCiudad.txt y puede ser modificado para probar el funcionamiento
	del algoritmo.

	Se retorna la informaci�n de las esquinas y los costos que se deben convertir para solucionar el problema
