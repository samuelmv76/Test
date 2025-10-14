package ficherosBinarios;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	@Override
	public String toString() {
		return "Cliente [gnombre=" + gnombre + ", edad=" + edad + ", peso=" + peso + "]";
	}
	private String gnombre;
	private int edad;
	private double peso;
	public Cliente(String gnombre, int edad, double peso) {
		super();
		this.gnombre = gnombre;
		this.edad = edad;
		this.peso = peso;
	}
	public String getGnombre() {
		return gnombre;
	}
	public void setGnombre(String gnombre) {
		this.gnombre = gnombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}

}
