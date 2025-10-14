package ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio803 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			String ficheroEntrada  = pideCadena("Introduce fichero de entrada:");
			
			FileInputStream fEntrada = new FileInputStream(ficheroEntrada);
			
			BufferedInputStream bInput = new BufferedInputStream(fEntrada);
			
			
			String ficheroSalida  = pideCadena("Introduce fichero de salida:");
			
			FileOutputStream fSalida;
		
				fSalida = new FileOutputStream(ficheroSalida);
			
			
			BufferedOutputStream bOutput = new BufferedOutputStream(fSalida);
			
			
			int cont = 0;
			
			int caracter = bInput.read();
			
			while (caracter != -1) {
				
				bOutput.write(caracter);
				cont++;
				caracter = bInput.read();
			}
		
			bOutput.close();
			bInput.close();
			
			
			System.out.println("Numero de caracteres: "+ cont);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		

	}
	
	
	static String pideCadena(String mensaje) {
		Scanner sc = new Scanner(System.in);
		String fichero;
		
		System.out.println(mensaje);
		fichero = sc.nextLine();
		return fichero;
		
	}

}
