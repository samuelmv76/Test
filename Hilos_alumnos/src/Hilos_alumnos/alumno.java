package Hilos_alumnos;

public class alumno implements Runnable{
	private String nombre;
	private String mensaje;

	public alumno(String nombre) {
		super();
		this.nombre = nombre;
		this.mensaje = "Hola soy "+nombre+" y este es mi mensaje número";
		//System.out.println("Hola soy "+this.nombre+" y este es mi mensaje número");
	}
	
	//String mensaje = "Hola soy "+this.nombre+" y este es mi mensaje número";

	@Override
	public void run() {
	    for (int i = 1; i <= 5; i++) {
	        
	    	//String mensaje = "Hola soy " + this.nombre + " y este es mi mensaje número";
	        //System.out.println(mensaje + " " + i);
	        
	        if (Thread.currentThread().isInterrupted()) {
	        	System.out.println(nombre+" ha sido interrumpido.");
	        	return;
	        }
	        if (nombre.toLowerCase().contains("m")) {
	        	System.out.println("Mira que ser yo "+nombre+" ... pues me cierro.");
	        	return;
	        }
	        System.out.println(mensaje + i);
	        try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            System.err.println("El hilo fue interrumpido.");
	            Thread.currentThread().interrupt();
	        }
	    }
	}

}
