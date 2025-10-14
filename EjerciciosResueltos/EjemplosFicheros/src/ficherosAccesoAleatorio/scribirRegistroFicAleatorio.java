package ficherosAccesoAleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class scribirRegistroFicAleatorio {
	static final int TAM_REG =36; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		escribir(2);
		leer(2);
		

	}
	
	private static void escribir() {
		
		String apellidos[] = {"Ramirez","Diaz","Lopez","Suarez"};
		int dep[] = {10,10,15,20};
		Double sal [] = {1500.0,23000.0,35000.0,40000.0};
		StringBuffer buff =null;
		
		
		try {
			RandomAccessFile rm = new RandomAccessFile("trabajadores.dat", "rw");
			
			for(int i=0; i<4;i++) {
				rm.writeInt(i+1);
				buff = new StringBuffer(apellidos[i]);
				buff.setLength(10);
				rm.writeChars(buff.toString());
				rm.writeInt(dep[i]);
				rm.writeDouble(sal[i]);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void leer(int pos) {
		
		int id,dep;
		Double sal;
		char[] apellido = new char[10];
		
		
		try {
			RandomAccessFile rm = new RandomAccessFile("trabajadores.dat", "r");
			
			if(rm.getFilePointer()>=rm.length()) {
				System.out.println("Error ");
				
			}
			else {
				rm.seek((pos-1)*TAM_REG);
				
				id = rm.readInt();
				
				for(int i = 0; i<10;i++) {
					apellido[i]= rm.readChar();
				}
				
				dep = rm.readInt();
				sal = rm.readDouble();
				
				System.out.println("ID: "+ id+ " apellido: "+ new String (apellido) +"Departamento: "+ dep+ " Salario: "+ sal);
								
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
private static void escribir(int pos) {
		
	StringBuffer buff =null;
		
		
		try {
			RandomAccessFile rm = new RandomAccessFile("trabajadores.dat", "rw");
			rm.seek((pos-1)*TAM_REG);
			
			if(rm.getFilePointer()>=rm.length()) {
				System.out.println("Error ");
				
			}
			else {
				
				rm.writeInt(pos);
				buff = new StringBuffer(new String("Perez"));
				buff.setLength(10);
				rm.writeChars(buff.toString());
				rm.writeInt(10);
				rm.writeDouble(34000.0);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void leer() {
		
		int id,dep,pos=0;
		Double sal;
		char[] apellido = new char[10];
		
		
		try {
			RandomAccessFile rm = new RandomAccessFile("trabajadores.dat", "r");
			while(rm.getFilePointer()<rm.length()) {
				rm.seek(pos);
				
				id = rm.readInt();
				
				for(int i = 0; i<10;i++) {
					apellido[i]= rm.readChar();
				}
				
				dep = rm.readInt();
				sal = rm.readDouble();
				
				System.out.println("ID: "+ id+ " apellido: "+ new String (apellido) +"Departamento: "+ dep+ " Salario: "+ sal);
				
				
				pos =pos + TAM_REG;
				
				
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
