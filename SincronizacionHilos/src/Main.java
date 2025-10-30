
public class Main {

	public static void main(String[] args) {
		Contador contador = new Contador();
		
		HiloContador hilo1 = new HiloContador(contador);
		HiloContador hilo2 = new HiloContador(contador);
		
		hilo1.start();
		hilo2.start();
		
		try {
			hilo1.join();
			hilo2.join();
			System.out.println("Valor final del contador: " + contador.getValor());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
