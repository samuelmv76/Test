package Ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploFicheroBinario {

	public static void main(String[] args) {	
		escribirDatos();
		leerDatos();
	}
	
	
	 static private void escribirDatos() {
	        File fich = new File("fich2.dat");

	        DataOutputStream doS;
	        
	        String [] nombre = {"Sergio", "Pedro", "Juan","Laura"};
	        int [] edades = {23,43,54,65};
	        
	        
	        try {
	        
	        	doS = new DataOutputStream(new FileOutputStream(fich));
	        
	        	for(int i=0; i<4; i++) {
	        		doS.writeUTF(nombre[i]);
	        		doS.writeInt(edades[i]);
	        	}
	        	doS.close();
	        	
	        } catch (FileNotFoundException e) {
	            System.err.println("Archivo no encontrado: " + e.getMessage());
	        } catch (IOException ioex) {
	            System.err.println("Error de escritura: " + ioex.getMessage());
	        }
	    }
	
	 static private void leerDatos() {
		    File fich = new File("fich2.dat");

		    DataInputStream diS;

		    try {
		        diS = new DataInputStream(new FileInputStream(fich));

		        while (true) {
		            String nombre = diS.readUTF();
		            int edad = diS.readInt();

		            System.out.println("Nombre: " + nombre + ", Edad: " + edad);
		        }

		    } catch (EOFException e) {
		    	System.out.println("Fin de fichero");
		    
		    } catch (FileNotFoundException fnfe) {
		        System.err.println("Archivo no encontrado: " + fnfe.getMessage());
		    } catch (IOException ioex) {
		        System.err.println("Error de lectura: " + ioex.getMessage());
		}
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
