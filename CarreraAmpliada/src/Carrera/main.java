package Carrera;

import java.util.concurrent.Semaphore;

import Animales.Tortuga;

public class main {

	public static void main(String[] args) {
        //creamos un semaforo con 1 permiso solo 1 tortuga puede estar en el tunel
        Semaphore tunel = new Semaphore(1);

        Thread mbappe = new Thread(new Tortuga("Mbappe", tunel));
        //Thread t2 = new Thread(new Tortuga("Tortuga 2", tunel));
        //Thread t3 = new Thread(new Tortuga("Tortuga 3", tunel));

        mbappe.start();
        //t2.start();
        //t3.start();
        
	}

}
