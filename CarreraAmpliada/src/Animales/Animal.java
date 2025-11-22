package Animales;

import Carrera.Tunel;
//clase padre
public class Animal implements Runnable{
	
	private String nombre;
	private int posicion;//siempre 0 al empezar
	private int velocidad;
	protected Tunel tunel;
	
	
	public Animal(String nombre, int posicion, int velocidad, Tunel tunel) {
		super();
		this.nombre = nombre;
		this.posicion = 0;
		this.velocidad = velocidad;
		this.tunel = tunel;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
