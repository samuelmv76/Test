package Carrera;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Semaphore semaphore = new Semaphore(3);//3 hilos pueden acceder simultaneamente
		
		semaphore.acquire(3);//adquiere 3 permisos del semaforo
		
		semaphore.release(3);//libera 3 permisos al semaforo
		
		
		/*
		 instanciar semaforo con los 3 hilos mbappe tortuga2 , tortuga 3.
		 hacer una regla para que cuando lleguen a 5 que se use el acquire y luego el release
		 */
		
		
		Tortuga mbappe = new Tortuga();
		Tortuga tortuga2 = new Tortuga();
		Tortuga tortuga3 = new Tortuga();
		
		mbappe.start();
		tortuga2.start();
		tortuga3.start();
		
		
		try {
			
			mbappe.join();
			tortuga2.join();
			tortuga3.join();
			System.out.println("Valor final del contador: " + mbappe.getMetros());
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
