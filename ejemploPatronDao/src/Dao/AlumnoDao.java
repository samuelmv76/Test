package Dao;

import java.util.List;

import Entidad.AlumnoEntidad;

public interface AlumnoDao {
	
	public void crarAlumno(AlumnoEntidad alumno);
	public AlumnoEntidad obtenerAlumnoPorId(String id);
	public List<AlumnoEntidad> obtenerTodosLosAlumno();
	public void actualizarAlumno(AlumnoEntidad alumno);
	public void eliminarAlumno(String id);
	
	
}
