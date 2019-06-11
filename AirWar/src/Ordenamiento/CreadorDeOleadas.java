package Ordenamiento;

import Juego.*;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;

/**
 * Creador de Oleadas
 *
 * @author Rubén Salas
 * @since 18/10/18
 * @version 1.4
 */
public class CreadorDeOleadas {

    //Lista donde se guardarán los Dragones (Oleada)
    private Lista oleada = new Lista();

    //Flag para verificar si ya existe un comandante en la oleada
    private boolean comandanteExists = false;

    public Avion newDragon(){
        //Cada dragon es creado con atributos aleatorios por sus respectivos métodos.
        Avion dragon = new Avion(generateName(), generateSpeed(), generateAge(), generateResistence(), generateClass());
        return dragon;
    }

    /**
     * Crea una Oleada de Dragones
     * @return - lista desordenada de dragones (Oleada)
     */
    public Lista newOleada(){
        //Recibe la cantidad de dragones que habrán en la oleada
        int cantidad = Ventana.getCantDragones();

        //Son aregados la cantidad de Dragones anteriormente dada a una lista enlazada.
        for (int i = 1; i <= cantidad; i++){
            //Crea un nuevo dragon con atributos aleatorios
            Avion dragon = newDragon();
            //Se le agregan las coordenadas para ser mostrado en pantalla
            dragon.generateCoords(i);
            //Se le agrega un padre, menos al primero
            if(i!=1){
                dragon.setPadre(generateFamily(dragon));
            }
            //Se agrega a la lista.
            oleada.add(dragon);
        }

        //Retorna la oleada
        return oleada;
    }

    /**
     * Recreará la oleada, luego de ser ordenada, con sus respectivas coordenadas
     * @param oleada con coordenadas sin ordenar
     * @return oleada con coordenadas correctas
     */
    public Lista recreateOleada(Lista oleada) {
        
        //Crea una nueva lista
        Lista oleadaRecreada = new Lista();
        //Crea un temporal
        Avion temp = oleada.getHead();
        int i = 1;
        //Recorre la lista
        while (temp != null) {
            System.out.println("Recreate");
            //Genera las nuevas coordenadas para su nueva reacomodación
            temp.generateCoords(i);
            //oleadaRecreada.add(temp);
            i+=1;
            temp = temp.getNext();
        }
        return oleadaRecreada;
    }

    /**
     * Genera un nombre al Dragon aleatoriamente sin repetir en la misma Oleada.
     * @return - nombre
     */
    private String generateName(){
        //Flag para revisar si se repite
        boolean doubled = false;

        //Lista con nombres predefinidos para los Dragones (30)
        String[] names = {"Andres", "Antonio", "Bruno", "Bryan", "Carlos", "Cesar", "Daniel", "David", "Dennis", "Diego",
                "Emilio", "Esteban", "Fabian", "Felipe", "Francisco", "Gabriel", "Gustavo", "Isaac", "Jose", "Lucas",
                "Luis", "Manuel", "Marco", "Mario", "Nicolas", "Oscar", "Pablo", "Ruben", "Santiago", "Sergio"};

        //Indice creado aleatoriamente
        int indice = (int) Math.floor(Math.random()*(29-0+1)+0);

        //Nombre tomado de la lista con el indice previamete definido
        String name = names[indice];

        //Crea un temporal del Head de la lista (Oleada)
        Avion temp = oleada.getHead();

        //Recorre la lista para verificar que no se repita el nombre obtenido
        while(temp != null){
            //Cuando ya se tiene un Dragon con ese nombre
            if (temp.getName().equals(name)){
                //El Flag cambia a true
                doubled = true;
            }
            //Pasa al siguiente Dragon
            temp = temp.getNext();
        }

        //Si está repetido
        if (doubled){
            //Se vuelve a llamar la función para que se accese un nuevo nombre
            return generateName();
        }
        //Si no está repetido
        else {
            //Devuelve el nombre accesado
            return name;
        }
        //return name;
    }

