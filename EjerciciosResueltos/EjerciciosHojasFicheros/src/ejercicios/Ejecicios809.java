package ejercicios;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejecicios809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//grabarFichero();
		Trabajador t = null;
		ArrayList<Trabajador> empleados = new ArrayList<Trabajador>();
		
		int [] aHijos = new int [6];
		
		try {
			FileInputStream file = new FileInputStream("datos809.dat");
			ObjectInputStream Oi = new ObjectInputStream(file);
			
			try {
			
				while(true) {
					try {
						t = (Trabajador)Oi.readObject();
						empleados.add(t);
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
			}catch (EOFException e) {
				// TODO: handle exception
				
				System.out.println("Fin de fichero");
			}
			Oi.close();
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i<empleados.size();i++) {
			switch (empleados.get(i).getNumeroHijos()){
			case 0: {
				aHijos[0]++;
				break;
				
			}
			case 1: {
				aHijos[1]++;
				break;
			}
			case 2: {
				aHijos[2]++;
				break;
			}
			case 3: {
				aHijos[3]++;
				break;
			}
			case 4: 
			case 5: {
				aHijos[4]++;
				break;
			}
			default:
				aHijos[5]++;
		}
		
		}
		
		for(int i = 0; i<aHijos.length;i++) {
			System.out.print(aHijos[i]+" ");
			
			
		}
		
		FileOutputStream file;
		try {
			file = new FileOutputStream("salida809.dat");
			ObjectOutputStream ObjS = new ObjectOutputStream(file);
			ObjS.writeObject(aHijos);
			
			ObjS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static void grabarFichero() {
		
		
		try {
			FileOutputStream file = new FileOutputStream("datos809.dat");
			ObjectOutputStream ObjS = new ObjectOutputStream(file);
			
			Trabajador t = null;
			
			t = new Trabajador("T1",39,2);
			ObjS.writeObject(t);
			t = new Trabajador("T2",45,0);
			ObjS.writeObject(t);
			t = new Trabajador("T3",34,5);
			ObjS.writeObject(t);
			t = new Trabajador("T4",54,6);
			ObjS.writeObject(t);
			t = new Trabajador("T5",65,3);
			ObjS.writeObject(t);
			t = new Trabajador("T6",45,3);
			ObjS.writeObject(t);
			t = new Trabajador("T7",65,2);
			ObjS.writeObject(t);			
			t = new Trabajador("T8",23,0);
			ObjS.writeObject(t);
			
			ObjS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
