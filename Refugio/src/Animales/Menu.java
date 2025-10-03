package Animales;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {	
		/*
		Menú
			1. Añadir Animal
			2. Mostrar datos de todos los animales del refugio
			0. Salir
			
		*/
		 ArrayList<Animal> animales = new ArrayList<Animal>();
		 Scanner sc =new Scanner(System.in);
		 animales.add(new Gato("luna",3,2));
		 animales.add(new Perro("tobi",2,"border collie"));
		 
		 int opcion;
		 
		 do {
			 System.out.println("Menú\r\n"
				 		+ " 1. Añadir Animal\r\n"
				 		+ " 2. Mostrar datos de todos los animales del refugio\r\n"
				 		+ " 0. Salir");
				 opcion = sc.nextInt();
				 
			 switch(opcion) {
			 case 1:
				    System.out.println("¿Qué tipo de animal quieres añadir? (1: Gato, 2: Perro)");
				    int tipo = sc.nextInt();
				    sc.nextLine(); //limpiar buffer

				    if(tipo == 1) {
				        System.out.println("Introduce el nombre del gato:");
				        String nombreGato = sc.nextLine();
				        System.out.println("Introduce la edad del gato:");
				        int edadGato = sc.nextInt();
				        System.out.println("Introduce el numero de vidas del gato:");
				        int vidasGato = sc.nextInt();
				        sc.nextLine(); //limpiar buffer
				        
				        animales.add(new Gato(nombreGato, edadGato, vidasGato));
				        System.out.println("Gato añadido correctamente.");
				    } else if(tipo == 2) {
				        System.out.println("Introduce el nombre del perro:");
				        String nombrePerro = sc.nextLine();
				        System.out.println("Introduce la edad del perro:");
				        int edadPerro = sc.nextInt();
				        sc.nextLine(); //limpiar buffer
				        System.out.println("Introduce la raza del perro:");
				        String razaPerro = sc.nextLine();
				        
				        animales.add(new Perro(nombrePerro, edadPerro, razaPerro));
				        System.out.println("Perro añadido correctamente.");
				    } else {
				        System.out.println("Opcion no valida.");
				    }
				    break;

			  case 2:
					for(int i=0; i<animales.size();i++) {
						animales.get(i).mostrarDatos();
					}	
				  break;
			 }
			 
		 }while(opcion != 0);

	}

}
