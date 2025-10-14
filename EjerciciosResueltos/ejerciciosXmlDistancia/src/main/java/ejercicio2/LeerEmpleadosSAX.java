package ejercicio2;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class LeerEmpleadosSAX {
    public static void main(String[] args) {
        try {
            // Crear la instancia de SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Instancia del handler para manejar el archivo XML
            EmpleadoHandler handler = new EmpleadoHandler();
            File archivoXML = new File("empleados.xml");

            // Parsear el archivo
            saxParser.parse(archivoXML, handler);

            // Calcular la media de edades de los empleados en "Ventas"
            List<Integer> edadesVentas = handler.getEdadesVentas();
            double sumaEdades = 0;
            for (int edad : edadesVentas) {
                sumaEdades += edad;
            }
            double mediaEdad = edadesVentas.isEmpty() ? 0.0 : sumaEdades / edadesVentas.size();


            System.out.println("La media de edad de los empleados en Ventas es: " + mediaEdad);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}