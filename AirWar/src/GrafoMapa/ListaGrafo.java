/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrafoMapa;

/**
 *
 * @author Bryan
 */
public class ListaGrafo {
    private NodoGrafo head;
    private int size;

    /**
     * Constructor de Lista.
     */
    public ListaGrafo(){
        this.head = null;
        this.size = 0;
    }

    //Getters & Setters

    public NodoGrafo getHead() {
        return head;
    }

    public void setHead(NodoGrafo head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public NodoGrafo getPosition(int pos){//Obtiene la posicion del dragon en la lista (como un index en un array)
        if(pos <0 && pos >=size){
            return null;
        }
        NodoGrafo temp = head;
        int i = 0;
        while(i < pos){
            temp = temp.getNext();
        }
        return temp;
    }
    public void setPosition(int pos, NodoGrafo dragon){//Asigna la posicion del dragon
        if(pos < 0 && pos >= size){
            System.out.println("No valido");
        }
        NodoGrafo temp = head;
        int i = 0;
        while(i < pos-1){
            this.head = head.getNext();
        }
        dragon.setNext(temp.getNext().getNext());
        temp.setNext(dragon);
    }


    /**
     * Consulta si la lista está vacía.
     * @return true si el primer Enemy (head), no apunta a otro Enemy.
     */
    public boolean itsEmpty(){
        return this.head == null;
    }

    /**
     * Agrega un nuevo Dragon al final de la lista.
     * @param newDragon - nuevo Dragon por ingresar en lista
     */
    public void add(NodoGrafo newDragon){
        if (this.itsEmpty()) { //Verifica que la lista esté vacia
            this.setHead(newDragon); //Agrega como head a newDragon
        }
        else { //Recorre la lista hasta llegar al ultimo Dragon
            NodoGrafo temp = this.getHead(); //Crea un Dragon temporal para referencia
            while(temp.getNext() != null){ //Recorre la lista hasta llegar al ultimo Dragon
                temp = temp.getNext();
            }
            temp.setNext(newDragon); //Agrega a newDragon al final de la lista
        }
        this.setSize(this.getSize()+1);
    }
    
}
