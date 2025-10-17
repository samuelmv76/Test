package Hilos_alumnos;

import java.util.Scanner;

public class menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el nombre del alumno 1");
        //String nom1 = sc.nextLine();
        System.out.println("Introduce el nombre del alumno 2");
        //String nom2 = sc.nextLine();
        System.out.println("Introduce el nombre del alumno 3");
        //String nom3 = sc.nextLine();
        String nom1="pepe";
        String nom2="juan";
        String nom3="manel";
        
        System.out.println(nom3.contains("m"));
        
        
        alumno al1 = new alumno(nom1);
        alumno al2 = new alumno(nom2);
        alumno al3 = new alumno(nom3);
        
        Thread hilo1 = new Thread(al1);
        Thread hilo2 = new Thread(al2);
        Thread hilo3 = new Thread(al3);
        
        try {
            hilo1.start();
            hilo1.join();  // Espera a que termine hilo1

            hilo2.start();
            hilo2.join();  // Espera a que termine hilo2

            hilo3.start();
            hilo3.join();  // Espera a que termine hilo3
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los hilos han terminado.");
    }
}
