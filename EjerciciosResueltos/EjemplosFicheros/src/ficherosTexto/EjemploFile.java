package ficherosTexto;

import java.io.File;
import java.io.IOException;

public class EjemploFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		verDir();
		
		crearFichero();
	}
	
	private static void verDir() {
		String dir=".";
		File f = new File(dir);
		File f2;
		String[] archivos = f.list();
		
		int tam = archivos.length;
		System.out.println("El numero de ficheros es: "+tam);
		for(int i=0;i<tam;i++) {
			f2 = new File(f,archivos[i]);
			System.out.print("El numero: "+archivos[i]+" es un ");
			if(f2.isDirectory())
				System.out.println("un directorio");
			if(f2.isFile())
				System.out.println("un fichero");
		}
		
	}
	
	private static void crearFichero() {
		File dir = new File("NUEVODIRECTORIO");
		File f1 = new File(dir,"fich1.txt");
		File f2 = new File(dir,"fich2.txt");
		
		dir.mkdir();
		
		try {
			if(f1.createNewFile())
				System.out.println("fichero "+f1.getName() +" creado correctamente");
			else {
					System.out.println("El fichero no se pudo crear");
			}
			
			if(f2.createNewFile())
				System.out.println("fichero "+f2.getName() +" creado correctamente");
				else {
					System.out.println("El fichero no se pudo crear");
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File newFile = new File(dir, "nuevoFichero.txt");
		f2.renameTo(newFile);
		
		System.out.println("El nuevo fichero es: "+newFile.getName());
		
	}

}
