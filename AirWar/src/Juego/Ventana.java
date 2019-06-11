package Juego;

import Ordenamiento.*;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
/**
 *
 * @author Bryanbar
 */
public class Ventana extends JPanel implements ActionListener {
    public static int nivel = 1; //Max 7                            //Pasarian 126 cambios de alineacion
    public static int cantDragones = 6; //Max 30
    public static CreadorDeOleadas creador = new CreadorDeOleadas();
    public static Lista oleada = new Lista();
    
    private Image image;
    private Timer timer;
    private BateriaAntiAerea bateriaantiaerea;
    public static Avion lastDead;
    private Layout layout;
    private AVLTree avlTree = new AVLTree();
    private BinaryTree binary = new BinaryTree();
    private static int numOrden = 1;
    static Graphics2D g2d;
    
    private Font font;
    private String vida, layoutActual, lay, nombre, edad, resistencia, clase, velocidad, destruidos;
    static int Vidas, Destruidos;
    
    
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
        return cantDragones;
    }

    public static void setCantDragones(int cantDragones) {
        Ventana.cantDragones = cantDragones;
    }
    
    

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g2d = (Graphics2D)g;
        
        
        // draw Castillo fondo
        g.drawImage(image, 0, 0, getWidth(), getHeight(),this);
        // draw bateriaantiaerea
        g2d.drawImage(bateriaantiaerea.getImage(), bateriaantiaerea.getX(), bateriaantiaerea.getY(), this);
        
        // Llamada para dibujar la oleada de Dragones
        draw(oleada);
                    
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
    
    
    private void draw(Lista oleada){
        // draw Dragones
        Avion temp = oleada.getHead();
        while (temp != null){
            g2d.drawImage(temp.getImage(), temp.getX(),temp.getY(),this);
            temp = temp.getNext();
        }
        
    }
    
    private void drawTree (Avion tree){
        g2d.drawImage(tree.getImage(), tree.getX(),tree.getY(),this);
        if (tree.getLeft() != null)
            drawTree(tree.getLeft());
        if (tree.getRight() != null)
        drawTree(tree.getRight());
    }
    
    
    
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
            
            if(temp.getX() == -80) // Si el dragon sobrepasa al caballeroMedieval
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
                            System.out.println("Empty");
                            levelUp(); // Aumenta el nivel e incrementa la cantidad de Dragones por oleada 
                            oleada = creador.newOleada(); // Crea una nueva oleada
                            //draw(oleada);
                            break;
                        } else {
                            int i = temp.getResistance(); // Obtiene el valor de la resistencia al que golpea 
                            temp.setResistance(i - 1); // Resta una vida a la resistencia del Dragon 
                            l.setVisible(false); //El disparo de Fuego desaparece
                            if (temp.getResistance()== 0) // Si el dragon se queda sin resistencia
                                reorganice(oleada); // Cambia el ordenamiento de la oleada
                                
                        }
                        //Enviar servidor ubicacionXML 
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
//        @Override
//        public void keyReleased(KeyEvent e){
//            caballeroMedieval.keyReleased(e);       
//        }
    }
    /**
     * Método de reorganizacion de los Dragones 
     * @param oleada 
     */
    private void reorganice(Lista oleada){
        System.out.println(oleada.getHead());
        int i = (numOrden + 3) % 3;
        
        switch (i) {
            case 1: // Cambia el ordenamiento por Selection Sort
                System.out.println("1: " + i);
                //oleada = creador.selectionSort(oleada);
                oleada = creador.recreateOleada(oleada);
                draw(oleada);
                lay = "Selection Sort";
                break;
            case 2: // Cambia el ordenamiento por Insertion Sort
                System.out.println("2: " + i);
                //oleada = creador.insertionSort(oleada);
                oleada = creador.recreateOleada(oleada);
                draw(oleada);
                lay = "Insertion Sort";
                break;
            //case 3: // Cambia el ordenamiento por Quick Sort
            default:
                System.out.println("3: " + i);
                //oleada = creador.quickSort(oleada);
                oleada = creador.recreateOleada(oleada);
                draw(oleada);
                lay = "Quick Sort";
                break;
            /*case 4: // Cambia el ordenamiento por Binary Tree
                System.out.println("4: " + i);
                binary = creador.turnToBinaryTree(oleada);
                drawTree(binary.getRoot());
                lay = "Binary Tree";
                break;*/
           /* default: // Cambia el ordenamiento por AVLTree
                System.out.println("5: " + i);
                avlTree = creador.turnToAVLTree(oleada);
                drawTree(avlTree.getRoot());
                lay = "AVL Tree";
                break;*/
        }
        numOrden+=1;
        System.out.println("NumOrden: " + numOrden);
                    
    }
    /**
     * Aumenta el nivel y la cantidad de Dragones 
     */
    public void levelUp(){
        this.nivel = this.nivel + 1;
        cantDragones = (int)(this.cantDragones + (this.cantDragones*0.2));
    }
    
    
    /**
     * 
     * 
     * 
     * 
     */
    
    
    
    /**
     * Estado de juego mientras esta activo
     * @param status 
     */
    public void gameOver(int status){
        timer.stop();
    }
}
