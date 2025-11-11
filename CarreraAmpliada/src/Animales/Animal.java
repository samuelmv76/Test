package Animales;
//clase padre
public class Animal{
	
	private String nombre;
	private int posicion;
	private int velocidad;
	
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
	public Animal(String nombre, int posicion, int velocidad) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.velocidad = velocidad;
	}
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
