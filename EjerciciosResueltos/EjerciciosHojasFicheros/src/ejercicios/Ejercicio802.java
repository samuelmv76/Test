package ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio802 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner Teclado = new Scanner(System.in);
		
		System.out.println("Dame la ruta de tu fichero");
			String ruta = Teclado.nextLine();
		System.out.println("Dame el nombre de tu fichero");
			String nombre = Teclado.nextLine();
			
			File f = new File(ruta,nombre);
			
			try {
				BufferedReader bI =new BufferedReader(new FileReader(f));
				int caracter;
				String nuevaFrase=bI.readLine();
				/*caracter= bI.read();
				while(caracter !=-1) {
					nuevaFrase=nuevaFrase+ (char)caracter;
					caracter= bI.read();
				}*/
				
				nuevaFrase =  nuevaFrase.toUpperCase();
				nuevaFrase = nuevaFrase.replace(' ','-');
				System.out.println(nuevaFrase);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

	}

}
