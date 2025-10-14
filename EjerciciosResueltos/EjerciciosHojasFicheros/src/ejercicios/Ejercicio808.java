package ejercicios;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio808 {
	
	public final static int NFIL = 30;
	public final static int NCOL = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] matriz = new int[NFIL][NCOL];
		int [] vacum = new int[NCOL];
		
		
		FileInputStream fi;
		try {
			fi = new FileInputStream("808matriz.dat");
			ObjectInputStream oi = new ObjectInputStream(fi);
			int mayNota=0;
			int menNota=0;
			
			
			try {
				matriz = (int[][]) oi.readObject();
				
				for(int c=0; c<NCOL; c++) {
					
					menNota = 101;
					mayNota = -1;
					
					for(int f =0; f< NFIL; f++) {
						if( mayNota< matriz[f][c])
							mayNota  =matriz[f][c];
						if(menNota> matriz[f][c])
							menNota  =matriz[f][c];
						vacum[c]+= matriz[f][c];
						
					}
					
					System.out.println();
					System.out.println("La nota mayor del test " +c+1+" es " +mayNota);
					System.out.println();
					System.out.println("La nota menor del test " +c+1+" es " +menNota);
				}
				
				int acum=0;
				float media;
				
				int cmenor25=0;
				int c25_49=0;
				int c50_75=0;
				int cmas75=0;
				
				for(int f =0; f< NFIL; f++) {
					
					acum=0;
					for(int c=0; c<NCOL; c++) {
						acum = acum + matriz[f][c];
					}
					
					media = (float)acum / NCOL;
					
					if(media<25)
						cmenor25++;
					else if(media<50)
							c25_49++;
						else if(media<75)
							c50_75++;
					else cmas75++;
					
				}
				
				System.out.println("menor 25 " +cmenor25);
				System.out.println("menor 50 " +c25_49);	
				System.out.println("menor 75 " +c50_75);	
				System.out.println("mayores 75 " +cmas75);	
				
					
					
					
						
					
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		FileOutputStream fo;
		try {
			fo = new FileOutputStream("result808.dat");
			DataOutputStream datOut = new DataOutputStream(fo); 
			int cont=0;
			
			for(int f =0; f<NFIL;f++) {
				for(int c =0; c<NCOL;c++) {
					if(matriz[f][c]>85) {
						System.out.println(matriz[f][c]);
						datOut.writeInt(matriz[f][c]);
						cont++;
					}
				}
				}
			
			System.out.println("Se han grabado "+ cont + "notas");
			
			datOut.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		

	}

}
