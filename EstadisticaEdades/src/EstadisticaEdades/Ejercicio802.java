package EstadisticaEdades;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio802 {

	public static void main(String[] args) {
/*
		Crea con el bloc de notas de Windows un fichero de texto en una carpeta de tu 
		ordenador. El fichero contendrá una frase cualquiera.
		
		Codificar posteriormente un programa en lenguaje Java que pregunte al usuario por el nombre 
		del fichero y su ubicación según la ruta de carpetas del sistema operativo. 
		
		Suponiendo que el usuario tecleará la ruta y nombre del fichero correctamente, el programa 
		
		mostrará en pantalla, carácter a carácter, el contenido del fichero de texto, pero con todos sus 
		caracteres en mayúsculas y sustituyendo sus espacios en blanco por guiones.
*/
		String nombreFichero = "fich1.txt";
		String ubicacion = "C:/Users/samuelmv/Documents/";
		
		Scanner sc = new Scanner(System.in);
		/*
		System.out.println("Nombre del fichero( fich1.txt ): ");
		String nombreFichero = sc.nextLine();
		System.out.println("Ubicacion( C:/Users/TuUsuario/Documents/ ): ");
		String ubicacion = sc.nextLine();
		System.out.println(ubicacion+nombreFichero);
		 */
		
		leerf(ubicacion,nombreFichero);
	}
		
		static private void leerf(String ubicacion,String nombreFichero) {
			
			File fich = new File(ubicacion+nombreFichero);
			
			try {
				
				FileReader f = new FileReader(fich);
				
				int i;
				
				while((i = f.read())!= -1) {
					
					//System.out.print((char)i);
					
					 char ch = (char) i;
		                if (ch == ' ') {
		                    System.out.print('-');
		                } else {
		                    System.out.print(Character.toUpperCase(ch));
		                }
					
				}
				System.out.println();
			} catch (FileNotFoundException e){
				e.printStackTrace();
			} catch (IOException ioex) {
				
			}
		}
	}