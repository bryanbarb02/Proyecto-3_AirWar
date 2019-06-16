package Juego;

import Ordenamiento.*;
import graf.GenerarGrafo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 *
 * @author Bryan
 */
public class Ventana extends JPanel implements ActionListener {
    public static int nivel = 1; //Max 7                            //Pasarian 126 cambios de alineacion
    public static int cantAviones = 10; //Max 30
    
    public GenerarGrafo generarGrafo = new GenerarGrafo();

    private Image image;
    
    private BateriaAntiAerea bateriaantiaerea;
    
    
    private Layout layout;
    private static int numOrden = 1;
    static Graphics2D g2d;
    
    private Font font;
    private String vida, layoutActual, lay, nombre, edad, resistencia, clase, velocidad, destruidos;
    static int Vidas, Destruidos;
    public static Avion lastDead;
    public static CreadorDeOleadas creador = new CreadorDeOleadas();
    public static Lista oleada = new Lista();
    private Timer timer;
    
    /**
     * Constructor del juego
     */
    public Ventana(){
        setFocusable(true);
        addKeyListener(new Listener());
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/map.jpg"));
        image = ii.getImage();
        
        layout = new Layout();
        
        bateriaantiaerea = new BateriaAntiAerea();

        generarGrafo.HacerGrafo();
        creador.setVerticesCoord(generarGrafo.vertices);

        oleada = creador.newOleada();

        lay = "aleatorio";
        Vidas = 3;
        Destruidos = 0;
        font = new Font("Monospaced", Font.TYPE1_FONT,25); // Características de la letra
        vida = "Vidas: " + Vidas;
        destruidos = "Destruidos: " + Destruidos;
        
        timer = new Timer(15, this);
        
        timer.start();
         
    }

    public static int getCantDragones() {
        return cantAviones;
    }

    public static void setCantDragones(int cantDragones) {
        Ventana.cantAviones = cantDragones;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g2d = (Graphics2D)g;

        // draw Castillo fondo
        g.drawImage(image, 0, 0, getWidth(), getHeight(),this);
        // draw bateriaantiaerea
        g2d.drawImage(bateriaantiaerea.getImage(), bateriaantiaerea.getX(), bateriaantiaerea.getY(), this);
        
        // Llamada para dibujar el grafo
        drawLineaGrafo(generarGrafo);
        drawGrafo(generarGrafo);
        

        // Llamada para dibujar la oleada de Dragones
        drawAviones(oleada);
                    
        // draw Fuego
        ArrayList<Proyectil> proyactil = bateriaantiaerea.getfuego();
        for(int i = 0; i < proyactil.size(); i++){
            Proyectil l = proyactil.get(i);
            g2d.drawImage(l.getImage(), l.getX(), l.getY(), this);
            
        }
        
        
        g2d.drawImage(layout.getImage(), layout.getX(),layout.getY(),this);
        
        // draw text
        g2d.setColor(Color.black);
        g2d.setFont(font);
        g2d.drawString(vida, 1100, 100);
        
        g2d.setFont(font);
        g2d.drawString(destruidos, 1100, 120);

        g2d.drawString(vida, 1100, 100);
        g2d.drawString(layoutActual, 1080, 250);
        g2d.drawString(nombre, 1050, 390);
        g2d.drawString(velocidad, 1050, 420);
        g2d.drawString(edad, 1050, 450);
        g2d.drawString(resistencia, 1050, 480);
        g2d.drawString(clase, 1050, 510);
        
        g.dispose();
    }
    
    
    /**
     * DIBUJA LOS VERTICES
     * @param generarGrafo 
     */
    private void drawGrafo(GenerarGrafo generarGrafo){
        for (int i=0; i < generarGrafo.vertices.length;i++)
            g2d.drawImage(generarGrafo.vertices[i].getImage(), generarGrafo.vertices[i].getX(),generarGrafo.vertices[i].getY(),this);   
            
    }
        
    /**
     * DIBUJA LAS ARISTAS
     * @param grafo 
     */
    private void drawLineaGrafo(GenerarGrafo generarGrafo){
        for(int i = 0; i < 10; i++){
            for(int k = 0; k < generarGrafo.vertices[i].getContarVecinos(); k++ ){ // verifica la cantidad de conexiones de cada vertice
                g2d.setColor(Color.RED);
                g2d.drawLine(generarGrafo.vertices[i].getVecino(k).getVertice1().getX(), 
                             generarGrafo.vertices[i].getVecino(k).getVertice1().getY(), 
                             generarGrafo.vertices[i].getVecino(k).getVertice2().getX(), 
                             generarGrafo.vertices[i].getVecino(k).getVertice2().getY());
            }
        }
    }
    
