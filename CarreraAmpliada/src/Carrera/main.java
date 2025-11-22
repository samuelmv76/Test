package Carrera;

import Carrera.Tunel;

import Animales.*;

public class main {

	public static void main(String[] args) {

		Tunel tunel = new Tunel();
		
        Tortuga mbappe = new Tortuga("mbappe",0,2,tunel);
        
        Thread mbappeThread = new Thread(mbappe);
        //Thread baldeThread = new Thread(new Liebre("Balde", tunel));
        //Thread federicoThread = new Thread(new Pajaro("Federico", tunel));

        mbappeThread.start();
        //baldeThread.start();
        //federicoThread.start();
        
        
	}

}