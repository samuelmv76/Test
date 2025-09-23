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
		    File fich = new File("fichDatos.dat");

		    DataInputStream dis;

		    try {
		        dis = new DataInputStream(new FileInputStream(fich));

		        String nom;
		        int edad;
		        try {
		            while(true) {
		                nom = dis.readUTF();
		                edad = dis.readInt();
		                System.out.println("Nombre: " + nom + " Edad: " + edad);
		            }

		        } catch (EOFException e) {
		            // TODO: handle exception
		            System.out.println("Fin de fichero");
		        }

		        dis.close();

		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
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
