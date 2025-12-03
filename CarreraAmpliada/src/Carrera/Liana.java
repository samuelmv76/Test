package Carrera;

public class Liana {
	
    private boolean ocupado = false;

    public synchronized void entrar(String nombreAnimal) {
        while (ocupado) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ocupado = true;
        System.out.println(nombreAnimal + " ha entrado en la liana.");
    }

    public synchronized void salir(String nombreAnimal) {
        ocupado = false;
        System.out.println(nombreAnimal + " ha salido del liana.");
        notify(); 
    }
	
}
