package proyectoJavax;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class Principal {

	public static void main(String[] args) {
		
		File file = new File("libreria.xml");
		try {

			JAXBContext context =JAXBContext.newInstance(Libreria.class);
			Unmarshaller unmars;
			
			unmars = context.createUnmarshaller();
			
			Libreria libreria = (Libreria) unmars.unmarshal(file);
			System.out.println("Nombre de la libreria: "+libreria.getNombre());
			System.out.println("Nombre de la libreria: "+libreria.getLugar());
			System.out.println("Libro de la libreria: ");
			
			ArrayList<Libro> libros = libreria.getListaLibros();
			for(Libro libro: libros) {
				System.out.println("Titulo "+libro.getNombre());
				System.out.println("Autor "+libro.getAutor());
				System.out.println("Editorial "+libro.getEditorial());
				System.out.println("Isbn "+libro.getIsbn());
			}
			
		} catch(JAXBException e) {
			e.printStackTrace();
		}
		
	}

}
