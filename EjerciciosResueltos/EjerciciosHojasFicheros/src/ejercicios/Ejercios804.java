package ejercicios;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ejercios804 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String nombreFichero;
		File file;
		
		int caracter;
		int nCareres, nPalabras, nLineas;
		
		nombreFichero = PideCadena();
		
		file = new File(nombreFichero);
		
		if(file.length()!=0) {
			
			nCareres=0;
			nPalabras=1;
			nLineas= 1;
			BufferedInputStream bi;
			
			FileInputStream fi;
			try {
				fi = new FileInputStream(file);
				bi =new BufferedInputStream(fi);
				
		
					caracter = bi.read();
					
					while(caracter != -1) {
						
						switch (caracter) {
						case '\n': 
							nLineas++;
							nPalabras++;
							break;
							
						case ' ':
							nPalabras++;
							break;
							
						default:
							nCareres++;
								
					}
						caracter = bi.read();
					}
					System.out.println("Numero lineas: "+nLineas );
					System.out.println("Numero caracteres: " + nCareres);
					System.out.println("Numero palabras: "+ nPalabras);
					
					
					bi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		else {
			System.out.println("Fichero vacio");
		}
		
	}
	
	
	static String PideCadena() {
		
		Scanner sc = new Scanner(System.in);
		String cadena;
		System.out.println("Introduzca ruta y nombre del fichero: ");
		cadena = sc.nextLine();
		return cadena;
		
	}

}
