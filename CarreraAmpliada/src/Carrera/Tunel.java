package Carrera;

public class Tunel {
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
        System.out.println(nombreAnimal + " ha entrado en el túnel.");
    }

    public synchronized void salir(String nombreAnimal) {
        ocupado = false;
        System.out.println(nombreAnimal + " ha salido del túnel.");
        notify(); 
    }
}
