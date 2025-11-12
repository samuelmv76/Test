package Animales;

import java.util.concurrent.Semaphore;

public class Tortuga extends Animal implements Runnable{

	public Tortuga(String string, Semaphore tunel) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Semaphore getTunel() {
		// TODO Auto-generated method stub
		return super.getTunel();
	}

	@Override
	public void setTunel(Semaphore tunel) {
		// TODO Auto-generated method stub
		super.setTunel(tunel);
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		super.setNombre(nombre);
	}

	@Override
	public int getPosicion() {
		// TODO Auto-generated method stub
		return super.getPosicion();
	}

	@Override
	public void setPosicion(int posicion) {
		// TODO Auto-generated method stub
		super.setPosicion(posicion);
	}

	@Override
	public int getVelocidad() {
		// TODO Auto-generated method stub
		return super.getVelocidad();
	}

	@Override
	public void setVelocidad(int velocidad) {
		// TODO Auto-generated method stub
		super.setVelocidad(velocidad);
	}

	@Override
	public void run() {
		//acquire
		//relase
		
		try {
			//avanza hacia el tunel
			for (int i = 1; i <= 50; i++) {
				System.out.println(getNombre() + " avanza " + i + " m");
				Thread.sleep(500);//2m/s por segundo
			}

			System.out.println(getNombre() + " ha llegado al túnel y espera su turno...");

			//espera a que el tunel este libre
			tunel.acquire();
			System.out.println(getNombre() + " entra al túnel");

			//recorre el tunel (10 m)
			for (int i = 1; i <= 10; i++) {
				System.out.println(getNombre() + " dentro del túnel: " + i + " m");
				Thread.sleep(1000);
			}

			System.out.println(getNombre() + " ha salido del túnel 🏁");

			//libera el tunel
			tunel.release();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
