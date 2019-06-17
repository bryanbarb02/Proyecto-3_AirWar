package Juego;

import graf.Vertice;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Representa un dragon.
 * @author Bryan
 */
public class Avion {
    private Image image, image1,image2,image3;
    private double dx,dy;
    private final double Velocidad;
    private ArrayList lanzarFuego;
    private Random random;
    private boolean visible; 
    
    private String name;
    private int rechargeSpeed;
    private int age;
    private int resistance;
    private String classType;
    
    private int x;
    private int y;
    private int direc, i;
    
    //Atributos en lista
    private Avion next;
    private Avion prev;

    //Atributos en Ã¡rbol
    private int height = 1;
    private Avion left = null;
    private Avion right = null;
   
    
    /**
     * Constructor del Dragon 
     * @param x - posición en x
     */
    public Avion(String name, int rS, int age, int resistance, String classType){
        
        ImageIcon i = new ImageIcon(this.getClass().getResource("/images/avion4.png"));
        image1 = i.getImage();
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/avion2.png"));
        image2 = ii.getImage();
        ImageIcon iii = new ImageIcon(this.getClass().getResource("/images/avion3.png"));
        image3 = iii.getImage();
        
        this.x = x;
        this.y = y;
        Velocidad = 0.1;        
        visible = true;
        dx = 0;
        dy = 0;
        direc = 1;

        lanzarFuego = new ArrayList();
        random = new Random();
        
        this.name = name;
        this.rechargeSpeed = rS;
        this.age = age;
        this.resistance = resistance;
        this.classType = classType;
    
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
    public double getVelocidad(){
        return Velocidad;
    }    
    public Image getImage(){
        if (classType == "Comandante"){
            image = image3;
            return image;
        }
        if (classType == "Capitan"){
            image = image1;
            return image;
        }
        if (classType == "Infante"){
            image = image2;
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
    
    
     public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRechargeSpeed() {
        return rechargeSpeed;
    }
    public void setRechargeSpeed(int rechargeSpeed) {
        this.rechargeSpeed = rechargeSpeed;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getResistance() {
        return resistance;
    }
    public void setResistance(int resistance) {
        this.resistance = resistance;
    }
    public String getClassType() {
        return classType;
    }
    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Avion getNext() {
        return next;
    }
    public void setNext(Avion next) {
        this.next = next;
    }
    public Avion getPrev() {
        return prev;
    }
    public void setPrev(Avion prev) {
        this.prev = prev;
    }
    
    //Getters & Setters al estar en Ã¡rbol

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Avion getLeft() {
        return left;
    }

    public void setLeft(Avion left) {
        this.left = left;
    }

    public Avion getRight() {
        return right;
    }

    public void setRight(Avion right) {
        this.right = right;
    }

    
    
    public void generateCoords(Vertice[] vertices){
        this.i = (int) Math.floor(Math.random()*(9-0+1)+0);
        this.setY(vertices[i].getY());
        this.setX(vertices[i].getX());
    }  
    
    /**
     * Acciones de movimiento de los dragones  
     */
    public void logic(){
        if((x>0 && dx<0) || (x<795 && dx>-10)) // Límites de la pantalla en y
            x += Velocidad * -0.1;

        
    }

    /**
     * Dimenciones de la imagen (Hitbox)
     * @return 
     */
    public Rectangle getBounds(){
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}
