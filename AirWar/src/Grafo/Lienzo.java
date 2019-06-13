/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Fabián Fallas
 */
public class Lienzo extends JPanel implements MouseListener {
    ArrayList<Nodo> nodos;
    ArrayList<Arco> arcos;
    int cantNodos = 0;
    Nodo nodoinicial = null, nodofinal = null;
    int tamNodos = 30;
    int[][] matriz;
    //@SuppressWarnings("unchecked")
    
    public Lienzo(){
        this.nodos = new ArrayList(){};
        this.arcos =  new ArrayList(){};
        
        //this.addMouseListener(this);
    }
    public void paint(Graphics g){
            for (Nodo nodos : nodos){
                nodos.pintar(g);
                //nodos.pintar(g);
    
            }
            for (Arco enlace : arcos){
              //  enlace.pintar(g);
            }
    
    }

    //private void Insertar(Graphics g){
        
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        
        if (e.getButton() == MouseEvent.BUTTON1){
           
                    int pos;                   
                    int nCartas = 1;
                    int nCar = 1;
                    int Nmero = 200;
                    int pCas = 0;
                   // int Y = 0;
                    LinkedList < Integer > pCar = new LinkedList < Integer > ();
                    LinkedList < Integer > pCartas = new LinkedList < Integer > ();
                    
                    for (int i = 0; i < nCartas ; i++) {
                        pos = (int) Math.floor(Math.random() * Nmero );
                    while (pCartas.contains(pos)) {
                        pos = (int) Math.floor(Math.random() * Nmero );
                    }
                        pCartas.push(pos);
                    }
                    for (int X: pCartas) {
  //                      getX(X);
                        System.out.println ( X);
                    for (int i = 0; i < nCartas ; i++) {
                        pos = (int) Math.floor(Math.random() * Nmero );
                    while (pCar.contains(pos)) {
                        pos = (int) Math.floor(Math.random() * Nmero );
                        }
                    pCar.push(pos);
                        }
                    for (Integer Y: pCar) {
//                         getY(Y);
                        System.out.println (Y);
                        }
                    //g.setColor(Color.BLACK);
                    //g.fillOval(e.getX() - (tamNodos/2), e.getY() - (tamNodos/2), tamNodos, tamNodos);
                    nodos.add(new Nodo(cantNodos, e.getX()- (tamNodos/2), e.getY()- (tamNodos/2), Color.BLACK));
                    //g.setColor(Color.yellow);
                    //g.drawString(Integer.toString(cantNodos), e.getX(), e.getY());
                    cantNodos++;
                    repaint();
                    }} /*else{
                    if(nodoinicial == null){
                        nodoinicial = BuscarNodo(e.getX(), e.getY());
                        if(nodoinicial != null){
                            seleccionarNodo(nodoinicial, g, Color.red);
                        }
                    }else{
                        nodofinal = BuscarNodo(e.getX(), e.getY());
                        if(nodofinal!=null){
                            seleccionarNodo(nodofinal, g, Color.red);
                            if(nodofinal.name != nodoinicial.name){
                                g.setColor(Color.black);
                                g.drawLine(nodoinicial.posx + (tamNodos/2), nodoinicial.posy + (tamNodos/2), 
                                        nodofinal.posx + (tamNodos/2), nodofinal.posy + (tamNodos/2));
                                int distancia = distancia(nodoinicial.posx + (tamNodos/2), 
                                        nodofinal.posx + (tamNodos/2), nodoinicial.posy + (tamNodos/2), nodofinal.posy + (tamNodos/2));
                                arcos.add(new Arco(nodoinicial.name, nodofinal.name, 
                                        nodoinicial.posx + (tamNodos/2), nodoinicial.posy + (tamNodos/2), 
                                        nodofinal.posx + (tamNodos/2), nodofinal.posy + (tamNodos/2), distancia));
                                System.out.println("distancia: " + distancia);
                            }else{
                                seleccionarNodo(nodoinicial, g, Color.black);
                            }
                            seleccionarNodo(nodoinicial, g, Color.black);
                            seleccionarNodo(nodofinal, g, Color.black);
                            nodoinicial = null;
                        }else{
                            seleccionarNodo(nodoinicial, g, Color.black);
                            nodoinicial = null;
                        }
                    }
                }*/
        }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    private int distancia(int x1, int x2, int y1, int y2){
        double dist = Math.sqrt(Math.pow(x2-x1, 2.0) + Math.pow(y2-y1, 2.0));
        return (int)dist;
    }
    
    private void seleccionarNodo(Nodo nodo, Graphics g, Color color){
        g.setColor(color);
        g.drawOval(nodo.posx, nodo.posy, tamNodos-1, tamNodos-1);
    }
    
    private Nodo BuscarNodo(int coordx, int coordy){
        Nodo nodoReturn = null;
        for (Nodo nodo : nodos) {
            if(coordx >= nodo.posx && coordx <= nodo.posx + tamNodos && 
                    coordy >= nodo.posy && coordy <= nodo.posy + tamNodos){
                nodoReturn = nodo;
                break;
            }
        }
        return nodoReturn;
    }
    
    private void calcularMatriz(){
        matriz = new int[nodos.size()][nodos.size()];
        for (Arco arco : arcos) {
            matriz[arco.nodoinicial][arco.nodofinal] = arco.dist;
            matriz[arco.nodofinal][arco.nodoinicial] = arco.dist;
        }
    }
    
    private void Prim(int[][] matriz){
        boolean vector[]  =new boolean[nodos.size()];
        vector[0] = true;
        while(faltaAlguno(vector)){
            int min = menor(matriz, vector);
            vector[min] = true;
        }
    }
    
    private int menor(int[][] matriz, boolean[] vector){
        int menor = Integer.MAX_VALUE;
        int fila = -1, col=-1;
        for (int i = 0; i < matriz.length; i++) {
            if(vector[i]){
                for (int j = 0; j < matriz.length; j++) {
                    if(matriz[j][i]!=0 && vector[j]==false && matriz[j][i]<=menor){
                        menor = matriz[j][i];
                        fila = j;
                        col = i;
                    }
                }
            }
        }
        System.out.println("" + fila + " - " + col);
        return fila;
    }
    
    private boolean faltaAlguno(boolean[] vector){
        for (int i = 0; i < vector.length; i++) {
            if(!vector[i]){
                return true;
            }
        }
        return false;
    }
    
}
