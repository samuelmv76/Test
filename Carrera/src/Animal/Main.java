package Animal;


public class Main {

	public static void main(String[] args) {
		
		Animal liebre = new Liebre(5,"liebre"); 
		Animal gallina = new Gallina(3,"gallina"); 
		Animal tortuga = new Tortuga(1,"mbappe");
		
		Thread hilo1 = new Thread(liebre);
		Thread hilo2 = new Thread(gallina);
		Thread hilo3 = new Thread(tortuga);
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
	}

}
