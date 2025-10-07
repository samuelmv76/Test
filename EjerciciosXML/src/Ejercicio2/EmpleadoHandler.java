package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmpleadoHandler  extends DefaultHandler{

	private boolean esDepartamento = false;
	private boolean esDepartamentoVentas = false;
	private boolean esNombre= false;
	private boolean esEdad= false;
	private List<Integer> edades = new ArrayList<Integer>();
	
	public List<Integer> getEdades() {
		return edades;
	}

	public void setEdades(List<Integer> edades) {
		this.edades = edades;
	}

	String nombreActual= "";
	Integer edadActual;
	String departamentoActual;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("departamento")){
			esDepartamento=true;
		}else if (qName.equalsIgnoreCase("nombre")) {
			esNombre=true;
		}else if(qName.equalsIgnoreCase("edad")) {
			esEdad=true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("departamento")) {
			if(esDepartamentoVentas) {
				edades.add(edadActual);
				System.out.println("El empleado se llama: "+nombreActual);
			
			}
			esDepartamentoVentas=false;
			esDepartamento=false;
			
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(esNombre) {
			nombreActual= new String(ch,start,length);
			esNombre = false;
		} else if (esEdad) {
			edadActual= Integer.parseInt(new String(ch,start,length));
			esEdad=false;
		} else if (esDepartamento) {
			departamentoActual= new String(ch,start,length);
			esDepartamentoVentas = departamentoActual.equalsIgnoreCase("ventas");
		}
		
		
	}
	
}
