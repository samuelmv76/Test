 package ficherosXml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class ficherosXmlSax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leerDocumento();
	}
	
	
	static public void leerDocumento() {
		
		
		
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		
		
		SAXParser saxParser;
		try {
			saxParser = parserFactory.newSAXParser();
			XMLReader procesadorXML = saxParser.getXMLReader();
			
			GestorContenido gestor = new GestorContenido();
			
			procesadorXML.setContentHandler(gestor);
			
			InputSource input = new InputSource("empleados.xml");
			
			try {
				procesadorXML.parse(input);
				System.out.println(gestor.imprimir());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
