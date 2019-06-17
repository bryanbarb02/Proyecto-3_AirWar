/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graf;

import DijkstraGrafo.DijkstraAlgorithm;
import DijkstraGrafo.DijkstraEdge;
import DijkstraGrafo.DijkstraVertex;
import Ordenamiento.CreadorDeOleadas;

/**
 *
 * @author Bryan
 */
public class GenerarGrafo {
    CreadorDeOleadas c;
    public Grafo miGrafo = new Grafo();
    int i;
    public Vertice [] vertices = new Vertice[10];
    DijkstraAlgorithm dijkstra;
    
    
    
    public void HacerGrafo(){

    char [] etiquetas = {'A','B','C','D','E','F','G','H','I','J'};
    boolean sobreescribe = true;
        
        for(i = 0; i < vertices.length; i++) {
            int x = GenerarX();
            int y = GenerarY();
            vertices[i] = new Vertice(Character.toString(etiquetas[i]), x, y, GenerarTipo(x/50, y/50));  	
        }
      
        

        miGrafo.insertarArista(vertices[0], vertices[1], 3); // A -> B
        miGrafo.insertarArista(vertices[0], vertices[2], 3); // A -> C
	miGrafo.insertarArista(vertices[1], vertices[2], 1); // B -> C
	miGrafo.insertarArista(vertices[1], vertices[8], 3); // B -> I
	miGrafo.insertarArista(vertices[3], vertices[4], 3); // D -> E
	miGrafo.insertarArista(vertices[3], vertices[5], 3); // D -> F
	miGrafo.insertarArista(vertices[4], vertices[5], 1); // E -> F
	miGrafo.insertarArista(vertices[0], vertices[3], 3); // A -> D
	miGrafo.insertarArista(vertices[2], vertices[4], 2); // C -> E
        miGrafo.insertarArista(vertices[2], vertices[6], 2); // C -> G
        miGrafo.insertarArista(vertices[6], vertices[8], 3); // G -> I
        miGrafo.insertarArista(vertices[6], vertices[7], 2); // G -> H
        miGrafo.insertarArista(vertices[7], vertices[8], 1); // H -> I
        miGrafo.insertarArista(vertices[7], vertices[9], 2); // H -> J
        miGrafo.insertarArista(vertices[9], vertices[5], 2); // J -> F
        
        
       
        
        
        
//        for(int i = 0; i < vertices.length; i++) {
//		System.out.println(vertices[i]); // Representación String de la clase Vertice para este objeto
//
//		for( int k = 0; k < vertices[i].getContarVecinos(); k++)
//		    System.out.println(vertices[i].getVecino(k)); // Respresentacion String de Arista para este objeto
//	    }

	//Eliminamos las adyacencias entre B <-> C
//	for(Arista arista : vertices[1].getVecinos())
//	    {
//		if(arista.getVertice2().getEtiqueta().equals("C"))
//		    miGrafo.eliminarArista(arista);
//	    }
//
//	for(Arista arista : vertices[2].getVecinos())
//	    {
//		if(arista.getVertice2().getEtiqueta().equals("B"))
//		    miGrafo.eliminarArista(arista);
//	    }

	//Y las adyacencias entre E <-> F
	
//	for(Arista arista : vertices[4].getVecinos())
//	    {
//		if(arista.getVertice2().getEtiqueta().equals("E"))
//		    miGrafo.eliminarArista(arista);
//	    }

//	for(Arista arista : vertices[5].getVecinos())
//	    {
//		if(arista.getVertice2().getEtiqueta().equals("F"))
//		    miGrafo.eliminarArista(arista);
//	    }
        
        
        for(i = 0; i < vertices.length; i++) {
//            vertices[i] = new Vertice(Character.toString(etiquetas[i]), GenerarX(), GenerarY(), GenerarTipo());
            
            System.out.println(vertices[i] +  "," + vertices[i].getX() +  "," + vertices[i].getY() +  "," + vertices[i].getTipo());	
            System.out.println(vertices[i].getVecinos() + "\n");  
//            Dijkdtra d = null;
            
//            d.encontrarRutaMinimaFuerzaBruta(vertices[0].getVecino(0).getVertice1(), vertices[3].getVecino(0).getVertice2());
        }
        
        
        //Sacamos nuevamente las adyacencias y los triángulos originales han perdido sus bases
	for(int i = 0; i < vertices.length; i++)
	    {
	     	System.out.println(vertices[i]);
	    	
	    	for( int k = 0; k < vertices[i].getContarVecinos(); k++)
	    	    System.out.println(vertices[i].getVecino(k));
	    }
     
    }

