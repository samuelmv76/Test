package ficherosXml;

import java.io.File;
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

public class ficherosXmlDom {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		
		
		
		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();
				
				DocumentBuilder builder;
				try {
					builder = factory.newDocumentBuilder();
					DOMImplementation implementation = builder.getDOMImplementation();
					Document document =
					implementation.createDocument(null, "Empleados", null);
					
					cargarFicheros(builder);
		
					//crearFichero(document);
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				
				
	
	
}
	
	
	private static void cargarFicheros(DocumentBuilder builder) {
		
		 try {
			Document doc = builder.parse(new File("empleados.xml"));
			
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList lista =  doc.getElementsByTagName("empleado");
			
			for(int i=0; i<lista.getLength();i++) {
				Node node = lista.item(i);
				if(Node.ELEMENT_NODE==node.getNodeType()) {
					
					Element ele = (Element)node;
					
					System.out.println(ele.getElementsByTagName("numero").item(0).getTextContent());
					System.out.println(ele.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.println(ele.getElementsByTagName("salario").item(0).getTextContent());
				}
				
				
			}
			
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	private static void crearFichero(Document document) {
		document.setXmlVersion("1.0"); //asignamos la versión de nuestro XML
		Element ele = document.createElement("empleado");
		document.getDocumentElement().appendChild(ele);
		
		System.out.println("DAme el apellido del empleado");
		String apellido = sc.nextLine();
		crearElemento("apellido", apellido, ele,document);
		System.out.println("DAme el numero del empleado");
		int numero = sc.nextInt();
		crearElemento("numero", Integer.toString(numero), ele,document);
		System.out.println("DAme el salario del empleado");
		float salario = sc.nextFloat();
		crearElemento("salario", Float.toString(salario), ele,document);
		
		Source source = new DOMSource(document);
		
		Result result = new StreamResult(new java.io.File("empleados.xml"));
		
		try {
			Transformer tranformer = TransformerFactory.newInstance().newTransformer();
			
			try {
				tranformer.transform(source, result);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
	
	private static void crearElemento(String datoEmple, String valor, Element raiz, Document doc) {
		
		Element element = doc.createElement(datoEmple);
		Text texto = doc.createTextNode(valor);
		raiz.appendChild(element);
		element.appendChild(texto);
		
		
		
		
	}
	
}
