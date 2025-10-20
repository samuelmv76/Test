package Dto;

import java.util.Date;

public class AlumnoDto {
	
	private String codAlumno;
	private String nombreAlumno;
	private String apellidosAlumno;
	private char grupo;
	private int edad;
	
	public String getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	public String getApellidosAlumno() {
		return apellidosAlumno;
	}
	public void setApellidosAlumno(String apellidosAlumno) {
		this.apellidosAlumno = apellidosAlumno;
	}
	public char getGrupo() {
		return grupo;
	}
	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public AlumnoDto(String codAlumno, String nombreAlumno, String apellidosAlumno, char grupo, int edad) {
		super();
		this.codAlumno = codAlumno;
		this.nombreAlumno = nombreAlumno;
		this.apellidosAlumno = apellidosAlumno;
		this.grupo = grupo;
		this.edad = edad;
	}
	public AlumnoDto() {
		super();
	}
	@Override
	public String toString() {
		return "AlumnoEntidad [codAlumno=" + codAlumno + ", nombreAlumno=" + nombreAlumno + ", apellidosAlumno="
				+ apellidosAlumno + ", grupo=" + grupo + ", fechaNacimiento=" + edad + "]";
	}
	
	
}
