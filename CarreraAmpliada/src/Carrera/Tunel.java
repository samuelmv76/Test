package Carrera;

public class Tunel {
    private boolean ocupado = false;

    public synchronized void entrar(String nombre) {
        while (ocupado) {
            try {
                wait();
            } catch (InterruptedException e) {
                //o pongo esta exception o peta
                System.out.println(nombre + " fue interrumpido, pero sigue esperando el túnel");
            }
        }
        ocupado = true;
    }


    public synchronized void salir(String nombre) {
        ocupado = false;
        System.out.println(nombre + " SALE del túnel");
        notify();
    }
}
