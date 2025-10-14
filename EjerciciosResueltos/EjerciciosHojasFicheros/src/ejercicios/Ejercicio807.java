package ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Ejercicio807 {
	public static final int NELEM = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fi;
		int [] vector = new int[NELEM];
		
		try {
			fi = new FileInputStream("datos807.dat");
			DataInputStream di = new DataInputStream(fi);
			
			System.out.println("Vector sin ordenar:");
			for(int i=0; i<NELEM;i++) {
				vector[i]=di.readInt();
				System.out.print(vector[i]);
			}
			System.out.println();
			
			
			Arrays.sort(vector);
			System.out.println("Vector ordenado");
			
			for(int i=0; i<NELEM;i++) {
				
				System.out.print(vector[i]);
			}
			
			
			di.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileOutputStream fo;
		try {
			fo = new FileOutputStream("datosSalidaA807.dat");
			DataOutputStream dO = new DataOutputStream(fo);
			
			for(int i = 0; i<NELEM;i++) {
				dO.writeInt(vector[i]);
			}
			
			dO.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fo = new FileOutputStream("datosSalidaB807.dat");
			ObjectOutputStream Oo = new ObjectOutputStream(fo);
			
			Oo.writeObject(vector);
			
			Oo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

	}

}
