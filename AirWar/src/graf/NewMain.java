/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graf;

/**
 *
 * @author Bryan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GenerarGrafo g = new GenerarGrafo();
        g.HacerGrafo();
//        System.out.println("INFORMACION VERTICES " + g.miGrafo.getAristas());
//        System.out.println(g.miGrafo.getAristas());
//        
//        System.out.println("PRUEBAS................ ");
//        System.out.println("length  " +       g.vertices.length);
//        System.out.println("PESO  " +         g.vertices[0].getVecino(0).getPeso());
//        System.out.println("CANTIDAD VECINOS  " +         g.vertices[0].getContarVecinos());
//        System.out.println("VERTICE  " +      g.vertices[0].getVecino(0).getVertice1());
//        System.out.println("VERTICE1 X  " +   g.vertices[0].getVecino(0).getVertice1().getX());
//        System.out.println("VERTICE1 Y  " +   g.vertices[0].getVecino(0).getVertice1().getY());
//        System.out.println("VERTICE  " +      g.vertices[0].getVecino(0).getVertice2());
//        System.out.println("VERTICE1 X  " +   g.vertices[0].getVecino(0).getVertice2().getX());
//        System.out.println("VERTICE1 Y  " +   g.vertices[0].getVecino(0).getVertice2().getY());
        //vertices[i].getVecino(k).getVertice1().getX()

            
        
        
        for(int i = 0; i < 10; i++){
            
            for(int k = 0; k < g.vertices[i].getContarVecinos(); k++ ){
//                if (){
                System.out.println("PRUEBAS................ ");
                System.out.println("VERTICE  " +      g.vertices[i].getVecino(k));
                System.out.println("VERTICE  " +      g.vertices[i].getVecino(k).getVertice1());
                System.out.println("VERTICE1 X  " +   g.vertices[i].getVecino(k).getVertice1().getX());
                System.out.println("VERTICE1 Y  " +   g.vertices[i].getVecino(k).getVertice1().getY());
                System.out.println("VERTICE  " +      g.vertices[i].getVecino(k).getVertice2());
                System.out.println("VERTICE2 X  " +   g.vertices[i].getVecino(k).getVertice2().getX());
                System.out.println("VERTICE2 Y  " +   g.vertices[i].getVecino(k).getVertice2().getY());
                System.out.println("PESO  " +         g.vertices[i].getVecino(k).getPeso());
                System.out.println(g.vertices[i].getVecino(k).getVertice1().toString().charAt(9));
            }
           
            }
            
        }
    
    
    }
    