    /**
     * Genera la velocidad de recarga de fuego del Dragon.
     * @return - velocidad
     */
    private int generateSpeed(){
        //Se genera la velocidad aleatoriamente de 1 a 100
        return (int) Math.floor(Math.random()*(100-1+1)+1);
    }

    /**
     * Genera la edad del Dragon.
     * @return - edad
     */
    private int generateAge(){
        //Flag para revisar si se repite
        boolean doubled = false;

        //Se genera la edad aleatoriamente de 1 a 1000
        int age = (int) Math.floor(Math.random()*(1000-1+1)+1);

        //Crea un temporal del Head de la lista (Oleada)
        Avion temp = oleada.getHead();

        //Recorre la lista para verificar que no se repita la edad obtenida
        while(temp != null){
            //Cuando ya se tiene un Dragon con esa edad
            if (temp.getAge() == age){
                //El Flag cambia a true
                doubled = true;
            }
            //Pasa al siguiente Dragon
            temp = temp.getNext();
        }

        //Si está repetido
        if (doubled){
            //Se vuelve a llamar la función para que se accese una nueva edad
            return generateAge();
        }
        //Si no está repetido
        else {
            //Devuelve la edad accesada
            return age;
        }
    }

    /**
     * Genera la resistencia del Dragon.
     * @return - resistencia
     */
    private int generateResistence(){
        //Se genera la resistencia aleatoriamente de 1 a 3
        return (int) Math.floor(Math.random()*(3-1+1)+1);
    }

    /**
     * Genera la clase a la que pertenecerá el Dragon.
     * @return - clase
     */
    private String generateClass(){
        //Si no hay un Comandante aun
        if (!comandanteExists){
            this.comandanteExists = true;
            return "Comandante";
        }
        //No se puede repetir el comandante
        else {
            //Lista con las clases predefinidas para los Dragones
            String[] clases = {"Capitan", "Infante"};

            //Indice creado aleatoriamente
            int indice = (int) Math.floor(Math.random()*(1-0+1)+0);

            //Devuelve la clase accesada
            return clases[indice];
        }
    }

    /**
     * Genera la dependencia familiar, define los padres de cada Dragon
     */
    private Avion generateFamily(Avion dragon){
        //Se crea un temporal de la oleada
        Avion temp = oleada.getHead();
        //Se recorre la oleada buscando un padre
        while(temp != null){
            //Si no tiene hijo1 se pone como padre
            if(temp.getHijo1() == null){
                temp.setHijo1(dragon);
                return temp;
            }
            //Si no tiene hijo2 se pone como padre
            else if (temp.getHijo2() == null) {
                temp.setHijo2(dragon);
                return temp;
            }
            //Se pasa al siguiente dragon
            else{
                temp = temp.getNext();
            }
        }
        return null;
    }

    /**
     * Vuelve una lista a un arbol AVL.
     * @param oleada - lista
     * @return arbol AVL
     */
    public AVLTree turnToAVLTree(Lista oleada){
        AVLTree tree = new AVLTree();
        Avion temp = oleada.getHead();
        //Recorre la lista
        while (temp != null){
            //Va insertando los elementos en el arbol
            tree.setRoot(tree.insert(temp));
            temp = temp.getNext();
        }
        //Se generan las coordenadas
        tree.generateCoordsTree();
        //Retorna el arbol
        return tree;
    }

