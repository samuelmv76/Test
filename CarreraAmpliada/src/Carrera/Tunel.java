package Carrera;

public class Tunel {
    private boolean ocupado = false;

    public synchronized void entrar(String nombre) throws InterruptedException {
        while (ocupado) {
            System.out.println(nombre + " espera, el túnel está ocupado...");
            wait();
        }

        ocupado = true;
        System.out.println(nombre + " ENTRA al túnel");
    }

    public synchronized void salir(String nombre) {
        ocupado = false;
        System.out.println(nombre + " SALE del túnel");
        notify();
    }
}
