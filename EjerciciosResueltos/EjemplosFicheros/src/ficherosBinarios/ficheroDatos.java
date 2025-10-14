package ficherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ficheroDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("datos.dat");
		//escribirFichero(f);
		//leerFichero(f);
		escribirFicheroObjetos(f);
		leerFicheroObjetos(f);
	}
	
	private static void escribirFichero(File f) {
		FileOutputStream fich;
		try {
			fich = new FileOutputStream(f);
			int i;
			
			for(i=1;i<=100;i++) {
				fich.write(i);
			}
			
			fich.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void leerFichero(File f) {
		FileInputStream fich;
		try {
			fich = new FileInputStream(f);
			int i;
			while((i=fich.read())!=-1) {
				System.out.println(i);
			}
			fich.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	
	private static void escribirFicheroDatos(File f) {
		FileOutputStream fich;
		String nombres[] = {"Sergio", "Juan","Pedro","Luis"};
		int edades[] = {23,42,15,19};
		
		try {
			fich = new FileOutputStream(f);
			DataOutputStream dfich = new DataOutputStream(fich);
			
			for(int i=0; i<nombres.length;i++) {
				dfich.writeUTF(nombres[i]);
				dfich.writeInt(edades[i]);
			}
			
			dfich.close();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void leerFicheroDatos(File f) {
		FileInputStream fich;
		try {
			fich = new FileInputStream(f);
			DataInputStream dfile = new DataInputStream(fich);
			try {
				while(true) {
					System.out.println( "Nombre: "+dfile.readUTF() +" edad: "+ dfile.readInt());;
				}
			}catch (EOFException e) {
				System.out.println("Fin de fichero");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	private static void escribirFicheroObjetos(File f) {
		FileOutputStream fich;
		try {
			fich = new FileOutputStream(f);
			ObjectOutputStream oFich = new ObjectOutputStream(fich);
			
			Cliente cli = new Cliente("Sergio", 45, 75);
			
			oFich.writeObject(cli);
			
			oFich.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void leerFicheroObjetos(File f) {
		
		FileInputStream fich;
		try {
			fich = new FileInputStream(f);
			ObjectInputStream oFich = new ObjectInputStream(fich);
			
			try {
				while(true) {
					Cliente c = (Cliente)oFich.readObject();
					System.out.println(c.toString());
				}
			}catch (EOFException | ClassNotFoundException e) {
					// TODO: handle exception
					System.out.println("Fin de fichero");
				}
				
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
}