    private int GenerarX(){
        return 50 * (int) Math.floor(Math.random()*20);
    }
    
    private int GenerarY(){
        return 50 * (int) Math.floor(Math.random()*10);
    }
    
//    private String GenerarTipo(){
//            //Lista con las clases predefinidas para los Dragones
//            String[] clases = {"aeropuerto", "aeropuerto"}; // "portaaviones"
//
//            //Indice creado aleatoriamente
//            int indice = (int) Math.floor(Math.random()*(1-0+1)+0);
//
//            //Devuelve la clase accesada
//            return clases[indice];
////        }
//    }
    int pos[][] = {{0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0},//0
                   {1,1,1,1,1,1,1,0,1,0,0,0,1,0,1,1,1,1,1,1,1},//50
                   {0,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,1},//100
                   {0,0,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,0},//150
                   {0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0},//200
                   {0,0,0,0,0,1,0,0,0,0,1,1,1,1,0,1,0,0,0,0,0},//250
                   {0,0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0,1,0,0,0},//300
                   {0,0,0,0,0,0,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0},//350
                   {0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,1,0},//400
                   {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//450
                   {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//500
                  };
    
    private String GenerarTipo(int i, int j){
        int indice = 0;
        
        for (int x = 0; x < 21;x++) {
            if(x == i ){
                for (int y = 0; y < 11; y++) {
                    if ( y == j){
                        indice = pos[j][i];
                        x = 21;
                        y = 11;
                    }   
                }
            }
	}
        String[] clases = {"portaaviones", "aeropuerto"};
//        return indice;
        return clases[indice];
    }
    public void ruta(char L){
        DijkstraVertex[] vert = {
                                    new DijkstraVertex("A"),
                                    new DijkstraVertex("B"),
                                    new DijkstraVertex("C"),
                                    new DijkstraVertex("D"),
                                    new DijkstraVertex("E"),
                                    new DijkstraVertex("F"),
                                    new DijkstraVertex("G"),
                                    new DijkstraVertex("H"),
                                    new DijkstraVertex("I"),
                                    new DijkstraVertex("J"),};
        
        
            DijkstraVertex A = vert[0];
            DijkstraVertex B = vert[1];
            DijkstraVertex C = vert[2];
            DijkstraVertex D = vert[3];
            DijkstraVertex E = vert[4];
            DijkstraVertex F = vert[5];
            DijkstraVertex G = vert[6];
            DijkstraVertex H = vert[7];
            DijkstraVertex I = vert[8];
            DijkstraVertex J = vert[9];

            DijkstraEdge[] eges = {
                                    new DijkstraEdge(A, B, vertices[0].getVecino(0).getPeso()),
                                    new DijkstraEdge(A, C, vertices[0].getVecino(1).getPeso()),
                                    new DijkstraEdge(B, C, vertices[1].getVecino(1).getPeso()),
                                    new DijkstraEdge(B, I, vertices[1].getVecino(2).getPeso()),
                                    new DijkstraEdge(D, E, vertices[3].getVecino(0).getPeso()),
                                    new DijkstraEdge(D, F, vertices[3].getVecino(1).getPeso()),
                                    new DijkstraEdge(E, F, vertices[4].getVecino(2).getPeso()),
                                    new DijkstraEdge(A, D, vertices[0].getVecino(2).getPeso()),
                                    new DijkstraEdge(C, E, vertices[2].getVecino(2).getPeso()),
                                    new DijkstraEdge(C, G, vertices[2].getVecino(3).getPeso()),
                                    new DijkstraEdge(G, I, vertices[6].getVecino(1).getPeso()),
                                    new DijkstraEdge(G, H, vertices[6].getVecino(2).getPeso()),
                                    new DijkstraEdge(H, I, vertices[7].getVecino(1).getPeso()),
                                    new DijkstraEdge(H, J, vertices[7].getVecino(2).getPeso()),
                                    new DijkstraEdge(J, F, vertices[9].getVecino(1).getPeso())};
            
            
            DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(vert, eges);
            int c = (int) Math.floor(Math.random()*(9-0+1)+0);
//            char fi = DijkstraVertex[c];
//            dijkstra.getShortestPath(L, fi);
//            dijkstra.printShortestPath(L, fi);
    }
}



