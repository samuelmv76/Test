package ejercicios;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;



public class Ejercicio801 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f = new File("entrada801.dat");
		
		int numAlumnos = 0, numMenores=0;
		double mediaEdades=0;
		int maxEdad=0, minEdad=0;
		int aux;
		int sumEdades=0;
		ArrayList alumnos = new ArrayList();
		
		
		try {
			DataInputStream dInput = new DataInputStream(new FileInputStream(f));
			try {
			
				aux=dInput.readInt();
				alumnos.add(aux);			
				maxEdad=minEdad=aux;
				
			
			
				while(true) {
					System.out.println(aux);
					if(aux<18)
						numMenores++;
					if(maxEdad<aux)
						maxEdad=aux;
					if(minEdad>aux)
						minEdad=aux;
					numAlumnos++;
					
					sumEdades=sumEdades+aux;
					aux=dInput.readInt();
					alumnos.add(aux);
				}
			}catch (EOFException e) {
				System.out.println("Fin fichero");
				// TODO: handle exception
			}
			
			mediaEdades=sumEdades/numAlumnos;
			
			Iterator it = alumnos.iterator();
			double aux2=0;
			while(it.hasNext()) {
				
				int a1 = (int) it.next();
				aux2 = aux2 + Math.pow(a1-mediaEdades,2);
				
			}
			
			double mediaaux = aux2/numAlumnos;
			
			System.out.println("Media de edades: "+ mediaEdades);
			System.out.println("La mayor edad: "+ maxEdad);
			System.out.println("La menor edad: "+ minEdad);
			System.out.println("Tendremos "+numAlumnos+"alumnos");
			System.out.println("Tendremos "+numMenores+" menores");
			
			
			System.out.println("Desviación tipica:" + Math.sqrt(mediaaux));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
