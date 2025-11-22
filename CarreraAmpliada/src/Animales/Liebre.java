package Animales;

import Carrera.Tunel;

public class Liebre extends Animal implements Runnable{

	@Override
	public int getPosicion() {
		// TODO Auto-generated method stub
		return super.getPosicion();
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
	

	public Liebre(String nombre, int posicion, int velocidad, Tunel tunel) {
		super(nombre, posicion, velocidad, tunel);
	}

	@Override
	public void run() {
		//acquire
		//relase
				
				
		int posicionaux = 0;
		try {
			//avanza hacia el tunel  50 m
			while ( getPosicion() < 50 ) {
				posicionaux++;
				setPosicion(posicionaux);
				System.out.println(getNombre() +" avanza "+ posicionaux + " m");
								
				Thread.sleep(1000/getVelocidad());// cada 0,5s +1 de posicion es igual cada 1s +2
			}
						
	
			System.out.println(getNombre() + " ha llegado al túnel y espera su turno...");
	
			//espera a que el tunel este libre
			//carrera.acquire();//error
						
						
			tunel.entrar(getNombre());
						
			//recorre el tunel (50 a 150 m)
			while ( getPosicion() < 150) {
							
				posicionaux++;
				setPosicion(posicionaux);
				System.out.println(getNombre() + " dentro del túnel: " + posicionaux + " m");
		
								
				Thread.sleep(1000/getVelocidad());
			}
	
			tunel.salir(getNombre());
						
			//while para llegar al final de la carrera 300m
			while ( getPosicion() < 300 ) {
							
				posicionaux++;
				setPosicion(posicionaux);
				System.out.println(getNombre() +" avanza "+ posicionaux + " m");
								
				Thread.sleep(1000/getVelocidad());// cada 0,5s +1 de posicion es igual cada 1s +2
							}
				System.out.println("Carrear terminada para: "+getNombre() );
							
		
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		
		}//fin run
	
	}