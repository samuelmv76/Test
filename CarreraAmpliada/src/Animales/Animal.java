package Animales;

import Carrera.Liana;
import Carrera.Tunel;
import Carrera.Viento;
public class Animal extends Thread{
	
	private String nombre;
	private int posicion;//siempre 0 al empezar lo pongo desde el main
	private int velocidad;
	protected Tunel tunel;
	protected Viento viento;
	protected Liana liana;
	
    protected static volatile boolean carreraTerminada = false;
    protected static volatile String ganador = null;
	
    public Animal(String nombre, int velocidad, Tunel tunel, Viento viento) {
        this.nombre = nombre;
        this.posicion = 0; //posicion inicial siempre 0
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

		 public Animal(String nombre, int velocidad, Liana liana) {
		        this.nombre = nombre;
		        this.posicion = 0; //posicion inicial siempre 0
		        this.velocidad = velocidad;
		        this.liana = liana;
		    }


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
    protected void comprobarGanador() {
        if (posicion >= 300 && !carreraTerminada) {
            carreraTerminada = true;
            ganador = nombre;
            System.out.println("GANADOR: " + ganador);
        }
    }
	
	
}
