
public class Contador {
	private int valor = 0;
	public synchronized void incrementar() {
		this.valor++;
	}
	public int getValor() {
		return this.valor;
	}
	
}
