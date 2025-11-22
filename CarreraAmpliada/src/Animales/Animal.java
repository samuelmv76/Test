package Animales;

import java.util.Random;

import Carrera.Tunel;
import Carrera.Viento;
//clase padre
public class Animal implements Runnable{
	
	private String nombre;
	private int posicion;//siempre 0 al empezar
	private int velocidad;
	protected Tunel tunel;
	protected Viento viento;
	
	
	public Animal(String nombre, int posicion, int velocidad, Tunel tunel,Viento viento) {
		super();
		this.nombre = nombre;
		this.posicion = 0;
		this.velocidad = velocidad;
		this.tunel = tunel;
		this.viento = viento;
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
