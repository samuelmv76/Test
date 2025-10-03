package Animales;

public class Animal {
	
	public String nombre;
	public int edad;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Animal(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	public void mostrarDatos() {
		System.out.println(this.toString());
	}

	
}
