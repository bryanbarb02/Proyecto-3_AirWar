/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Fabián Fallas
 */
public class Nodo {
    
    int name;
    int posx, posy;
    Color color;
    int d = 100;

    public Nodo(int name, int posx, int posy, Color color) {
        this.name = name;
        this.posx = posx;
        this.posy = posy;
        this.color = color;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void pintar(Graphics g){
        g.drawOval(this.posx - d/2, this.posy - d/2 , d, d);
        System.out.println(posx);
        System.out.println(posy);
      
    }
    
    
    
}