    /**
     * Vuelve una lista a aun arbol Binario.
     * @param oleada - lista
     * @return arbol Binario
     */
    public BinaryTree turnToBinaryTree(Lista oleada) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(oleada.getHead());
        Avion temp = oleada.getHead();
        while(temp != null){
            temp.setLeft(temp.getHijo1());
            temp.setRight(temp.getHijo2());
            temp = temp.getNext();
        }
        //Recibe la cantidad de dragones que habrán en la oleada
        int cantidad = Ventana.getCantDragones();
        //Se generan las coordenadas
        binaryTree.generateCoordsTree(cantidad);
        //Retorna el arbol
        return binaryTree;
    }
    
    /**
     * Convierte una oleada a un archivo XML
     * @param oleada - lista
     * @return String xml
     */
    public String oleadaToXML(Avion dragon){
        String ubicacion = "./oleada.xml";
        try{
            FileOutputStream fos = new FileOutputStream(new File(ubicacion));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(dragon);
            encoder.close();
            fos.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return ubicacion;
    }
    
    /**
     * Convierte un archivo xml a una oleada.
     * @param ubicacion - String
     * @return oleada
     */
    public Avion XMLToOleada(String ubicacion){
        
    	Avion dragon = null;
    	
        try{
            FileInputStream fis = new FileInputStream(new File(ubicacion));
            XMLDecoder decoder = new XMLDecoder(fis);
            dragon = (Avion) decoder.readObject();
            decoder.close();
            fis.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return dragon;
    }
    
    /**
     * Acomoda la oleada por el algoritmo de Selection Sort.
     * @param lista
     * @return oleada ordenada
     */
    public Lista selectionSort(Lista lista){
        //Lista Lord = new Lista();
        for(int i = 0; i < lista.getSize() - 1; i++) {
            int index = i;
            for(int j = i + 1; j < lista.getSize(); j++){
                if(lista.getPosition(i).getAge() < lista.getPosition(index).getAge()){
                    index = j;
                }

            }
            Avion temp = lista.getPosition(index);
            lista.setPosition(index, lista.getPosition(index));
            lista.setPosition(i, temp);
        }
        return lista;
    }
    
    
    
    /**
     * Acomoda la oleada por el algoritmo de insertion sort.
     * @param head
     * @return oleada ordenada
     */
    public static Lista insertionSort(Lista lista){
        Avion temp;
        for(int i = 1; i < lista.getSize(); i++){
            for(int j =i; j>0; j--){
                if(lista.getPosition(j-1).getRechargeSpeed() > lista.getPosition(j).getRechargeSpeed()){
                    temp = lista.getPosition(j);
                    lista.setPosition(j, lista.getPosition(j-1));
                    lista.setPosition(j-1,temp);


                }
            }
        }
        return lista;

    }
    
    /**
     * Ordena la lista por el algoritmo de quickSort.
     * @param lista
     * @return oleada ordenada
     */
    public void quickSort(Lista lista) {
        if (lista == null || lista.getSize() <= 1){
            return;
        }
        quick(lista, 0, lista.getSize());
    }

    public int findKthLargest(Lista lista, int k) {
        assert(1 <= k && k <= lista.getSize());
        int targetIdx = lista.getSize() - k;
        int start = 0;
        int end = lista.getSize();
        while (start + 1 < end) {
            int i = partition(lista, start, end);
            if (i == targetIdx) {
                return lista.getPosition(i).getAge();
            } else if (i < targetIdx) {
                start = i + 1;
            } else {
                end = i;
            }
        }
        return lista.getPosition(start).getAge();
    }

    private void quick(Lista lista, int start, int end){
        if (start + 1 >= end){
            return;
        }
        int mid = partition(lista, start, end);
        quick(lista, start, mid);
        quick(lista, mid + 1, end);
    }

    private int partition(Lista lista, int start, int end){
        if (start + 1 >= end){
            return start;
        }

        int pivot = lista.getPosition(start).getAge();
        int i = start;
        for (int j = start + 1; j < end; ++j) {
            if(lista.getPosition(j).getAge() <= pivot){
                i += 1;
                swap(lista, i, j);
            }
        }
        swap(lista, start, i);
        return i;
    }

    private void swap(Lista lista, int x, int y){
        Avion temp = lista.getPosition(x);
        lista.setPosition(x, lista.getPosition(y));
        lista.setPosition(y, temp);
    }

}