    private void drawAviones(Lista oleada){
        // draw Dragones
        Avion temp = oleada.getHead();
        while (temp != null){
            g2d.drawImage(temp.getImage(), temp.getX(),temp.getY(),this);
            temp = temp.getNext();
        }
        
    }
    
//    private void drawTree (Avion tree){
//        g2d.drawImage(tree.getImage(), tree.getX(),tree.getY(),this);
//        if (tree.getLeft() != null)
//            drawTree(tree.getLeft());
//        if (tree.getRight() != null)
//        drawTree(tree.getRight());
//    }
    
    
    
    /**
     * Acciones al presionar una tecla 
     * @param e 
     */
    public void actionPerformed(ActionEvent e){
        ArrayList<Proyectil> fuego = bateriaantiaerea.getfuego();
        // Updates, acciones del bateriaantiaerea
        bateriaantiaerea.logic();     
        // Acciones del Dragon
        
        Avion temp = oleada.getHead(); // Temporal con el primer elemento de la lista de la oleada
        while (temp != null){ // La lista tiene elementos, no está vacía
            temp.logic(); // Llama al metodo que realiza el movimineto de los Dragones 
            
            if(temp.getX() == -200) // Si el dragon sobrepasa al caballeroMedieval
                    if (temp.isVisible() == true) // Verifíca que el elemento existe en pantalla 
                        Vidas -= 1; // Resta una vida al caballeroMedieval
                        if (Vidas == 0) // Si el bateriaantiaerea no tiene vidas 
                            gameOver(0); // LLamada al metodo que termina el juego
            
            
            //Hit Fuego
            for(int li = 0; li < fuego.size(); li++){
                Proyectil l = fuego.get(li);
                if(l.getLimites().intersects(temp.getBounds()) && l.isVisible() && temp.isVisible()){
                    oleada.print();
                        if (temp.getResistance() == 1){ // Si el Dragon se queda sin resistencia 
                            temp.setVisible(false); // El Dragon no es visible 
                            this.lastDead = temp; // Último Dragon eliminado
                            oleada.destroyEnemy(temp.getName()); // Elimina al Dragon de la lista
                            Destruidos += 1;
                            l.setVisible(false); // El disparo de Fuego desaparece 
//                            String ubicacionXML = creador.oleadaToXML(temp); // Escribe la información en un XML 
                        }
                        if (oleada.getHead() == null) { // Si la lista esta vacía 
//                            levelUp(); // Aumenta el nivel e incrementa la cantidad de Dragones por oleada 
                            oleada = creador.newOleada(); // Crea una nueva oleada
                            //draw(oleada);
                            break;
                        } else {
                            int i = temp.getResistance(); // Obtiene el valor de la resistencia al que golpea 
                            temp.setResistance(i - 1); // Resta una vida a la resistencia del Dragon 
                            l.setVisible(false); //El disparo de Fuego desaparece
                            
                                
                        } 
                }
                 
            }
        temp = temp.getNext(); // cambia el valor temporal al siguiente en la lista
        }
        // Disparos de Fuego
        for(int i = 0; i < fuego.size(); i++){
            Proyectil l = fuego.get(i);
            if(l.isVisible()) // Hace visible el disparo
                l.update(); // Llamada al método que mueve el Fuego
            else
                fuego.remove(i); // Demueve el disparo
        }
        
         
        // Caracteristícas dragon
        vida = "Vidas: " + Vidas; // Actualiza las vidas en pantalla
        destruidos = "Destruidos: " + Destruidos;
        layoutActual = lay; // Actualizacion de posición de dragones
        
        
        nombre = "Nombre: " + oleada.getHead().getName();
        velocidad = "Velocidad: " + oleada.getHead().getVelocidad() ;
        edad = "Edad: " + oleada.getHead().getAge();
        resistencia = "Resistencia: " + oleada.getHead().getResistance();
        clase = "Clase: " + oleada.getHead().getClassType();
      
        repaint();
    }

    private class Listener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            bateriaantiaerea.keyPressed(e);
                    timer.start();
        }

    }
    
    /**
     * Aumenta el nivel y la cantidad de Dragones 
     */
    public void levelUp(){
        this.nivel = this.nivel + 1;
        cantAviones = (int)(this.cantAviones + (this.cantAviones*0.2));
    }
    
    /**
     * Estado de juego mientras esta activo
     * @param status 
     */
    public void gameOver(int status){
        timer.stop();
        
    }
}
