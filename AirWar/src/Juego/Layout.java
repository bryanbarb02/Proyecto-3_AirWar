/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;


/**
 *
 * @author Bryan
 */
public class Layout {
    private Image image;
    private int x,y;
    
    public Layout(){
        x = 1045;
        y = 0;
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/Layout.jpg"));
        image = ii.getImage();  
    }
    
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Image getImage(){
        return image;
    }
    
    public void paint(Graphics g){
        g.drawImage(image, getX(), getY(), (ImageObserver) this);
        g.dispose();
    } 
    
    
}
