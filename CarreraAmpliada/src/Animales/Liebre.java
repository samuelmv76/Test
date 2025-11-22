package Animales;

import Carrera.Tunel;
import Carrera.Viento;

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
	

	public Liebre(String nombre, int posicion, int velocidad, Tunel tunel, Viento viento) {
		super(nombre, posicion, velocidad, tunel, viento);
	}

	@Override
	public void run() {
		//acquire
		//relase
		
		
		int posicionaux = 0;
		try {
			//si el viento es true que se despierte
			int c=0;
			
			//avanza hacia el tunel  50 m
			while ( getPosicion() < 50 ) {
				viento.generarViento();//boolean t f
				
				if( getPosicion()%10==0 ) {//logica charco
					System.out.println(getNombre()+" piso un charco y se resbala");
					
					System.out.println(getNombre() + " No avanza por el charco, POSICION: " + posicionaux + " m");
					System.out.println("--------");
					
					Thread.sleep(5000);//pierde 5s por el charco
				
				} else {//logica para lo de dormir
					c++;
					if(c==4) {
						//duerme 10s y contador=0
						
					
						if(viento.isV()==true) {
							
						}
						
						c=0;
					} else {
						posicionaux+=getVelocidad();//5
						setPosicion(posicionaux);
						System.out.println(getNombre() + " avanza: " + posicionaux + " m");

						Thread.sleep(1000);
					}

				}
				
			}
			////////

			System.out.println(getNombre() + " ha llegado al túnel y espera su turno...");

			//espera a que el tunel este libre
			//carrera.acquire();//error
			
			
			tunel.entrar(getNombre());
			
			//recorre el tunel (50 a 150 m)
			while ( getPosicion() < 150) {
				
				if( getPosicion()%10==0 ) {
					System.out.println(getNombre()+" piso un charco y corrio mas durante un segundo");
					
					
					posicionaux+=5;//por el charco
					setPosicion(posicionaux);
					System.out.println(getNombre() + " dentro del túnel: " + posicionaux + " m");
					System.out.println("--------");

					
					
					Thread.sleep(1000);
				
				} else {
					posicionaux++;
					setPosicion(posicionaux);
					System.out.println(getNombre() + " dentro del túnel: " + posicionaux + " m");

					
					
					Thread.sleep(1000/getVelocidad());
				}

			}

			tunel.salir(getNombre());
			
			//while para llegar al final de la carrera 300m
			while ( getPosicion() < 300 ) {
				
				if( getPosicion()%10==0 ) {
					System.out.println(getNombre()+" piso un charco y corrio mas durante un segundo");
					
					
					posicionaux+=5;//por el charco
					setPosicion(posicionaux);
					System.out.println(getNombre() + " avanza: " + posicionaux + " m");
					System.out.println("--------");

					
					
					Thread.sleep(1000);
				
				} else {
					posicionaux++;
					setPosicion(posicionaux);
					System.out.println(getNombre() + " avanza: " + posicionaux + " m");

					
					
					Thread.sleep(1000/getVelocidad());
				}
				
			}
			System.out.println("Carrear terminada para: "+getNombre() );
			

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}//fin run



	
	}