<<<<<<< HEAD
package graf;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/*
  
 * Vertice == Nodo
=======
import java.util.ArrayList;

/*
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
 * Cada instancia a esta clase representa cada vertice
 * Cada vertice tiene asociado una etiqueta
 * Por tanto, la existencia de esta no permite vértices duplicados
 * El array de lista vecindad contiene las aristas incidentes al vértice
*/


<<<<<<< HEAD
public class Vertice {
 
    private ArrayList<Arista> vecindad;
    private String etiqueta, tipo;
    public int x,y;
    private Image image, image1,image2;
    private boolean visible;

    public Vertice (String etiqueta, int x, int y, String tipo) {
	this.etiqueta = etiqueta;
	this.vecindad = new ArrayList<Arista>();
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        visible = true;
        
        ImageIcon i = new ImageIcon(this.getClass().getResource("/images/AE2.png"));
        image2 = i.getImage();
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/PA2.png"));
        image1 = ii.getImage();
=======
public class Vertice
{
 
    private ArrayList<Arista> vecindad;
    private String etiqueta;

    public Vertice (String etiqueta)
    {
	this.etiqueta = etiqueta;
	this.vecindad = new ArrayList<Arista>();
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
    }

    /**
     * Añade un objeto Arista al array de lista vecindad
     * si y solo este no esté contenido en dicho array de lista 
     * @param arista. Objeto a añadir
     */
<<<<<<< HEAD
    public void insertarVecino(Arista arista) {
=======
    public void insertarVecino(Arista arista)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	if( !this.vecindad.contains(arista))
	    this.vecindad.add(arista);
    }

    /**
     * Comprueba si la arista incide en este vertice
     * @param arista. Objeto a evaluar
     * @return true. Si y solo si el objeto esta contenido en el array de lista vecindad
     */
<<<<<<< HEAD
    public boolean contieneUnVecino(Arista arista) {
=======
    public boolean contieneUnVecino(Arista arista)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return this.vecindad.contains(arista);
    }

    /**
     * @param indice. Indica la posicion a extraer
     * @return Arista. La arista apuntada por el índice en el array de lista vecindad
     */
<<<<<<< HEAD
    public Arista getVecino(int indice) {
=======
    public Arista getVecino(int indice)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return this.vecindad.get(indice);
    }

    /**
     * Se elimina una arista del array de lista vecindad mediante posición
     * @param indice. Indica la posicion a eliminar
     * @return Arista. La Arista que ha sido eliminada del array de lista vecindad
     */
<<<<<<< HEAD
    public Arista eliminarVecino(int indice) {
=======
    public Arista eliminarVecino(int indice)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return this.vecindad.remove(indice);
    }


    /**
     * Se elimina el objeto Arista del array de lista vecindad mediante
     * el identificando la referencia del objeto Arista
     * @param arista. indice el objeto Arista a eliminar
     */
<<<<<<< HEAD
    public void eliminarVecino(Arista arista) {
=======
    public void eliminarVecino(Arista arista)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	this.vecindad.remove(arista);
    }

    /**
     * @return int. Se devuelve el número de aristas incidentes (o vecinos) 
     * tiene el vértice en el array de lista vecindad
     */
<<<<<<< HEAD
    public int getContarVecinos() {
=======
    public int getContarVecinos()
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return this.vecindad.size();
    }

    /**
     * @return String. Devuelve el valor de la cadena etiqueta
     */
<<<<<<< HEAD
    public String getEtiqueta() {
=======
    public String getEtiqueta()
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return this.etiqueta;
    }

    /**
     * Se comprueba si vertice2 es un objeto de tipo Vertice
     * En tal caso podemos convertirlo de Object a Vertice
     * Y por último evaluamos si contiene el mismo valor que el objeto vertice actual
     * Para ello las etiquetas deben coincidir(son únicas para cada objeto Vertice) 
     * @param vertice2. Objeto que comparamos con el vertice para 
     * evaluar si son el mismo objeto
     * @return true. Efectivamente son el mismo objeto
     */
<<<<<<< HEAD
    public boolean equals(Object vertice2) {
=======
    public boolean equals(Object vertice2)
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	if( !(vertice2 instanceof Vertice))
	    return false;

	Vertice v = (Vertice) vertice2;
	return this.etiqueta.equals(v.etiqueta);
    }

    /**
     * @return String. Representación del vértice en una cadena
     */
<<<<<<< HEAD
    public String toString() {
=======
    public String toString()
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return "Vertice: " + this.etiqueta;
    }


    /**
     * @return int. Código hash para este vértice
     **/
<<<<<<< HEAD
    public int hashCode() {
=======
    public int hashCode()
    {
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
	return this.getEtiqueta().hashCode();
    }
    
    /**
     * @return ArrayList<Arista>. Copia del array de lista vecindad
     */ 
<<<<<<< HEAD
    public ArrayList<Arista> getVecinos() {
	return new ArrayList<Arista>(this.vecindad);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Image getImage(){
        if (tipo == "aeropuerto"){
            image = image2;
            return image;
        }
        if (tipo == "portaaviones"){
            image = image1;
            return image;
        }
        return null;
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }    
    public boolean isVisible(){
        return visible;
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
=======
    public ArrayList<Arista> getVecinos()
    {
	return new ArrayList<Arista>(this.vecindad);
    }
>>>>>>> 8136e12cd0ad636f7b94e966b2bfdec750eb3d36
}