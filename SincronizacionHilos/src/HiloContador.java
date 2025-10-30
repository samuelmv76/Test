
public class HiloContador extends Thread {
	private Contador contador;
	
	public HiloContador(Contador c) {
		this.contador = c;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			this.contador.incrementar();
		}
	}

}
