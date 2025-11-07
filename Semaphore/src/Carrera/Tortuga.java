package Carrera;
/*
Crear una clase Semaphore metodos: acquire(), release()
 
El ejercicio consiste en crear 3 tortugas que serán Hilos, 
las cuales tiene que avanzar 20 metros, 
a los 5 metros se encuentran por un tunel en
el que solo puede pasar una cada vez, 
y la siguiente en entrar tiene que esperar a que salga la siguiente para entrar.
*/
public class Tortuga extends Thread{
	
	private int metros=0;
    
	private final Semaphore semaphore /*= new Semaphore()*/;
	
	
	
	public int getMetros() {
		return metros;
	}
	public void setMetros(int metros) {
		this.metros = metros;
	}

	
	@Override
	public void run() {
		
		for (int i = 0; i < 20; i++) {
			
			this.metros++;
			
	        try {
	        	if(this.metros == 5) {
	        		//esperar cada hilo
	        		
	        	}
	        	
	        	System.out.println("Metros recorridos"+this.metros);
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            System.err.println("El hilo fue interrumpido.");
	            Thread.currentThread().interrupt();
	        }
		}
		
	}//fin run

}
