/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrafoMapa;

import Juego.Ventana;

/**
 *
 * @author Bryan
 */
public class CrearGrafo {
    public ListaGrafo creadorGrafo = new ListaGrafo();
    
    public NodoGrafo newNodoGrafo(){
        NodoGrafo nodoGrafo = new NodoGrafo(GenerarX(), GenerarY(), GenerarTipo());
        return nodoGrafo;
    }
    
    public ListaGrafo newGrafo(){
        //Recibe la cantidad de dragones que habrán en la oleada
        int cantidad = 10;

        //Son aregados la cantidad de Dragones anteriormente dada a una lista enlazada.
        for (int i = 1; i <= cantidad; i++){
            //Crea un nuevo dragon con atributos aleatorios
            NodoGrafo nodoGrafo = newNodoGrafo();
            //Se le agregan las coordenadas para ser mostrado en pantalla
//            nodoGrafo.generateCoords(i);
            //Se agrega a la lista.
            creadorGrafo.add(nodoGrafo);
        }

        //Retorna la oleada
        return creadorGrafo;
    }
    
    private String GenerarTipo(){
            //Lista con las clases predefinidas para los Dragones
            String[] clases = {"aeropuerto", "portaaviones"};

            //Indice creado aleatoriamente
            int indice = (int) Math.floor(Math.random()*(1-0+1)+0);

            //Devuelve la clase accesada
            return clases[indice];
//        }
    }
    
    private int GenerarX(){
        return (int) Math.floor(Math.random()*(900-1+1)+1);
    }
    
    private int GenerarY(){
        return (int) Math.floor(Math.random()*(500-1+1)+1);
    }
}
