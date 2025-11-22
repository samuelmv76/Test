package Animales;

import java.util.concurrent.Semaphore;

import Carrera.Tunel;

public class Pajaro extends Animal implements Runnable{

	public Pajaro(String nombre, int posicion, int velocidad, Tunel tunel) {
		super(nombre, posicion, velocidad, tunel);
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
		// TODO Auto-generated method stub
		
	}

	


}
