package proyectoInicioHibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor {
	
	@Id
	@Column(name="cod_profesor")
	private String cod_profesor;
	@Column(name="nombre_profesor")
	private String nombre_profesor;
	@Column(name="ciudad")
	private String ciudad;
	
	
	
	public String getCod_profesor() {
		return cod_profesor;
	}
	public void setCod_profesor(String cod_profesor) {
		this.cod_profesor = cod_profesor;
	}
	public String getNombre_profesor() {
		return nombre_profesor;
	}
	public void setNombre_profesor(String nombre_profesor) {
		this.nombre_profesor = nombre_profesor;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profesor(String cod_profesor, String nombre_profesor, String ciudad) {
		super();
		this.cod_profesor = cod_profesor;
		this.nombre_profesor = nombre_profesor;
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Profesor [cod_profesor=" + cod_profesor + ", nombre_profesor=" + nombre_profesor + ", ciudad=" + ciudad
				+ "]";
	}
	
}
