package EjercicioXML1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio1Terminado {

    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            File file = new File("alumnos.xml");

            // Crear el DocumentBuilder para parsear el XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parsear el documento XML y normalizar
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            // Obtener todos los nodos "alumno"
            NodeList nList = doc.getElementsByTagName("alumno");
            System.out.println("Número de alumnos: " + nList.getLength());

            // Recorrer cada nodo "alumno"
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    // Obtener y mostrar el contenido de cada elemento hijo
                    String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String edad = eElement.getElementsByTagName("edad").item(0).getTextContent();
                    String nota = eElement.getElementsByTagName("nota").item(0).getTextContent();

                    System.out.println("Alumno #" + (i + 1));
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Edad: " + edad);
                    System.out.println("Nota: " + nota);
                    System.out.println("-----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
