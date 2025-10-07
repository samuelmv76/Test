package Ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class LeerEmpleados {
	public static void main(String[] args) {
		
		//crear instancia del sax parser
		SAXParserFactory factory = SAXParserFactory.newInstance();
	try {
		SAXParser saxParser = factory.newSAXParser();
		
	//instanciar el handler para manejar el archivo xml
		EmpleadoHandler handler = new EmpleadoHandler();
		File archivoXml = new File("empleados.xml");
		
		saxParser.parse(archivoXml, handler);
		
		List<Integer> edadesVentas = handler.getEdades();
		double sumaEdades = 0;
		
		for(int edad: edadesVentas){
			sumaEdades+=edad;
		}
		
		double mediaEdad =sumaEdades/edadesVentas.size();
		 System.out.println("La media de edad de los empleados del departamento de ventas es: " + mediaEdad);
	
	} catch(ParserConfigurationException | SAXException | IOException e) {
		e.printStackTrace();
	}

	}
}
