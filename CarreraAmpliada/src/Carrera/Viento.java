package Carrera;

import java.util.Random;

public class Viento {
	
	
	// IMPORTANTE HACER QUE LA RACHA DE VIENTO SEA CADA x SEGUNDOS
	
	// hacer que se despierte la liebre
	
	
	public boolean rachaViento() {
		//funcion para crear el viento con un random, despues hacer que el viento retorne si hay viento o no
		Random rand = new Random(1);
		int r =rand.nextInt(4)+1;//numero del uno al 4
		//1 es igual a que hay viento 
		boolean v=false;
		if (r==1) {
			v=true;
		} else {
			v=false;
		}
		return v;
	}

}
