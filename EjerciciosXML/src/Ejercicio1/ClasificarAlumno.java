package Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ClasificarAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static List<Alumno> leerAlumnoXml(String archivoEntrada){
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			File f = new File(archivoEntrada);
			Document doc = dBuilder.parse(f);
			
			NodeList nodos = doc.getElementsByTagName("alumno");
			
			for(int i=0; i<nodos.getLength(); i++) {
				Node nodo = nodos.item(i);
				if(nodo.getNodeType() == Node.ELEMENT_NODE) {
					  // Obtener y mostrar el contenido de cada elemento hijo
                    Element elemento = (Element)nodo;
					
					String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
                    double nota = Double.parseDouble(elemento.getElementsByTagName("nota").item(0).getTextContent());
                    alumnos.add(new Alumno(nombre,edad,nota));
				}
			}
			
		} catch (ParserConfigurationException | SAXException | IOException  e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	
	public static void crearArchivoClasificado(List<Alumno> alumnos, String ficheroSalida) {
		List<Alumno> suspensos = new ArrayList<Alumno>();
		List<Alumno> aprobados = new ArrayList<Alumno>();
		List<Alumno> notables = new ArrayList<Alumno>();
		List<Alumno> sobresalientes = new ArrayList<Alumno>();
		
		for(Alumno alumno: alumnos) {
			if(alumno.getNota()<4)
				suspensos.add(alumno);
			else if(alumno.getNota()<7)
				suspensos.add(alumno);
			else if(alumno.getNota()<9)
				notables.add(alumno);
			else sobresalientes.add(alumno);
		}
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.newDocument();
				
				Element rootElement = doc.createElement("notas");
				doc.appendChild(rootElement);
				
				crearSeleccion(doc, rootElement, "suspensos", suspensos);
				crearSeleccion(doc, rootElement, "aprobados", aprobados);
				crearSeleccion(doc, rootElement, "notables", notables);
				crearSeleccion(doc, rootElement, "sobresalientes", sobresalientes);
				
			} catch(ParserConfigurationException e){
				e.printStackTrace();
			}
	}
	
	private static void crearSeleccion(Document doc, Element rootElement, String string, List<Alumno> suspensos) {
		// TODO Auto-generated method stub
		
	}
	
}
