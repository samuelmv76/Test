package Carrera;

import java.util.concurrent.Semaphore;

import Animales.*;

public class main {

	public static void main(String[] args) {
        //creamos un semaforo con 1 permiso solo 1 tortuga puede estar en el tunel
        Semaphore tunel = new Semaphore(1);

        Thread mbappe = new Thread(new Tortuga("Mbappe", tunel));
        Thread balde = new Thread(new Liebre("Balde", tunel));
        Thread federico = new Thread(new Pajaro("Federico", tunel));

        mbappe.start();
        balde.start();
        federico.start();
        
        
	}

}
