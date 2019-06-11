/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author Bryan
 */
public class Cronometro {
    int minutos=0, segundos=0;
    
    public void crono(){
        for(minutos=0; minutos<60; minutos++){
            for(segundos=0; segundos<60; segundos++){
                System.out.println(minutos + ":" + segundos);
                deleySegundos();
                
            }
        }
    }
    private static void deleySegundos(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }
    
    
}
