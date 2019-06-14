/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrafoMapa;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Bryan
 */
public class NodoGrafo {
    private Image image, image1,image2;
    private boolean visible;
    
    private String tipo;
    
    private int x;
    private int y;
    
    private NodoGrafo next;
    private NodoGrafo prev;
    
    public NodoGrafo(int x, int y, String tipo){
    
        ImageIcon i = new ImageIcon(this.getClass().getResource("/images/AE2.png"));
        image1 = i.getImage();
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/PA2.png"));
        image2 = ii.getImage();
        
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        visible = true;
    }
    
    //Métodos setters y getters
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
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
    
    public NodoGrafo getNext() {
        return next;
    }
    public void setNext(NodoGrafo next) {
        this.next = next;
    }
    public NodoGrafo getPrev() {
        return prev;
    }
    public void setPrev(NodoGrafo prev) {
        this.prev = prev;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}
