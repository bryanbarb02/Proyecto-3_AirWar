package Juego;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

/**
 *
 * @author Bryan
 */
public class Proyectil {
    protected Image image;
    protected int x,y;
    private final int Velocidad = 5;
    private boolean visible;

    /**
     * Constructor de los proyectiles de fuego
     * @param x - Posición en x
     * @param y - Posición en y
     */
    public Proyectil(int x, int y){
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/fuego.gif"));
        image = ii.getImage();
        visible = true;
        this.x = x-image.getWidth(null)/2;
        this.y = y;
    }

    //Métodos setters y getters
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Image getImage(){
        return image;
    }
    
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    
    /**
     * Dimenciones de la imagen (Hitbox)
     * @return 
     */
    public Rectangle getLimites(){
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
    
    /**
     * Visualizar el proyectil  
     * @return 
     */
    public boolean isVisible(){
        return visible;
    }
    
    /**
     * Movimiento del proyectil 
     */
    public void update(){
        y -= Velocidad;
        if(y<0)
            visible = false;
    }
}
