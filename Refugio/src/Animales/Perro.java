package Animales;

public class Perro extends Animal{

	public String raza;

	public Perro(String nombre, int edad, String raza) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}
	
	
	public void ladrar() {
		System.out.println("Wof Wof");
	}

	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	

}
