package ejercicios;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio806 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fichero;
		DataInputStream fData;
		String ficheroCad = PideCadena();
		
		double verDouble, mayor = 0, menor=0, suma=0;
		
		int contNumertos=0;
		
		
		
		
		try {
			fichero = new FileInputStream(ficheroCad);
			fData = new DataInputStream(fichero);
			
			verDouble = fData.readDouble();
			
			mayor = menor = verDouble;
			
			boolean sw = true;
			
			try {
			while(true) {
				contNumertos++;
				
				if(verDouble>mayor)
					mayor=verDouble;
				if(verDouble<menor)
					menor=verDouble;
				
				suma+=verDouble;
				
				verDouble = fData.readDouble();
							
			}
			}catch (EOFException e) {
				// TODO: handle exception
				System.out.println("Fin de fichero");
			}
			
			fData.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Numero de leidos: " +contNumertos);
		System.out.println("Media de leidos: " +suma/contNumertos);
		System.out.println("Numero mayor: " + mayor+ " Numero menor "+menor);
		
		
		
		

	}
	
	
static String PideCadena() {
		
		Scanner sc = new Scanner(System.in);
		String cadena;
		System.out.println("Introduzca ruta y nombre del fichero: ");
		cadena = sc.nextLine();
		return cadena;
		
	}

}
