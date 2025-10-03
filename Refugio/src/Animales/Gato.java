package Animales;

public class Gato extends Animal{

	public int longitudBigotes;
	
	
	public Gato(String nombre, int edad, int longitudBigotes) {
		super(nombre, edad);
		this.longitudBigotes = longitudBigotes;
	}

	
	public void maullar() {
		System.out.println("Miau Miau");
	}

	@Override
	public String toString() {
		return "Gato [longitudBigotes=" + longitudBigotes + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
}
