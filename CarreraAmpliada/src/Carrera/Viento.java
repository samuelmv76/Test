package Carrera;

import java.util.Random;

public class Viento {
	
	public boolean v = false;
	// IMPORTANTE HACER QUE LA RACHA DE VIENTO SEA CADA x SEGUNDOS
	
	// hacer que se despierte la liebre
	
	public boolean isV() {
		return v;
	}

	public void setV(boolean v) {
		this.v = v;
	}

	public boolean generarViento() {
		
		//funcion para crear el viento con un random, despues hacer que el viento retorne si hay viento o no
		Random rand = new Random(1);
		int r =rand.nextInt(4)+1;//numero del uno al 4
		
		//1 es igual a que hay viento 

		if (r==1) {
			setV(true);
		} else {
			setV(false);
		}
		
		return v;
	}

}
