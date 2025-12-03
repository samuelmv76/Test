package Carrera;

import Animales.*;

public class main {
    public static void main(String[] args) {

    	Tunel tunel = new Tunel();
        Viento viento = new Viento();
        Liana liana = new Liana();
        
       // Tortuga tortuga = new Tortuga("Balde", 2, tunel); 
        
       // Liebre liebre = new Liebre("Mbappe", 5, tunel, viento);
        
        //Pajaro federico = new Pajaro("Federico", 3, tunel);
        
        //ampliacion clase
        Mono vini = new Mono("Vini",6,liana);
        Mono tchua = new Mono("Tchua",6,liana);
        Mono cama = new Mono("Cama",6,liana);

        //viento.registrarLiebre(liebre); 

        viento.start();
        //tortuga.start();
        //liebre.start();
        //federico.start();
        
        //clase
        vini.start();
        tchua.start();
        cama.start();
        
        try {
            //tortuga.join();
            //liebre.join();
            //federico.join();
 
            //clase
            vini.join();
            tchua.join();
            cama.join();
            
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Carrera.carreraTerminada = true;

        System.out.println("Carrera finalizada!");
    }
}