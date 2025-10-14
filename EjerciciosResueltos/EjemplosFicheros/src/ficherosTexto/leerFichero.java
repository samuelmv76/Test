package ficherosTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class leerFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("ficheroTexto.txt");
		escribirFichero(f);
		leerFichero1(f);
	}
	
	
	
	private static void leerFichero1(File f) {
		
		int l;
		try {
			FileReader fich = new FileReader(f);
			
			while ((l=fich.read())!=-1) {
				System.out.print((char)l);
			}									
			fich.close();
			
			fich = new FileReader(f);
			char cadena[] = new char[10];
			while ((l=fich.read(cadena))!=-1) {
				System.out.print(cadena);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static void escribirFichero(File f) {
		
		FileWriter file;
		try {
			file = new FileWriter(f);
			String cadena = "Nueva cadena de texto";
			
			char[] cadenaV = cadena.toCharArray();
			
			for(int i=0; i<cadenaV.length;i++) {
				file.write(cadenaV[i]);
			}
			file.append(" *");
			
			
			file.close();
			
			String prov[] = {"Asturias", "Albacete", "MAdrid","Cataluña","Avila"};
			
			file = new FileWriter(f,true);
			
			for(int i =0;i<prov.length;i++) {
				file.write(prov[i]+"\n");
			}
			file.close();

			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
