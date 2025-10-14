package ficherosAccesoAleatorio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class AccesoAleatorioFichero {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		File f = new File("datosEnteros.dat");
		// TODO Auto-generated method stub
		System.out.println("Dame la posicion a escribir: ");
		int pos = sc.nextInt();
		leerDatosPos(pos,f);
	}
	
	
	static private void escribirDatosPos(int pos, File f) {
		
		try {
			RandomAccessFile file = new RandomAccessFile(f, "rw");
			file.seek(2*(pos-1));
			System.out.println("Dame un entero");
			int  num= sc.nextInt();
			file.writeInt(num);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	static private void leerDatosPos(int pos, File f) {
		
		
		RandomAccessFile file;
		int num = 0;
		try {
			file = new RandomAccessFile(f, "r");
			file.seek(2*(pos-1));
			num= file.readInt();
			System.out.println(num);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
