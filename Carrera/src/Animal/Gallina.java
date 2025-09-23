package Animal;

import java.util.Random;

public class Gallina extends Animal{

	public Gallina(int velocidad, String nombre) {
		super(velocidad, nombre);
		// Gallina random de 3, correr+5, o volar+15, o poner un huevo (nada)
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//System.out.println("Esta es una ejecucion de "+this.nombre);
			System.out.println("");
			try {
				
				Random rm = new Random();
				int rand = rm.nextInt(1,4);/* random del 1 al 3 */
				/* si toca 1 correr 5, si toca 2 volar 115, si toca 3 nada*/
				correr(rand);
				
				Thread.sleep(1000);//1 sesgundo
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void correr(int rand) {
		
		switch(rand) {
		  case 1: 
			  this.distancia += 5;
			break;
		  case 2:
			  this.distancia += 15;
		  	break;
		  case 3:
			  System.out.println("La gallina pone un huevo");
		  	break;
		}
		
		this.decirPosicion();
	}
}
