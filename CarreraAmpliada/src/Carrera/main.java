package Carrera;

import Carrera.Tunel;

import Animales.*;

public class main {

	public static void main(String[] args) {

		Tunel tunel = new Tunel();
		
		Viento viento = new Viento();
		Thread vientoThread = new Thread();
		
		
        Tortuga mbappe = new Tortuga("mbappe",0,2,tunel, viento);
        Liebre balde = new Liebre("balde",0,5,tunel, viento);
        
        Thread mbappeThread = new Thread(mbappe);
        Thread baldeThread = new Thread(balde);
        //Thread federicoThread = new Thread(new Pajaro("Federico", tunel));
        
        vientoThread.start();
        mbappeThread.start();
        baldeThread.start();
        //federicoThread.start();
        
        
	}

}