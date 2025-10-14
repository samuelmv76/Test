package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmpleadoHandler extends DefaultHandler {
    private List<Integer> edadesVentas = new ArrayList<Integer>();
    private boolean esDepartamentoVentas = false;
    private boolean esNombre = false;
    private boolean esEdad = false;
    private String nombreActual;
    private int edadActual;

    public List<Integer> getEdadesVentas() {
        return edadesVentas;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("departamento")) {
            esDepartamentoVentas = true;
        } else if (qName.equalsIgnoreCase("nombre")) {
            esNombre = true;
        } else if (qName.equalsIgnoreCase("edad")) {
            esEdad = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("departamento")) {
        	 if (esDepartamentoVentas) {
                 edadesVentas.add(edadActual);
                 System.out.println("Empleado en Ventas: " + nombreActual);
             }
            esDepartamentoVentas = false;
        
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (esNombre) {
            nombreActual = new String(ch, start, length);
            esNombre = false;
        } else if (esEdad) {
            edadActual = Integer.parseInt(new String(ch, start, length));
            esEdad = false;
        } else if (esDepartamentoVentas) {
            String departamento = new String(ch, start, length).trim();
            esDepartamentoVentas = departamento.equalsIgnoreCase("Ventas");
        }
    }
}