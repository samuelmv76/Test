package Animales;

import java.util.concurrent.Semaphore;

public class Tortuga extends Animal implements Runnable{

	public Tortuga(String string, Semaphore tunel) {
		// TODO Auto-generated constructor stub
		
	}
	

	public Tortuga(String nombre, int posicion, int velocidad, Semaphore tunel) {
		super(nombre, posicion, velocidad, tunel);
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
			//avanza hacia el tunel  50 m
			//int i = getPosicion();//0
			/*
			for (i = 1; i <= 50/getVelocidad(); i++) {
				System.out.println(getNombre() + " avanza " + i*getVelocidad() + " m");
				Thread.sleep(1000);//2m/s por segundo
			}
			*/
			for (int p = getPosicion(); p <= 50/getVelocidad(); p++) {
				System.out.println(getNombre() +" avanza "+ p*getVelocidad() + " m");
				Thread.sleep(1000);//2m/s por segundo
				setPosicion(p);
			}

			System.out.println(getNombre() + " ha llegado al túnel y espera su turno...");

			//espera a que el tunel este libre
			tunel.acquire();//error

			System.out.println(getNombre() + " entra al túnel");

			//recorre el tunel (50 a 150 m)
			for (int p = getPosicion(); p <= 150/getVelocidad(); p++) {
				
				System.out.println(getNombre() + " dentro del túnel: " + p*getVelocidad() + " m");
				
				if(p%10==0) {
					//que si la i es divisible por 10 la velocidad sea 5 es decir getVelocidad()+3 solo 1 segundo
					System.out.println("Charca");
					p += 3;
					System.out.println("Posicion despues de la charca: "+p);
				}
				
				Thread.sleep(1000);
			}

			System.out.println(getNombre() + " ha salido del túnel");

			//libera el tunel
			tunel.release();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
