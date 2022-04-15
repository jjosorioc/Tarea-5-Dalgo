1.
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
	referencia a l vertice "0".