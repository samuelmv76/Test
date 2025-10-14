package ejercicio3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.util.Arrays;

public class Main {
	
	
    public static void main(String[] args) {
    	escribirFichero();
    	leerFichero();
    }
    
    private static void escribirFichero() {
        
    
        Empleado emp1 = new Empleado("Ana Gómez", 1, "Gerente", 50000);
        Empleado emp2 = new Empleado("Pedro Martínez", 2, "Especialista", 40000);
        Departamento dep1 = new Departamento("Recursos Humanos", Arrays.asList(emp1, emp2));

        Empleado emp3 = new Empleado("Laura Fernández", 3, "Desarrollador", 45000);
        Empleado emp4 = new Empleado("Carlos García", 4, "Analista", 42000);
        Departamento dep2 = new Departamento("Tecnología", Arrays.asList(emp3, emp4));

        Empresa empresa = new Empresa(Arrays.asList(dep1, dep2));

        try {
            JAXBContext context = JAXBContext.newInstance(Empresa.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(empresa, new File("empresa.xml"));
            System.out.println("Archivo XML generado con éxito.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    
    private static void leerFichero() {
    	
        try {
            JAXBContext context = JAXBContext.newInstance(Empresa.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Empresa empresa = (Empresa) unmarshaller.unmarshal(new File("empresa.xml"));
            
            // Imprimir la estructura de la empresa
            for (Departamento dep : empresa.getDepartamentos()) {
                System.out.println("Departamento: " + dep.getNombre());
                for (Empleado emp : dep.getEmpleados()) {
                    System.out.println("\tEmpleado: " + emp.getNombre() + ", Puesto: " + emp.getPuesto());
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    
}
