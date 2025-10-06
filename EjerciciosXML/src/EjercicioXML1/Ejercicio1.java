package EjercicioXML1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Ejercicio1 {

	public static void main(String[] args) {
		
		
		File file = new File("empleados.xml");

		try {
		  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		  Document doc = dBuilder.parse(file);
			
			// estos métodos podemos usarlos combinados para normalizar el archivo XML
			doc.getDocumentElement().normalize();
			// almacenamos los nodos para luego mostrar la
			
			// cantidad de ellos con el método getLength()
			NodeList nList = doc.getElementsByTagName("empleado");
			System.out.println("Número de empleados: " + nList.getLength());
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				  Node nNode = nList.item(temp);
	
				  if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				    Element eElement = (Element) nNode;
	
				    System.out.println("\nEmpleado id: " + eElement.getAttribute("id"));
				    System.out.println("Apellido: "
				                + eElement.getElementsByTagName("apellido").item(0).getTextContent());
				    System.out.println("Departamento: "
				                + eElement.getElementsByTagName("dep").item(0).getTextContent());
				    System.out.println("Salario: "
				                + eElement.getElementsByTagName("salario").item(0).getTextContent());
				  }
				}
			
			NodeList nList1 = doc.getElementsByTagName("empleado");
	
			for (int i = 0; i < nList1.getLength(); i++) {
			  Node node = nList1.item(i);
	
			  if (node.getNodeType() == Node.ELEMENT_NODE) {
			    Element eElement = (Element) node;
	
			    if(eElement.hasChildNodes()) {
			      NodeList nl = node.getChildNodes();
			      for(int j=0; j<nl.getLength(); j++) {
			        Node nd = nl.item(j);
			        System.out.println(nd.getTextContent());
			      }
			    }
			  }
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
