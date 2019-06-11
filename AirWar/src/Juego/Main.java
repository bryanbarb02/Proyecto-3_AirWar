package Juego;

import Ordenamiento.*;
import javax.swing.JFrame;
/**
 *
 * @author Bryan
 */
public class Main extends JFrame {
    
    
    /**
     * Constructor de la ventana de juego
     */
    public Main(){
        add(new Ventana());
        setTitle("Game of Sorts");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1350,645);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Main();
    }

}
