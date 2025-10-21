package Servicios;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Dao.AlumnoDaoImplementacion;
import Dto.AlumnoDto;
import Entidad.AlumnoEntidad;

public class AlumnoService {

	private static AlumnoService instancia;
	private AlumnoDaoImplementacion alumnoDao;
	
	private AlumnoService(AlumnoDaoImplementacion alumnoDao) {
		this.alumnoDao = alumnoDao;
	}
	
	public AlumnoService(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		//this.alumnoDao = AlumnoDaoImplementacion.getInstancia(dataSource);
	}

	public static AlumnoService getInstancia(AlumnoDaoImplementacion alumnoDao) {
		if (instancia == null) {
			instancia = new AlumnoService(alumnoDao);
		}
		return instancia;
	}
	public static AlumnoService getInstancia(DataSource dataSource) {
		if (instancia == null) 
			instancia = new AlumnoService(dataSource);
		
		return instancia;
	}
	
	public void crearAlumno(AlumnoDto alumnoDto) {
		AlumnoEntidad entidad = mapearDtoEntidad(alumnoDto);
		entidad.setFechaNacimiento(convertirEdadFecha(alumnoDto.getEdad()));
		alumnoDao.crearAlumno(entidad);
	}
	
	
	//
	
    public AlumnoDto obtenerAlumnoPorId(String id) {
        
    	AlumnoEntidad alumno = alumnoDao.obtenerAlumnoPorId(id);
    	AlumnoDto alumnoDto = mapearEntidadDto(alumno);
		if (alumnoDto!=null)
			return alumnoDto;
		return null;
		
    }

    public List<AlumnoEntidad> obtenerTodosLosAlumno() {
    	List <AlumnoEntidad> alumnos = alumnoDao.obtenerTodosLosAlumno();
		List <AlumnoDto> alumnosDto = new ArrayList<AlumnoDto>();
		for (AlumnoEntidad alumno : alumnos) {
			alumnosDto.add(mapearEntidadDto(alumno));
		}
    	return alumnos;
	}

    public void actualizarAlumno(AlumnoDto alumnoDto) {
		AlumnoEntidad alumno= alumnoDao.obtenerAlumnoPorId(alumnoDto.getCodAlumno());
		if (alumno != null) {
			alumno.setNombreAlumno(alumnoDto.getNombreAlumno());
			alumno.setApellidosAlumno(alumnoDto.getApellidosAlumno());
			alumno.setGrupo(alumnoDto.getGrupo());
			alumno.setFechaNacimiento(convertirEdadFecha(alumnoDto.getEdad()));
			alumnoDao.actualizarAlumno(alumno);
		}
    }

    public void eliminarAlumno(String id) {
        if(alumnoDao.obtenerAlumnoPorId(id)!=null) {
        	alumnoDao.eliminarAlumno(id);
        }
    }//no se si este esta terminado bien
	
    
    //
	private AlumnoEntidad mapearDtoEntidad(AlumnoDto dto) {
		AlumnoEntidad entidad = new AlumnoEntidad();
		entidad.setCodAlumno(dto.getCodAlumno());
		entidad.setNombreAlumno(dto.getNombreAlumno());
		entidad.setApellidosAlumno(dto.getApellidosAlumno());
		entidad.setGrupo(dto.getGrupo());
		// Convertir edad a fechaNacimiento si es necesario
		return entidad;
	}
	private AlumnoDto mapearEntidadDto(AlumnoEntidad alumno) {
		AlumnoDto dto = new AlumnoDto();
		dto.setCodAlumno(alumno.getCodAlumno());
		dto.setNombreAlumno(alumno.getNombreAlumno());
		dto.setApellidosAlumno(alumno.getApellidosAlumno());
		dto.setEdad(calcularEdad(alumno.getFechaNacimiento()));
		dto.setGrupo(alumno.getGrupo());
		
		return dto;
	}
	private int calcularEdad(java.util.Date date) {
		LocalDate nacimiento = new java.util.Date(date.getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		return Period.between(nacimiento, LocalDate.now()).getYears();
	}
	private Date convertirEdadFecha(int edad) {
		LocalDate nacimiento = LocalDate.now().minusYears(edad);
		return (Date) Date.from(nacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());	
	}	
	
}
