package Animales;

import Carrera.Carrera;
import Carrera.Liana;


public class Mono extends Animal{

	
	public Mono(String nombre, int velocidad, Liana liana) {
		super(nombre, velocidad, liana);
	}



	@Override
	public void run() {
		
		 while (getPosicion() < Carrera.META && !Carrera.carreraTerminada) {
			 
			 int avance = getVelocidad();
			 
			 if( getPosicion() >=100 && getPosicion() < 150) {

				 liana.entrar(getNombre());
				 
				 
				 while(getPosicion() < 150 && !Carrera.carreraTerminada) {
					 
					 int avanzaLiana = getVelocidad() > 0 ? getVelocidad():1;
					 
					 int nuevaPosicion = getPosicion()+avanzaLiana;
					 setPosicion(nuevaPosicion);
					 
					 
					
					 System.out.println(getNombre() + " Mono en la lian a: " + getPosicion() + " m");
	                 try { Thread.sleep(500); } catch (InterruptedException e) {}
				 }
                 
                 
                 
                 if (Carrera.carreraTerminada) {
                     System.out.println(getNombre() + " FORZADO a salir de la liana por fin de carrera.");
                 }
                 liana.salir(getNombre());
				 
			 } else {
	                //fuera de la liana
	                int nuevaPosicion = getPosicion() + avance;
	                setPosicion(nuevaPosicion);
	         }//fin if else
			 
			 if( getPosicion() >=200 && getPosicion() < 250) {

				 liana.entrar(getNombre());
				 
				 
				 while(getPosicion() < 150 && !Carrera.carreraTerminada) {
					 
					 int avanzaLiana = getVelocidad() > 0 ? getVelocidad():1;
					 
					 int nuevaPosicion = getPosicion()+avanzaLiana;
					 setPosicion(nuevaPosicion);
					 
					 
					
					 System.out.println(getNombre() + " Mono en la lian a: " + getPosicion() + " m");
	                 try { Thread.sleep(500); } catch (InterruptedException e) {}
				 }
                 
                 
                 
                 if (Carrera.carreraTerminada) {
                     System.out.println(getNombre() + " FORZADO a salir de la liana por fin de carrera.");
                 }
                 liana.salir(getNombre());
				 
			 } else {
	                //fuera de la liana
	                int nuevaPosicion = getPosicion() + avance;
	                setPosicion(nuevaPosicion);
	         }//fin if else
			 
			 
			 
			 
			 
			 
	            System.out.println(getNombre() + " avanza: " + getPosicion() + " m");

	         
	            if (getPosicion() >= Carrera.META) {
	                Carrera.carreraTerminada = true;
	                System.out.println("Carrera terminada para: " + getNombre());
	                break;
	            }
			 
	            try { Thread.sleep(1000); } catch (InterruptedException e) {}
			 
			 
		 }//fin w
		
	}



	
	
}

//liana mono si hay 1 monos en la cuerda 
//velocidad 6 m/s

//solo un mono por liana y un mono por liana

