package Ordenamiento;


import Juego.*;
import graf.Vertice;

/**
 * Creador de Oleadas
 *
 * @author Bryan
 */
public class CreadorDeOleadas {

    private Lista oleada = new Lista();//Lista donde se guardarán los Dragones (Oleada)
    private boolean comandanteExists = false; //Flag para verificar si ya existe un comandante en la oleada
    public Vertice[] v;

    public Avion newDragon(){
        Avion avion = new Avion(generateName(), generateSpeed(), generateAge(), generateResistence(), generateClass());
        return avion;
    }
    /**
     * Crea una Oleada de Dragones
     * @return - lista desordenada de dragones (Oleada)
     */
    public Lista newOleada(){
        int cantidad = Ventana.getCantDragones(); //Recibe la cantidad de dragones que habrán en la oleada
        for (int i = 1; i <= cantidad; i++){ //Son aregados la cantidad de Dragones anteriormente dada a una lista enlazada.
            Avion avion = newDragon();  //Crea un nuevo dragon con atributos aleatorios
            avion.generateCoords(v); //Se le agregan las coordenadas para ser mostrado en pantalla 
            oleada.add(avion); //Se agrega a la lista.
        }
        return oleada; //Retorna la oleada
    }

    /**
     * Recreará la oleada, luego de ser ordenada, con sus respectivas coordenadas
     * @param oleada con coordenadas sin ordenar
     * @return oleada con coordenadas correctas
     */
    public Lista recreateOleada(Lista oleada) {
        Lista oleadaRecreada = new Lista(); //Crea una nueva lista
        //Crea un temporal
        Avion temp = oleada.getHead();
//        int i = 1;
//        //Recorre la lista
//        while (temp != null) {
//            System.out.println("Recreate");
//            //Genera las nuevas coordenadas para su nueva reacomodación
//            temp.generateCoords(i);
//            //oleadaRecreada.add(temp);
//            i+=1;
//            temp = temp.getNext();
//        }
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
        String name = names[indice]; //Nombre tomado de la lista con el indice previamete definido
        Avion temp = oleada.getHead(); //Crea un temporal del Head de la lista (Oleada)
        while(temp != null){ //Recorre la lista para verificar que no se repita el nombre obtenido  
            if (temp.getName().equals(name)){ //Cuando ya se tiene un Dragon con ese nombre                
                doubled = true; //El Flag cambia a true
            }            
            temp = temp.getNext(); //Pasa al siguiente Dragon
        }
        
        if (doubled){ //Si está repetido            
            return generateName(); //Se vuelve a llamar la función para que se accese un nuevo nombre
        }
        
        else { //Si no está repetido            
            return name;//Devuelve el nombre accesado
        }
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
//        //Si no hay un Comandante aun
//        if (!comandanteExists){
//            this.comandanteExists = true;
//            return "Comandante";
//        }
//        //No se puede repetir el comandante
//        else {
            //Lista con las clases predefinidas para los Dragones
            String[] clases = {"Capitan", "Infante"};

            //Indice creado aleatoriamente
            int indice = (int) Math.floor(Math.random()*(1-0+1)+0);

            //Devuelve la clase accesada
            return clases[indice];
//        }
    }
    
    public void setVerticesCoord(Vertice[] vertices) {
        this.v = vertices;
    }
    
}
