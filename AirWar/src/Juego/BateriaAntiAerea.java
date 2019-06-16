package Juego;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class BateriaAntiAerea {
    private Image image;
    private int x, y, direccion, moverX;
    private final int velocidad, rango;
    private ArrayList proyectil;
    
    /**
     * Constructor BateriaAntiAerea
     */
    public BateriaAntiAerea(){
//        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/Hipogrifo.gif"));
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/bateria.png"));
        image = ii.getImage();
        y = 550; // posición inicial en y
        x = 50-image.getWidth(null)/2; // posición inicial en x
        proyectil = new ArrayList();
        rango = 950; // distancia de movimiento
        direccion = 1; // -1 izquierda, 1 derecha 
        moverX = 0; 
        velocidad = 7;
    }
    
    //Métodos getters
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Image getImage(){
        return image;
    }

    public ArrayList getfuego(){
        return proyectil;
    }
    public ArrayList setfuego(){
        return null;
    }
    
    /**
     * 
     */
    public void logic(){
        if(moverX > rango){
            moverX = 0;
            direccion *=- 1;
        }
        else{
            x += velocidad * direccion;
            moverX += velocidad;
        }
    }
    
    /**
     * 
     * @param e 
     */
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();    
        if(key == KeyEvent.VK_SPACE)
            proyectil.add(new Proyectil(x + image.getWidth(null)/2, y));
    }

    /**
     * Dimenciones de la imagen (Hitbox)
     * @return 
     */
    public Rectangle getBounds(){
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}
