package ejercicio1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ClasificarAlumnosXML {

    public static void main(String[] args) {
        List<Alumno> alumnos = leerAlumnosXML("alumnos.xml");
        crearArchivoClasificado(alumnos, "notas_clasificadas.xml");
    }

    public static List<Alumno> leerAlumnosXML(String archivoEntrada) {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        try {
            File archivo = new File(archivoEntrada);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);
            doc.getDocumentElement().normalize();

            NodeList listaAlumnos = doc.getElementsByTagName("alumno");

            for (int i = 0; i < listaAlumnos.getLength(); i++) {
                Node nodo = listaAlumnos.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
                    double nota = Double.parseDouble(elemento.getElementsByTagName("nota").item(0).getTextContent());

                    alumnos.add(new Alumno(nombre, edad, nota));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    public static void crearArchivoClasificado(List<Alumno> alumnos, String archivoSalida) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            // Crear el elemento raíz <notas>
            Element rootElement = doc.createElement("notas");
            doc.appendChild(rootElement);

            // Clasificar los alumnos
            List<Alumno> suspensos = new ArrayList<Alumno>();
            List<Alumno> aprobados = new ArrayList<Alumno>();
            List<Alumno> notables = new ArrayList<Alumno>();
            List<Alumno> sobresalientes = new ArrayList<Alumno>();

            for (Alumno alumno : alumnos) {
                if (alumno.nota < 5) {
                    suspensos.add(alumno);
                } else if (alumno.nota < 7) {
                    aprobados.add(alumno);
                } else if (alumno.nota < 9) {
                    notables.add(alumno);
                } else {
                    sobresalientes.add(alumno);
                }
            }

            // Crear secciones para cada categoría
            crearSeccion(doc, rootElement, "suspensos", suspensos);
            crearSeccion(doc, rootElement, "aprobados", aprobados);
            crearSeccion(doc, rootElement, "notables", notables);
            crearSeccion(doc, rootElement, "sobresalientes", sobresalientes);

            // Escribir el contenido en el archivo XML de salida
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivoSalida));

            transformer.transform(source, result);

            System.out.println("Archivo XML creado con éxito: " + archivoSalida);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void crearSeccion(Document doc, Element root, String categoria, List<Alumno> alumnos) {
        Element seccion = doc.createElement(categoria);
        root.appendChild(seccion);

        // Crear el elemento <numero> con el total de alumnos en la categoría
        Element numero = doc.createElement("numero");
        numero.appendChild(doc.createTextNode(String.valueOf(alumnos.size())));
        seccion.appendChild(numero);

        // Crear el elemento <alumnos> que contiene todos los <alumno>
        Element listaAlumnos = doc.createElement("alumnos");
        seccion.appendChild(listaAlumnos);

        for (Alumno alumno : alumnos) {
            Element elementoAlumno = doc.createElement("alumno");
            elementoAlumno.appendChild(doc.createTextNode(alumno.nombre));
            listaAlumnos.appendChild(elementoAlumno);
        }
    }
}