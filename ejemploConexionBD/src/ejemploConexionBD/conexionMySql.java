package ejemploConexionBD;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class conexionMySql {
	
	
	public static void main(String[] args) {
		
		Connection conexion;
		Statement stmt = null;
		ResultSet resultado = null;
		
		MysqlDataSource ds =null ;
		
		Properties prop = new Properties();
		
		
		try {
			
			FileInputStream file = new FileInputStream("resources\\conexion.properties");
				
			prop.load(file);
				
			ds = new MysqlDataSource();
			ds.setUrl(prop.getProperty("url"));
			ds.setUser(prop.getProperty("user"));
			ds.setPassword(prop.getProperty("password"));
				
			conexion = ds.getConnection();
			String sql = "insert into persona (idPersona , nombre, apellido, numeroTelefono)"+
			"values(?,?,?,?)";
			
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setString(2, "Sergio");
			pst.setString(3, "Capdevila");
			pst.setString(4, "666555444");
			//comentar lo otro para hacer el insert
			//pst.executeUpdate();
			
			String del = "DELETE persona FROM persona WHERE idPersona =?";
			PreparedStatement pst2 = conexion.prepareStatement(del);
			pst2.setInt(1, 1);
			pst2.executeUpdate();
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
