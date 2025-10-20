package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import Entidad.AlumnoEntidad;

public class AlumnoDaoImplementacion implements AlumnoDao {

    private static AlumnoDaoImplementacion instancia;
    private DataSource dataSource;

    private AlumnoDaoImplementacion(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static AlumnoDaoImplementacion getInstancia(DataSource dataSource) {
        if (instancia == null) {
            instancia = new AlumnoDaoImplementacion(dataSource);
        }
        return instancia;
    }

    public void crearAlumno(AlumnoEntidad alumno) {
        String sql = "INSERT INTO alumno (codAlumno, nombreAlumno, apellidoAlumno, fechaNacimiento, grupo) VALUES (?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, alumno.getCodAlumno());
            statement.setString(2, alumno.getNombreAlumno());
            statement.setString(3, alumno.getApellidosAlumno());
            statement.setDate(4, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
            statement.setString(5, String.valueOf(alumno.getGrupo()));

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AlumnoEntidad obtenerAlumnoPorId(String id) {
        String sql = "SELECT * FROM alumno WHERE codAlumno = ?";
        AlumnoEntidad alumno = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    alumno = new AlumnoEntidad();
                    alumno.setCodAlumno(rs.getString("codAlumno"));
                    alumno.setNombreAlumno(rs.getString("nombreAlumno"));
                    alumno.setApellidosAlumno(rs.getString("apellidoAlumno"));
                    alumno.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    
                  
                    String grupoStr = rs.getString("grupo");
                    alumno.setGrupo(grupoStr != null && !grupoStr.isEmpty() ? grupoStr.charAt(0) : ' ');
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumno;
    }
    public List<AlumnoEntidad> obtenerTodosLosAlumno() {
        String sql = "SELECT * FROM alumno";
        List<AlumnoEntidad> lista = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                AlumnoEntidad alumno = new AlumnoEntidad();
                alumno.setCodAlumno(rs.getString("codAlumno"));
                alumno.setNombreAlumno(rs.getString("nombreAlumno"));
                alumno.setApellidosAlumno(rs.getString("apellidoAlumno"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                
                String grupoStr = rs.getString("grupo");
                alumno.setGrupo(grupoStr != null && !grupoStr.isEmpty() ? grupoStr.charAt(0) : ' ');

                lista.add(alumno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public void actualizarAlumno(AlumnoEntidad alumno) {
        String sql = "UPDATE alumno SET nombreAlumno = ?, apellidoAlumno = ?, fechaNacimiento = ?, grupo = ? WHERE codAlumno = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, alumno.getNombreAlumno());
            statement.setString(2, alumno.getApellidosAlumno());
            statement.setDate(3, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
            statement.setString(4, String.valueOf(alumno.getGrupo()));  // char → String
            statement.setString(5, alumno.getCodAlumno());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarAlumno(String id) {
        String sql = "DELETE FROM alumno WHERE codAlumno = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	@Override
	public void crarAlumno(AlumnoEntidad alumno) {
		// TODO Auto-generated method stub
		
	}
}
