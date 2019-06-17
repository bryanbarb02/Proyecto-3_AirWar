/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graf;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Bryan
 */
public class Dijkdtra {
    public Vertice[] vertices;
    int[][] grafo;
    char[]  nodos;
    String  rutaMasCorta;
    int     longitudMasCorta = Integer.MAX_VALUE;
    List<Vertice>  listos=null; // nodos revisados Dijkstra
    
    Dijkdtra(String serieNodos) {
//        nodos = serieNodos.toCharArray();
        grafo = new int[nodos.length][nodos.length];
    }
    
    public void agregarRuta() {
        for(int i = 0; i < 10; i++){
            for(int k = 0; k < vertices[i].getContarVecinos(); k++ ){ // verifica la cantidad de conexiones de cada vertice
                int n1 = posicionNodo(vertices[i].getVecino(k).getVertice1());
                int n2 = posicionNodo(vertices[i].getVecino(k).getVertice2());
                int distancia = vertices[i].getVecino(k).getPeso();
                grafo[n1][n2]=distancia;
                grafo[n2][n1]=distancia;
            }
    
        }
    }
    
    private int posicionNodo(Vertice nodo) {
        for(int i=0; i<nodos.length; i++) {
            if(nodos[i]==nodo.getEtiqueta().charAt(i)) return i;
        }
        return -1;
    }
    
    // encuentra la ruta más corta desde un nodo origen a un nodo destino
    public String encontrarRutaMinimaDijkstra(Vertice inicio, Vertice fin) {
        // calcula la ruta más corta del inicio a los demás
        encontrarRutaMinimaDijkstra(inicio);
        // recupera el nodo final de la lista de terminados
        Nodo tmp = new Nodo(fin);
        if(!listos.contains(tmp)) {
            System.out.println("Error, nodo no alcanzable");
            return "Bye";
        }
        tmp = listos.get(listos.indexOf(tmp));
        int distancia = tmp.distancia;  
        // crea una pila para almacenar la ruta desde el nodo final al origen
        Stack<Vertice> pila = new Stack<Vertice>();
        while(tmp != null) {
            pila.add(tmp);
            tmp = tmp.procedencia;
        }
        String ruta = "";
        // recorre la pila para armar la ruta en el orden correcto
        while(!pila.isEmpty()) ruta+=(pila.pop().id + " ");
        return distancia + ": " + ruta;
    }
    
        public void encontrarRutaMinimaDijkstra(Vertice inicio) {
        Queue<Vertice>   cola = new PriorityQueue<Vertice>(); // cola de prioridad
        Nodo           ni = new Nodo(inicio);          // nodo inicial
         
        listos = new LinkedList<Vertice>();// lista de nodos ya revisados
        cola.add(ni);                   // Agregar nodo inicial a la cola de prioridad
        while(!cola.isEmpty()) {        // mientras que la cola no esta vacia
            Vertice tmp = cola.poll();     // saca el primer elemento
            listos.add(tmp);            // lo manda a la lista de terminados
            int p = posicionNodo(tmp.id);   
            for(int j=0; j<grafo[p].length; j++) {  // revisa los nodos hijos del nodo tmp
                if(grafo[p][j]==0) continue;        // si no hay conexión no lo evalua
                if(estaTerminado(j)) continue;      // si ya fue agregado a la lista de terminados
                Vertice nod = new Vertice(nodos[j], tmp.distancia + grafo[p][j], tmp);
                // si no está en la cola de prioridad, lo agrega
                if(!cola.contains(nod)) {
                    cola.add(nod);
                    continue;
                }
                // si ya está en la cola de prioridad actualiza la distancia menor
                for(Vertice x: cola) {
                    // si la distancia en la cola es mayor que la distancia calculada
                    if(x.id==nod.id && x.distancia > nod.distancia) {
                        cola.remove(x); // remueve el nodo de la cola
                        cola.add(nod);  // agrega el nodo con la nueva distancia
                        break;          // no sigue revisando
                    }
                }
            }
        }
    }
    
    public boolean estaTerminado(int j) {
        Vertice tmp = new Vertice(nodos[j]);
        return listos.contains(tmp);
    }
    
    public void encontrarRutaMinimaFuerzaBruta(Vertice inicio, Vertice fin) {
        int p1 = posicionNodo(inicio);
        int p2 = posicionNodo(fin);
        // cola para almacenar cada ruta que está siendo evaluada
        Stack<Integer> resultado = new Stack<Integer>();
        resultado.push(p1);
        recorrerRutas(p1, p2, resultado);
    }
    
    private void recorrerRutas(int nodoI, int nodoF, Stack<Integer> resultado) {
        // si el nodo inicial es igual al final se evalúa la ruta en revisión
        if(nodoI==nodoF) {
            int respuesta = evaluar(resultado);
            if(respuesta < longitudMasCorta) {
                longitudMasCorta = respuesta;
                rutaMasCorta     = "";
                for(int x: resultado) rutaMasCorta+=(nodos[x]+" ");
            }
            return;
        }
        // Si el nodoInicial no es igual al final se crea una lista con todos los nodos
        // adyacentes al nodo inicial que no estén en la ruta en evaluación
        List<Integer> lista = new Vector<Integer>();
        for(int i=0; i<grafo.length;i++) {
            if(grafo[nodoI][i]!=0 && !resultado.contains(i))lista.add(i);
        }
        // se recorren todas las rutas formadas con los nodos adyacentes al inicial
        for(int nodo: lista) {
            resultado.push(nodo);
            recorrerRutas(nodo, nodoF, resultado);
            resultado.pop();
        }
    }
    
    public int evaluar(Stack<Integer> resultado) {
        int  resp = 0;
        int[]   r = new int[resultado.size()];
        int     i = 0;
        for(int x: resultado) r[i++]=x;
        for(i=1; i<r.length; i++) resp+=grafo[r[i]][r[i-1]];
        return resp;
    }
    
    public void setVerticesCoord(Vertice[] vertices) {
        this.vertices = vertices;
    }
}
