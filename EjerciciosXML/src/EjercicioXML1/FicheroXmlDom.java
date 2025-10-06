package EjercicioXML1;


import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class FicheroXmlDom {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//crearFicheroXml();
		cargarFicheroXml();
	}
	
	
	static void crearNodo(String datoEmpleado, String valor, Element raiz, Document doc) {
		
		Element elem = doc.createElement(datoEmpleado);
		Text texto = doc.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(texto);
		
	}
	
	static void crearFicheroXml() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			DOMImplementation implementation =  builder.getDOMImplementation();
			
			
			Document doc = implementation.createDocument(null, "Empleados", null);
			doc.setXmlVersion("1.0");
			
			Element raiz = doc.createElement("empleado");
			
			doc.getDocumentElement().appendChild(raiz);
			
			
			System.out.println("Introduzca apellido empleado");
			String apellido = sc.nextLine();

			System.out.println("Introduzca numero empleado");
			int numero = sc.nextInt();
			
			System.out.println("Introduzca salario empleado");
			float salario = sc.nextFloat();
			
			
			crearNodo("id", "1",raiz , doc);
			crearNodo("apellido", apellido,raiz , doc);
			crearNodo("numero", Integer.toString(numero),raiz , doc);
			crearNodo("salario", Float.toString(salario),raiz , doc);
			
			
			Source source = new DOMSource(doc); 

			Result result = new StreamResult(new java.io.File("Empleados.xml")); 
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			
			
			transformer.transform(source, result);
			
			
			result = new StreamResult(System.out);
			
			transformer.transform(source, result);
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void cargarFicheroXml() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse("Empleados.xml");
			
			System.out.println("Elemento raiz: "+ doc.getDocumentElement().getNodeName());
			
			NodeList nodos = doc.getElementsByTagName("empleado");
			
			
			for(int i=0; i<nodos.getLength();i++) {
				
				Node nodo = nodos.item(i);
				
				if(nodo.getNodeType()== Node.ELEMENT_NODE) {
					Element elemento = (Element)nodo;
					System.out.print("id: ");
					System.out.println(elemento.getElementsByTagName("id").item(0).getTextContent());
					System.out.print("apellido: ");
					System.out.println(elemento.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.print("numero: ");
					System.out.println(elemento.getElementsByTagName("numero").item(0).getTextContent());
					System.out.print("salario: ");
					System.out.println(elemento.getElementsByTagName("salario").item(0).getTextContent());
				}
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
