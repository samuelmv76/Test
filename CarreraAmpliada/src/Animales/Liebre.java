package Animales;

import Carrera.Tunel;
import Carrera.Viento;

public class Liebre extends Animal implements Runnable {

    private Viento viento;

    public Liebre(String nombre, int posicion, int velocidad, Tunel tunel, Viento viento) {
        super(nombre, posicion, velocidad, tunel, viento);
        this.viento = viento;
    }

    @Override
    public void run() {
        int posicionaux = getPosicion();
        int contadorDormir = 0;
        //primeros 50m antes del tunel
        while (posicionaux < 50) {

            if (contadorDormir == 4) {
                System.out.println(getNombre() + " durmiendo 5s...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("¡" + getNombre() + " DESPERTADA por el viento!");
                }
                contadorDormir = 0;
            }

            //viento
            if (Viento.hayViento()) {
                System.out.println(getNombre() + " avanza con dificultad por viento");
            } else {
                System.out.println(getNombre() + " avanza normal");
            }

            //charcos
            if (posicionaux % 10 == 0 && posicionaux != 0) {
                System.out.println(getNombre() + " piso un charco y se resbala!");
                try {
                    Thread.sleep(5000); //pierde 5s
                } catch (InterruptedException e) {
                    System.out.println("¡" + getNombre() + " DESPERTADA por el viento!");
                }
                posicionaux += getVelocidad();
            } else {
                posicionaux += getVelocidad();
            }

            setPosicion(posicionaux);
            System.out.println(getNombre() + " avanza a " + posicionaux + " m.");

            contadorDormir++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("¡" + getNombre() + " DESPERTO por el viento!");
            }
        }//fin de los 50m

        
        System.out.println(getNombre() + " ha llegado al túnel y espera su turno...");

		tunel.entrar(getNombre());
		
		//recorre el tunel (50 a 150 m)
		while ( getPosicion() < 150) {
			
			if( getPosicion()%10==0 ) {
				System.out.println(getNombre()+" piso un charco y corrio mas durante un segundo");
				
				
				posicionaux+=5;//por el charco
				setPosicion(posicionaux);
				System.out.println(getNombre() + " dentro del túnel: " + posicionaux + " m");
				System.out.println("--------");

				
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			} else {
				posicionaux++;
				setPosicion(posicionaux);
				System.out.println(getNombre() + " dentro del túnel: " + posicionaux + " m");

				
				
				try {
					Thread.sleep(1000/getVelocidad());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		tunel.salir(getNombre());
		
		//while para llegar al final de la carrera 300m
		while ( getPosicion() < 300 ) {
			
			if( getPosicion()%10==0 ) {
				System.out.println(getNombre()+" piso un charco y corrio mas durante un segundo");
				
				
				posicionaux+=5;//por el charco
				setPosicion(posicionaux);
				System.out.println(getNombre() + " avanza: " + posicionaux + " m");
				System.out.println("--------");

				
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			} else {
				posicionaux++;
				setPosicion(posicionaux);
				System.out.println(getNombre() + " avanza: " + posicionaux + " m");

				
				
				try {
					Thread.sleep(1000/getVelocidad());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		System.out.println("Carrear terminada para: "+getNombre() );
		

	}
}
