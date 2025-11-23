package Carrera;

import Animales.*;

public class main {
    public static void main(String[] args) {

    	Tunel tunel = new Tunel();
        Viento viento = new Viento();
        
        
        Tortuga tortuga = new Tortuga("Balde", 2, tunel); 
        
        Liebre liebre = new Liebre("Mbappe", 5, tunel, viento);
        
        Pajaro federico = new Pajaro("Federico", 3, tunel);

        viento.registrarLiebre(liebre); 

        viento.start();
        tortuga.start();
        liebre.start();
        federico.start();
        try {
            tortuga.join();
            liebre.join();
            federico.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Carrera.carreraTerminada = true;

        System.out.println("Carrera finalizada!");
    }
}