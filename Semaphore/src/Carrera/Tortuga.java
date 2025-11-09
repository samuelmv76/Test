package Carrera;
import java.util.concurrent.Semaphore;

class Tortuga implements Runnable {
	private String nombre;
	private Semaphore tunel;//

	public Tortuga(String nombre, Semaphore tunel) {
		this.nombre = nombre;
		this.tunel = tunel;
	}
	@Override
	public void run() {
		try {
			// avanza hacia el tunel
			for (int i = 1; i <= 20; i++) {
				System.out.println(nombre + " avanza " + i + " m");
				Thread.sleep(1000); // 1 m por segundo
			}

			System.out.println(nombre + " ha llegado al túnel y espera su turno...");

			//espera a que el tunel este libre
			tunel.acquire();
			System.out.println(nombre + " entra al túnel");

			//recorre el tunel (10 m)
			for (int i = 1; i <= 10; i++) {
				System.out.println(nombre + " dentro del túnel: " + i + " m");
				Thread.sleep(1000);
			}

			System.out.println(nombre + " ha salido del túnel 🏁");

			//libera el tunel
			tunel.release();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}