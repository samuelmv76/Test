package proyectoJavax;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Libreria {
	
	private ArrayList<Libro> ListaLibro;
	private String nombre;
	private String lugar;

	
	public Libreria() {
		super();
	}
	
	
	public Libreria(ArrayList<Libro> ListaLibro, String nombre, String lugar) {
		super();
		this.ListaLibro = ListaLibro;
		this.nombre = nombre;
		this.lugar = lugar;
	}
	
	@XmlElementWrapper
	@XmlElement(name = "libro")
	public ArrayList<Libro> getListaLibros(){
		return ListaLibro;
	}

	@XmlElement(name= "nombre")
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name= "lugar")
	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
}
