package ficherosXml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestorContenido extends DefaultHandler{
	ArrayList<empleado> empleados = new ArrayList<empleado>();
	empleado emp;
	boolean ap = false;
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Inicio documento xml");
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Fin documento xml");
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("comienzo elemento: "+ qName);
		if(qName.equals("empleado"))
			emp = new empleado();
		else if(qName.equals("apellido"))
			ap=true;
				
				
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Fin elemento "+ qName);
		if(qName.equals("empleado"))
			empleados.add(emp);
		else if(qName.equals("apellido"))
			ap=false;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String car = new String(ch,start,length);
		car.replaceAll("\t\n", "");
		//System.out.printf("\t caracteres: %s %n"+ car);
		System.out.println("caracteres: " + car);
		if(ap)
			emp.setApellido(car);
	}
	
	public int imprimir() {
		return empleados.size();
		
	}

}
