package Ordenamiento;

import Juego.*;

/**
 * Representación de un Binary Tree.
 *
 * @author Rubén Salas
 * @since 30/10/18
 * @version 1.1
 */
public class BinaryTree {
    private Avion root;

    public BinaryTree(){
        this.root = null;
    }

    //Getters & Setters
    public Avion getRoot() {
        return root;
    }

    public void setRoot(Avion root) {
        this.root = root;
    }


    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Recorre el arbol y lo imprime en Preorden
     */
    public void preOrder() {
        this.preOrderAux(this.getRoot());
    }

    /**
     * Auxiliar de preOrder
     * @param node - root
     */
    private void preOrderAux(Avion node) {
        if (node != null) {
            System.out.print(node.getName() + " ");
            preOrderAux(node.getLeft());
            preOrderAux(node.getRight());
        }
    }
    
    /**
     * Genera las coordenadas del arbol
     * @param cantidad
     */
    public void generateCoordsTree(int cantidad){
        int x = 900;
        int y = 285;
        Avion d1;
        
        Dragon d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15; 
        if (cantidad == 1){
            d1 = this.getRoot();
            d1.setX(x); d1.setY(y);
        } else if (cantidad == 2){
            d1 = this.getRoot();
            d1.setX(x); d1.setY(y);
            d2 = d1.getLeft();                                                  d3 = d1.getRight();
            d2.setX(x+80); d2.setY(y+160); 
        } else if (cantidad == 3){
            d1 = this.getRoot();
            d1.setX(x); d1.setY(y);
            d2 = d1.getLeft();                                                  d3 = d1.getRight();
            d2.setX(x+80); d2.setY(y+160);                                      d3.setX(x+80); d3.setY(y-160);
        } else if (cantidad == 4){
            d1 = this.getRoot();
            d1.setX(x); d1.setY(y);
            d2 = d1.getLeft();                                                  d3 = d1.getRight();
            d2.setX(x+80); d2.setY(y+160);                                      d3.setX(x+80); d3.setY(y-160);
            d4 = d2.getLeft();                                                  d6 = d3.getLeft();                      d7 = d3.getRight();
            d4.setX(x+160); d4.setY(y+240);
        } else if (cantidad == 5){
            d1 = this.getRoot();
            d1.setX(x); d1.setY(y);
            d2 = d1.getLeft();                                                  d3 = d1.getRight();
            d2.setX(x+80); d2.setY(y+160);                                      d3.setX(x+80); d3.setY(y-160);
            d4 = d2.getLeft();                  d5 = d2.getRight();             d6 = d3.getLeft();                      d7 = d3.getRight();
            d4.setX(x+160); d4.setY(y+240);     d5.setX(x+160); d5.setY(y+80);
        } else if (cantidad == 6){
            d1 = this.getRoot();
            d1.setX(x); d1.setY(y);
            d2 = d1.getLeft();                                                  d3 = d1.getRight();
            d2.setX(x+80); d2.setY(y+160);                                      d3.setX(x+80); d3.setY(y-160);
            d4 = d2.getLeft();                  d5 = d2.getRight();             d6 = d3.getLeft(); 
        } else if (cantidad == 7){
            d1 = this.getRoot();
            d1.setX(x); d1.setY(y);
            d2 = d1.getLeft();                                                  d3 = d1.getRight();
            d2.setX(x+80); d2.setY(y+160);                                      d3.setX(x+80); d3.setY(y-160);
            d4 = d2.getLeft();                  d5 = d2.getRight();             d6 = d3.getLeft();                      d7 = d3.getRight();
            d4.setX(x+160); d4.setY(y+240);     d5.setX(x+160); d5.setY(y+80);  d6.setX(x+160); d6.setY(y-80);          d7.setX(x+160); d7.setY(y-240);
        } else if (cantidad == 8){ 
            d1 = this.getRoot();
            d1.setX(x); d1.setY(y);
            d2 = d1.getLeft();                                                  d3 = d1.getRight();
            d2.setX(x+80); d2.setY(y+160);                                      d3.setX(x+80); d3.setY(y-160);
            d4 = d2.getLeft();                  d5 = d2.getRight();             d6 = d3.getLeft();                      d7 = d3.getRight();
            d4.setX(x+160); d4.setY(y+240);     d5.setX(x+160); d5.setY(y+80);  d6.setX(x+160); d6.setY(y-80);          d7.setX(x+160); d7.setY(y-240);
            d8 = d4.getLeft();                 
            d8.setX(x+240); d8.setY(y+285);
        } else if (cantidad == 9){
            d1 = this.getRoot();
            d1.setX(x); d1.setY(y);
            d2 = d1.getLeft();                                                                                                                                                      d3 = d1.getRight();
            d2.setX(x+80); d2.setY(y+160);                                                                                                                                          d3.setX(x+80); d3.setY(y-160);
            d4 = d2.getLeft();                  d5 = d2.getRight();                                                                                                                 d6 = d3.getLeft();                      d7 = d3.getRight();
            d4.setX(x+160); d4.setY(y+240);     d5.setX(x+160); d5.setY(y+80);                                                                                                      d6.setX(x+160); d6.setY(y-80);          d7.setX(x+160); d7.setY(y-240);
            d8 = d4.getLeft();                  d9 = d4.getRight();                
            d8.setX(x+240); d8.setY(y+285);     d9.setX(x+240); d9.setY(y+200);
        } else if (cantidad == 10){
            d1 = this.getRoot();
            d1.setX(x); d1.setY(y);
            d2 = d1.getLeft();                                                                                                                                                      d3 = d1.getRight();
        d2.setX(x+80); d2.setY(y+160);                                                                                                                                          d3.setX(x+80); d3.setY(y-160);
        d4 = d2.getLeft();                  d5 = d2.getRight();                                                                                                                 d6 = d3.getLeft();                      d7 = d3.getRight();
        d4.setX(x+160); d4.setY(y+240);     d5.setX(x+160); d5.setY(y+80);                                                                                                      d6.setX(x+160); d6.setY(y-80);          d7.setX(x+160); d7.setY(y-240);
        d8 = d4.getLeft();                  d9 = d4.getRight();                 d10 = d5.getLeft();                     
        d8.setX(x+240); d8.setY(y+285);     d9.setX(x+240); d9.setY(y+200);     d10.setX(x+240); d10.setY(y+120);
        } else if (cantidad == 11){
            d1 = this.getRoot();
        d1.setX(x); d1.setY(y);
        d2 = d1.getLeft();                                                                                                                                                      d3 = d1.getRight();
        d2.setX(x+80); d2.setY(y+160);                                                                                                                                          d3.setX(x+80); d3.setY(y-160);
        d4 = d2.getLeft();                  d5 = d2.getRight();                                                                                                                 d6 = d3.getLeft();                      d7 = d3.getRight();
        d4.setX(x+160); d4.setY(y+240);     d5.setX(x+160); d5.setY(y+80);                                                                                                      d6.setX(x+160); d6.setY(y-80);          d7.setX(x+160); d7.setY(y-240);
        d8 = d4.getLeft();                  d9 = d4.getRight();                 d10 = d5.getLeft();                     d11 = d5.getRight();                                    
        d8.setX(x+240); d8.setY(y+285);     d9.setX(x+240); d9.setY(y+200);     d10.setX(x+240); d10.setY(y+120);       d11.setX(x+240); d11.setY(y+40);
        } else if (cantidad == 12){
            d1 = this.getRoot();
        d1.setX(x); d1.setY(y);
        d2 = d1.getLeft();                                                                                                                                                      d3 = d1.getRight();
        d2.setX(x+80); d2.setY(y+160);                                                                                                                                          d3.setX(x+80); d3.setY(y-160);
        d4 = d2.getLeft();                  d5 = d2.getRight();                                                                                                                 d6 = d3.getLeft();                      d7 = d3.getRight();
        d4.setX(x+160); d4.setY(y+240);     d5.setX(x+160); d5.setY(y+80);                                                                                                      d6.setX(x+160); d6.setY(y-80);          d7.setX(x+160); d7.setY(y-240);
        d8 = d4.getLeft();                  d9 = d4.getRight();                 d10 = d5.getLeft();                     d11 = d5.getRight();                                    d12 = d6.getLeft();                     
        d8.setX(x+240); d8.setY(y+285);     d9.setX(x+240); d9.setY(y+200);     d10.setX(x+240); d10.setY(y+120);       d11.setX(x+240); d11.setY(y+40);                        d12.setX(x+240); d12.setY(y-40);
        } else if (cantidad == 13){
            d1 = this.getRoot();
        d1.setX(x); d1.setY(y);
        d2 = d1.getLeft();                                                                                                                                                      d3 = d1.getRight();
        d2.setX(x+80); d2.setY(y+160);                                                                                                                                          d3.setX(x+80); d3.setY(y-160);
        d4 = d2.getLeft();                  d5 = d2.getRight();                                                                                                                 d6 = d3.getLeft();                      d7 = d3.getRight();
        d4.setX(x+160); d4.setY(y+240);     d5.setX(x+160); d5.setY(y+80);                                                                                                      d6.setX(x+160); d6.setY(y-80);          d7.setX(x+160); d7.setY(y-240);
        d8 = d4.getLeft();                  d9 = d4.getRight();                 d10 = d5.getLeft();                     d11 = d5.getRight();                                    d12 = d6.getLeft();                     d13 = d6.getRight();                  
        d8.setX(x+240); d8.setY(y+285);     d9.setX(x+240); d9.setY(y+200);     d10.setX(x+240); d10.setY(y+120);       d11.setX(x+240); d11.setY(y+40);                        d12.setX(x+240); d12.setY(y-40);        d13.setX(x+240); d13.setY(y-165);
        } else if (cantidad == 14){
            d1 = this.getRoot();
        d1.setX(x); d1.setY(y);
        d2 = d1.getLeft();                                                                                                                                                      d3 = d1.getRight();
        d2.setX(x+80); d2.setY(y+160);                                                                                                                                          d3.setX(x+80); d3.setY(y-160);
        d4 = d2.getLeft();                  d5 = d2.getRight();                                                                                                                 d6 = d3.getLeft();                      d7 = d3.getRight();
        d4.setX(x+160); d4.setY(y+240);     d5.setX(x+160); d5.setY(y+80);                                                                                                      d6.setX(x+160); d6.setY(y-80);          d7.setX(x+160); d7.setY(y-240);
        d8 = d4.getLeft();                  d9 = d4.getRight();                 d10 = d5.getLeft();                     d11 = d5.getRight();                                    d12 = d6.getLeft();                     d13 = d6.getRight();                    d14 = d7.getLeft();                    
        d8.setX(x+240); d8.setY(y+285);     d9.setX(x+240); d9.setY(y+200);     d10.setX(x+240); d10.setY(y+120);       d11.setX(x+240); d11.setY(y+40);                        d12.setX(x+240); d12.setY(y-40);        d13.setX(x+240); d13.setY(y-165);       d14.setX(x+240); d14.setY(y-200);
        } else {
            d1 = this.getRoot();
        d1.setX(x); d1.setY(y);
        d2 = d1.getLeft();                                                                                                                                                      d3 = d1.getRight();
        d2.setX(x+80); d2.setY(y+160);                                                                                                                                          d3.setX(x+80); d3.setY(y-160);
        d4 = d2.getLeft();                  d5 = d2.getRight();                                                                                                                 d6 = d3.getLeft();                      d7 = d3.getRight();
        d4.setX(x+160); d4.setY(y+240);     d5.setX(x+160); d5.setY(y+80);                                                                                                      d6.setX(x+160); d6.setY(y-80);          d7.setX(x+160); d7.setY(y-240);
        d8 = d4.getLeft();                  d9 = d4.getRight();                 d10 = d5.getLeft();                     d11 = d5.getRight();                                    d12 = d6.getLeft();                     d13 = d6.getRight();                    d14 = d7.getLeft();                     d15 = d7.getRight();
        d8.setX(x+240); d8.setY(y+285);     d9.setX(x+240); d9.setY(y+200);     d10.setX(x+240); d10.setY(y+120);       d11.setX(x+240); d11.setY(y+40);                        d12.setX(x+240); d12.setY(y-40);        d13.setX(x+240); d13.setY(y-165);       d14.setX(x+240); d14.setY(y-200);       d15.setX(x+240); d15.setY(y-280);
        }
                    
        
        
    }
}
