<<<<<<< HEAD
package graf;

public class Arista implements Comparable<Arista> {
=======
/*
 * Un objeto Arista modela una arista no dirigida que representa la relación de adyacencia
 * entre dos vértices. Por tanto una arista tiene dos vértices.
 * Si el peso de una arista no se especifica, su valor es 1. Esto permite representar grafos uniformes.
*/

public class Arista implements Comparable<Arista>
{
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
    private Vertice vertice1, vertice2;
    private int peso;

    /**
     * Constructor de un objeto Arista uniforme
     * @param vertice1. Extremo o vértice de la arista
     * @param vertice2. Segundo extremo o vértice para formar la arista
     **/
<<<<<<< HEAD
    public Arista(Vertice vertice1, Vertice vertice2) {
=======
    public Arista(Vertice vertice1, Vertice vertice2)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	this(vertice1, vertice2, 1);
    }

    /**
     * Se detalla la construcción de la arista. El vertice lexicograficamente
     * menor se representa en la parte superior del grafo (vertice1)
     * y el vertice cuya etiqueta es lexicograficamente mayor en la inferior (vertice2)
     *
     * @param vertice1. Extremo o vértice de la arista
     * @param vertice2. Segundo vértice para formar la arista
     * @param peso. Define el coste de ir desde el vertice1 al vertice2 y viceversa(arista no dirigida)
     **/
<<<<<<< HEAD
    public Arista(Vertice vertice1, Vertice vertice2, int peso) {
	if(vertice1.getEtiqueta().compareTo(vertice2.getEtiqueta()) <= 0) {
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	    }
	else {
		this.vertice1 = vertice2;
		this.vertice2 = vertice1;
	    }
     	this.peso = peso;	
=======
    public Arista(Vertice vertice1, Vertice vertice2, int peso)
    {
	if(vertice1.getEtiqueta().compareTo(vertice2.getEtiqueta()) <= 0)
	    {
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	    }
	else
	    {
		this.vertice1 = vertice2;
		this.vertice2 = vertice1;
	    }

     	this.peso = peso;
		
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
    }


    /** 
     * Dado un Vértice válido como parámentro de entrada
     * se devuelve su adyecente. Estos se conectan mediante una arista
     *
     * @param actual
     * @return el vecino adyecente mediante este objeto Arista
     **/
<<<<<<< HEAD
    public Vertice getVecinoDe(Vertice actual) {
=======
    public Vertice getVecinoDe(Vertice actual)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	if (actual.equals(this.vertice1))
	    return this.vertice2;
	else if( actual.equals(this.vertice2))
	    return this.vertice1;
	else
	    return null;
    }

    /**
     * @return el contenido del atributo vertice1 de tipo Vertice
     **/
<<<<<<< HEAD
    public Vertice getVertice1() {
=======
    public Vertice getVertice1()
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return this.vertice1;
    }
    
    /**
     * @return el contenido del atributo vertice2 de tipo Vertice
     **/
<<<<<<< HEAD
    public Vertice getVertice2() {
=======
    public Vertice getVertice2()
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return this.vertice2;
    }

    /**
     * @return el valor de tipo entero del atributo peso
     **/
<<<<<<< HEAD
    public int getPeso() {
=======
    public int getPeso()
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return this.peso;
    }

    /**
     * Modificador del atributo peso
     * 
     * @param peso. Nuevo coste de la arista
     **/
<<<<<<< HEAD
    public void setPeso(int peso) {
=======
    public void setPeso(int peso)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	this.peso = peso;
    }

    /**
     * Comparamos el coste de esta arista con el coste
     * de otra arista como parámentro de entrada llamada arista2
     * 
     * @param arista2. Arista con la que comparamos nuestra arista actual
     * @return int. Se devuelve 0 en caso de que ambas tengan el mismo peso
     **/
<<<<<<< HEAD
    public int compareTo(Arista arista2) {
=======
    public int compareTo(Arista arista2)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return this.peso - arista2.peso;
    }

    /**
     * @return String. Representación mediante una cadena de este objeto Arista
     **/
<<<<<<< HEAD
    public String toString() {
=======
    public String toString()
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return "({" + this.vertice1 + ", " + this.vertice2  + "}, "+ this.peso  +")";
    }


    /**
     * @return int. Código hash para esta arista
     **/
<<<<<<< HEAD
    public int hashCode() {
=======
    public int hashCode()
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return (vertice1.getEtiqueta() + vertice2.getEtiqueta()).hashCode();
    }
    
    /**
     * Se comparan el objeto Arista actual y otro que pasamos como parámetro de entrada
     * Queremos saber si son idénticos. Para ello sus vértices definidos como atributos
     * han de de ser iguales. Por lo que en el último if la responsabilidad se delega a
     * al método equals de la clase Vertice.
     *
     * @param objeto. Se comprueba si es de tipo Arista. Y si lo es, se compara e identifica.
     * @return true. Si y solo si ambos objetos son idénticos(extremos iguales).
     **/
<<<<<<< HEAD
    public boolean equals(Arista objeto) {
=======
    public boolean equals(Arista objeto)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	if(!(objeto instanceof Arista))
	    return false;

	Arista arista2 = (Arista) objeto;

	if(arista2.vertice1.equals(this.vertice1) && arista2.vertice2.equals(this.vertice2))
	    return true;

	return false;
    }
}
