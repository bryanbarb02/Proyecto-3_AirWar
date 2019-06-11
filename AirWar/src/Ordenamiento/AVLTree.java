package Ordenamiento;

import Juego.*;

/**
 * Representa un árbol AVL.
 *
 * @author Rubén Salas
 * @since 29/10/18
 * @version 1.2
 */
public class AVLTree {

    private Avion root;


    /**
     * Constructor de AVLTree.
     */
    public AVLTree(){
        this.root = null;
    }


    //Getters & Setters
    public Avion getRoot() {
        return root;
    }

    public void setRoot(Avion root) {
        this.root = root;
    }


    /**
     * Retorna la altura del dragon en el arbol.
     * @param dragon
     * @return altura
     */
    public int height(Avion dragon){
        if (dragon == null) {
            return 0;
        }
        return dragon.getHeight();
    }

    /**
     * Retorna el mayor.
     * @param a
     * @param b
     * @return
     */
    public int max(int a, int b){
        return (a > b) ? a : b;
    }

    /**
     * Genera una rotacion hacia la derecha.
     * @param y - Dragon
     * @return Dragon
     */
    public Avion rightRotate(Avion y){
        Avion x = y.getLeft();
        Avion z = x.getRight();

        //Produce la rotacion
        x.setRight(y);
        y.setLeft(z);

        //Actualiza la altura
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        //Retorna el nuevo root
        return x;

    }

    /**
     * Genera una rotacion a la izquierda.
     * @param x - Dragon
     * @return Dragon
     */
    public Avion leftRotate(Avion x) {
        Avion y = x.getRight();
        Avion z = y.getLeft();

        //Produce la rotacion
        y.setLeft(x);
        x.setRight(z);

        //Actualiza la altura
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        //Retorna el nuevo root
        return y;
    }

    /**
     * Obtiene el factor de balanceo del Dragon
     * @param dragon - Dragon por verificar
     * @return factor de balanceo
     */
    public int getBalance(Avion dragon) {
        if (dragon == null)
            return 0;

        return height(dragon.getLeft()) - height(dragon.getRight());
    }


    /**
     * Insertar un Dragon al arbol AVL.
     * @param dragon - root
     * @return dragon insertado
     */
    public Avion insert(Avion dragon){
        if (this.getRoot() == null){
            this.setRoot(dragon);
            return dragon;

        } else {
            return insertAux(this.getRoot(), dragon);
        }
    }

    /**
     * Auxiliar de insertar.
     * @param node
     * @param dragon
     * @return dragon insertado
     */
    public Avion insertAux(Avion node, Avion dragon) {

        int key = dragon.getAge();

        /* 1. Perform the normal BST insertion */
        if (node == null) {
            //System.out.println("Added: " + dragon.getName());
            return (dragon);

        }
        if (key < node.getAge())
            node.setLeft(insertAux(node.getLeft(), dragon));
        else if (key > node.getAge())
            node.setRight(insertAux(node.getRight(), dragon));
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor BNode */
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

	/* 3. Get the balance factor of this ancestor
            BNode to check whether this BNode became
            unbalanced */
        int balance = getBalance(node);

        // If this BNode becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.getLeft().getAge()) {
            return rightRotate(node);
        }

        // Caso Right Right
        if (balance < -1 && key > node.getRight().getAge()) {
            return leftRotate(node);
        }

        // Caso Left Right
        if (balance > 1 && key > node.getLeft().getAge()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.getRight().getAge()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        /* return the (unchanged) BNode pointer */
        return node;
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
            System.out.print(node.getAge() + " ");
            System.out.print("Coordenadas: (" + node.getX() + "," + node.getY() + ")  ");
            preOrderAux(node.getLeft());
            preOrderAux(node.getRight());
        }
    }
    
    /**
     * Genera las coordenadas del arbol
     */
    public void generateCoordsTree(){
        int x = 900;
        int y = 285;
        Avion d1;
        
        Dragon d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15; 
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
