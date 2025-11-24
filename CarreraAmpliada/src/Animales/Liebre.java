package Animales;

import java.util.Random;
import Carrera.*;

public class Liebre extends Animal { 

    private Random rand = new Random();
    

    public Liebre(String nombre, int velocidadBase, Tunel tunel, Viento viento) {
        super(nombre, velocidadBase, tunel, viento); 
    }



	@Override
    public void run() {

		while (getPosicion() < Carrera.META && !Carrera.carreraTerminada) {
            
            int avance = getVelocidad(); 

            //viento
            if (Viento.hayViento()) {
                avance /= 2;
                System.out.println(getNombre() + " avanza con dificultad por viento");
            }

            //charco
            if (rand.nextDouble() < 0.1) {
                System.out.println(getNombre() + " piso un charco y se resbala!");
                avance = 0;
            }

            //tunel 50 a 150m
            if (getPosicion() >= 50 && getPosicion() < 150) {
                
                tunel.entrar(getNombre());

                while (getPosicion() < 150 && !Carrera.carreraTerminada) {
                    
                    int avanceTunel = getVelocidad() > 0 ? getVelocidad() : 1; 
                    
                    int nuevaPosicion = getPosicion() + avanceTunel;
                    setPosicion(nuevaPosicion); 

                    System.out.println(getNombre() + " DENTRO DEL TÚNEL: " + getPosicion() + " m");
                    try { Thread.sleep(500); } catch (InterruptedException e) {}
                }
                
                if (Carrera.carreraTerminada && getPosicion() < 150) {
                    setPosicion(150);
                    System.out.println(getNombre() + " FORZADO a salir del túnel a 150m por fin de carrera.");
                }

                tunel.salir(getNombre());
            } else {
                // fuera del tunel
                int nuevaPosicion = getPosicion() + avance;
                setPosicion(nuevaPosicion);
            }

            System.out.println(getNombre() + " avanza: " + getPosicion() + " m");

            if (getPosicion() >= Carrera.META) {
                Carrera.carreraTerminada = true;
                System.out.println("Carrera terminada para: " + getNombre());
                break;
            }

            try {
                //dormir
                if (rand.nextDouble() < 0.2) {
                    System.out.println(getNombre() + " durmiendo 5s...");
                    Thread.sleep(5000);
                } else {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(getNombre() + " DESPERTO por el viento!");
            }
        }
    }
}