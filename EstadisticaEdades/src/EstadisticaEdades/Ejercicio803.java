package EstadisticaEdades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio803 {

	public static void main(String[] args) {

	 /*
	  		Codificar un programa en lenguaje Java que duplique el fichero de texto del ejercicio 
		 	anterior, para lo cual preguntará al usuario el nombre del fichero origen y el nombre del fichero 
		 	destino,
		 	 pudiendo estar en diferentes ubicaciones, de manera que vaya leyendo carácter a 
		 	carácter del fichero origen y los irá grabando en el fichero destino.
		 	Además nos deberá mostrar 
		 	al final el número de caracteres grabados en el fichero destino. 
	 */
		String ubicacionOrigen = "C:/Users/samuelmv/Documents/fich1.txt";
		String ubicacionDestino = "C:/Users/samuelmv/Desktop/fich1.txt";
		
		
		Scanner sc = new Scanner(System.in);
		/*
		System.out.println("Nombre del fichero( fich1.txt ): ");
		String nombreFichero = sc.nextLine();
		System.out.println("Ubicacion( C:/Users/TuUsuario/Documents/ ): ");
		String ubicacion = sc.nextLine();
		System.out.println(ubicacion+nombreFichero);
		 */
		
		escribirFich(ubicacionOrigen, ubicacionDestino);
		
		
	}

	static private void escribirFich(String ubicacionOrigen, String ubicacionDestino) {
		
		File fich = new File("fich1.txt");
		
		String cadena = "Probando el filewriter";
		try {
			
			FileWriter f = new FileWriter(fich);
			char[] cad = cadena.toCharArray();
			for(int i=0; i<cad.length; i++) {
				f.write(cad[i]);
			}
			f.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException ioex) {
			
		}
	
	}
}
