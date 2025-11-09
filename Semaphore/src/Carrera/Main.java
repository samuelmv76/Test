package Carrera;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
        //creamos un semaforo con 1 permiso solo 1 tortuga puede estar en el tunel
        Semaphore tunel = new Semaphore(1);

        Thread t1 = new Thread(new Tortuga("Tortuga 1", tunel));
        Thread t2 = new Thread(new Tortuga("Tortuga 2", tunel));
        Thread t3 = new Thread(new Tortuga("Tortuga 3", tunel));

        t1.start();
        t2.start();
        t3.start();
    }
}