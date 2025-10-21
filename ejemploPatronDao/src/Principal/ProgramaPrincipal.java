package Principal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	private static DataSource configurarDataSource() {
	
		MysqlDataSource ds = null;
		
		Properties prop = new Properties();
		
		FileInputStream File;
		try {
			File = new FileInputStream("resources/config.properties");
			prop.load(File);
			
			String host = prop.getProperty("db.host");
			String port = prop.getProperty("db.port");
			String database = prop.getProperty("db.database");
			String user = prop.getProperty("db.user");
			String password = prop.getProperty("db.password");
			
			ds = new MysqlDataSource();
			ds.setServerName(host);
			ds.setPortNumber(Integer.parseInt(port));
			ds.setDatabaseName(database);
			ds.setUser(user);
			ds.setPassword(password);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; // Reemplazar con la implementación real
	}

}
