package Juego;

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
    private int dx,dy,lanzarFuegoPosib;
    private final int Velocidad;
    private ArrayList lanzarFuego;
    private Random random;
    private boolean visible; 
    
    private String name;
    private int rechargeSpeed;
    private int age;
    private int resistance;
    private String classType;
    private Avion padre;
    private Avion hijo1;
    private Avion hijo2;
    
    private int x;
    private int y;
    
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
        
        ImageIcon i = new ImageIcon(this.getClass().getResource("/images/dragon1.gif"));
        image1 = i.getImage();
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/dragon2.gif"));
        image2 = ii.getImage();
        ImageIcon iii = new ImageIcon(this.getClass().getResource("/images/dragon3.gif"));
        image3 = iii.getImage();
        
        
        this.x = x;
        this.y = y;
        Velocidad = 2;        
        visible = true;
        dx = 0;
        dy = 0;
        lanzarFuegoPosib = 100;
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
    public int getVelocidad(){
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
     public Avion getPadre() {
        return padre;
    }
    public void setPadre(Avion padre) {
        this.padre = padre;
    }
    public Avion getHijo1() {
        return hijo1;
    }
    public void setHijo1(Avion hijo1) {
        this.hijo1 = hijo1;
    }
    public Avion getHijo2() {
        return hijo2;
    }
    public void setHijo2(Avion hijo2) {
        this.hijo2 = hijo2;
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



    /**
     * Se generaran las coordenadas automaticamente con su posicion de ingreso
     * @param i - posicion
     */
    public void generateCoords(int i){
        int x = 900;
        int y;

        if (i == 1) {
            y = 285;
            x = x + 80*0;
        } else if (i <= 3) { //2-3
            y = 245 + (80*(i-2));
            x = x + 80*1;
        } else if (i <= 6) { //4-5-6
            y = 205 + (80*(i-4));
            x = x + 80*2;
        } else if (i <= 10) { //7-8-9-10
            y = 165 + (80*(i-7));
            x = x + 80*3;
        } else if (i <= 15) { //11-12-13-14-15
            y = 125 + (80*(i-11));
            x = x + 80*4;
        } else if (i <= 21) { //16-17-18-19-20-21
            y = 85 + (80*(i-16));
            x = x + 80*5;
        } else if (i <= 28) { //22-23-24-25-26-27-28
            y = 45 + (80*(i-22));
            x = x + 80*6;
        } else { //29-30-31-32-33-34-35-36 - - - >
            i = ((i-29) + 8);
            y = 5 + (80 * (i%8));
            x = (x + (80*7)) + ((i-8)/8)*80;
        }

        this.setY(y);
        this.setX(x);
    }
    
    
    
    
    
    /**
     * Acciones de movimiento de los dragones  
     */
    public void logic(){
        if((x>0 && dx<0) || (x<795 && dx>-10)) // Límites de la pantalla en y
            x += dx;
            dx = Velocidad * -1;
            
        if((y>0 && dy<0) || (y<370 && dy>0)) // Límites de la pantalla en x
            y += dy;
        
        if(random.nextInt()% lanzarFuegoPosib == 1 && x > 0) // fuego dragones
            lanzarFuego.add(new Proyectil(x, y));
    }
    /**
     * Arreglo en donde se crean los proyectiles 
     * @return 
     */
    public ArrayList getFuegos(){
        return lanzarFuego;
    }
    /**
     * Dimenciones de la imagen (Hitbox)
     * @return 
     */
    public Rectangle getBounds(){
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}
