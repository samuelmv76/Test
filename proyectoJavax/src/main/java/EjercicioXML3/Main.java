package EjercicioXML3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String rutaArchivo = "empresa.xml";

        // 1. Crear la empresa con datos de ejemplo
        Empresa empresa = crearEmpresaEjemplo();

        // 2. Guardar la empresa en un archivo XML
        guardarEnXML(empresa, rutaArchivo);

        // 3. Leer el archivo XML y reconstruir el objeto
        Empresa empresaLeida = leerDesdeXML(rutaArchivo);

        // 4. Mostrar la información por pantalla
        mostrarDatosEmpresa(empresaLeida);
    }

    /**
     * Crea un objeto Empresa con algunos departamentos y empleados de ejemplo.
     */
    private static Empresa crearEmpresaEjemplo() {
        Empleado e1 = new Empleado("Ana Gómez", 1, "Gerente", 50000);
        Empleado e2 = new Empleado("Pedro Martínez", 2, "Especialista", 40000);
        Empleado e3 = new Empleado("Laura Fernández", 3, "Desarrollador", 45000);
        Empleado e4 = new Empleado("Carlos García", 4, "Analista", 42000);

        Departamento d1 = new Departamento("Recursos Humanos", Arrays.asList(e1, e2));
        Departamento d2 = new Departamento("Tecnología", Arrays.asList(e3, e4));

        return new Empresa(Arrays.asList(d1, d2));
    }

    /**
     * Serializa el objeto Empresa a un archivo XML.
     */
    private static void guardarEnXML(Empresa empresa, String rutaArchivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(Empresa.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File(rutaArchivo);
            marshaller.marshal(empresa, file);

            System.out.println("✅ Archivo XML generado: " + file.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("❌ Error al guardar en XML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Deserializa el archivo XML y devuelve un objeto Empresa.
     */
    private static Empresa leerDesdeXML(String rutaArchivo) {
        Empresa empresa = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Empresa.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            File file = new File(rutaArchivo);
            empresa = (Empresa) unmarshaller.unmarshal(file);

            System.out.println("📄 Archivo XML leído correctamente.");
        } catch (Exception e) {
            System.err.println("❌ Error al leer el XML: " + e.getMessage());
            e.printStackTrace();
        }
        return empresa;
    }

    /**
     * Muestra en consola los datos de la empresa.
     */
    private static void mostrarDatosEmpresa(Empresa empresa) {
        if (empresa == null || empresa.getDepartamentos() == null) {
            System.out.println("⚠️ No hay datos para mostrar.");
            return;
        }

        System.out.println("\n📢 Contenido de la Empresa:");
        for (Departamento depto : empresa.getDepartamentos()) {
            System.out.println("Departamento: " + depto.getNombre());
            for (Empleado emp : depto.getEmpleados()) {
                System.out.println(" - " + emp.getNombre()
                        + " | ID: " + emp.getId()
                        + " | Puesto: " + emp.getPuesto()
                        + " | Salario: " + emp.getSalario());
            }
        }
    }
}
