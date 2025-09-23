package Ficheros;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploFicheroBinario {

	public static void main(String[] args) {	
		escribir();
		leer();
	}
	
	
	 static private void escribirDatos() {
	        File f = new File("fich2.dat");

	        String[] nombres = {"Sergio", "Pablo", "Laura", "Lorena"};
	        int[] edades = {23, 43, 54, 2};

	        try (DataOutputStream dOs = new DataOutputStream(new FileOutputStream(f))) {
	            for (int i = 0; i < nombres.length; i++) {
	                dOs.writeChars(nombres[i]);  
	                dOs.writeInt(edades[i]);
	            }
	        } catch (FileNotFoundException e) {
	            System.err.println("Archivo no encontrado: " + e.getMessage());
	        } catch (IOException ioex) {
	            System.err.println("Error de escritura: " + ioex.getMessage());
	        }
	    }
	
	static private void leerDatos() {
		
	}
	
	
	static private void escribir() {
	
		// TODO Auto-generated method stub
		File f = new File("fich2.dat");
		try {
			
			FileOutputStream fo = new FileOutputStream(f);
			
			for(int i=0; i<11; i++) {
				try {
					fo.write(i);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}  catch (IOException ioex) {
					
				}			
			
			}
			fo.close();
			
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException ioex) {
			
		}
	}
	static private void leer() {
		File f = new File("fich2.dat");
		try {
			FileInputStream fi = new FileInputStream(f);
			int i;
			while((i=fi.read())!=-1) {
				System.out.println(i);
			}
			fi.close();
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException ioex) {
			
		}
	}
	
	
	
	static private void escribirFOS() {
		
		// TODO Auto-generated method stub
		File f = new File("fich2.dat");
		try {
			
			FileOutputStream fo = new FileOutputStream(f);
			
			for(int i=0; i<11; i++) {
				try {
					fo.write(i);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}  catch (IOException ioex) {
					
				}			
			
			}
			fo.close();
			
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException ioex) {
			
		}
	}
	static private void leerFOS() {
			File f = new File("fich2.dat");
		try {
			FileInputStream fi = new FileInputStream(f);
			int i;
			while((i=fi.read())!=-1) {
				System.out.println(i);
			}
			fi.close();
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException ioex) {
			
		}
	}
	
}
