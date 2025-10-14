package ejemploConexionBD;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import com.mysql.cj.jdbc.MysqlDataSource;

public class conexionMySql {
	
	public static void main(String[] args) {
		
		Connection conexion = null;
		Statement stmt = null;
		ResultSet resultado = null;
		
		MysqlDataSource ds = null;
		Properties prop = new Properties();
		
		try {
			// Cargar archivo de propiedades
			FileInputStream file = new FileInputStream("resources\\conexion.properties");
			prop.load(file);
				
			// Configurar la fuente de datos
			ds = new MysqlDataSource();
			ds.setUrl(prop.getProperty("url"));
			ds.setUser(prop.getProperty("user"));
			ds.setPassword(prop.getProperty("password"));
				
			// Establecer conexión
			conexion = ds.getConnection();

			// Insertar un registro (opcional)
			String sql = "INSERT INTO persona (idPersona, nombre, apellido, numeroTelefono) VALUES (?,?,?,?)";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setString(2, "Sergio");
			pst.setString(3, "Capdevila");
			pst.setString(4, "666555444");
			// Descomenta para insertar
			 pst.executeUpdate();
			
			/* Eliminar un registro (opcional) 
			String del = "DELETE FROM persona WHERE idPersona = ?";
			PreparedStatement pst2 = conexion.prepareStatement(del);
			pst2.setInt(1, 1);*/
			// pst2.executeUpdate();

			// ===========================
			//      MOSTRAR REGISTROS
			// ===========================
			String select = "SELECT idPersona, nombre, apellido, numeroTelefono FROM persona";
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(select);
			
			System.out.println("Registros en la tabla persona:");
			System.out.println("----------------------------------");
			while (resultado.next()) {
				int id = resultado.getInt("idPersona");
				String nombre = resultado.getString("nombre");
				String apellido = resultado.getString("apellido");
				String telefono = resultado.getString("numeroTelefono");
				
				System.out.println("ID: " + id);
				System.out.println("Nombre: " + nombre);
				System.out.println("Apellido: " + apellido);
				System.out.println("Teléfono: " + telefono);
				System.out.println("----------------------------------");
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar recursos correctamente
			try {
				if (resultado != null) resultado.close();
				if (stmt != null) stmt.close();
				if (conexion != null) conexion.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
