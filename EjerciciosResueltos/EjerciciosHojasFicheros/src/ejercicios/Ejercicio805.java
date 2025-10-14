package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio805 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File fichero = new File("datos805.txt");
		String cadenaNumerica;
		int numero, cotNumeros = 0;
		int acuNumeros=0;
		float media;
		
		if(fichero.length()!=0) {
			FileReader fr;
			try {
				fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				
				cadenaNumerica = br.readLine();
				
				while(cadenaNumerica!=null) {
					numero = Integer.parseInt(cadenaNumerica);
					cotNumeros++;
					acuNumeros= acuNumeros+numero;
					
					cadenaNumerica = br.readLine();
					
				}
				
				media = (float) acuNumeros/cotNumeros;
				
				System.out.println("Numero de leidos " + cotNumeros);
				System.out.println("Media "+ media);
				
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			
		}else {
			System.out.println("Fichero vacio");
		}

	}

}
