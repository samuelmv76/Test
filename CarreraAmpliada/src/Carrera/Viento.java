package Carrera;

public class Viento extends Thread {

    private static volatile boolean hayViento = false;
    
    public static boolean hayViento() {
        return hayViento;
    }

    //volatile se pone para que la variable se pueda usar bien entre hilos, para que sea inmediato los cambios
    private Thread liebreThread;

    public void registrarLiebre(Thread t) {
        this.liebreThread = t;
    }

    @Override
    public void run() {
        while (!Carrera.carreraTerminada) {
            hayViento = Math.random() < 0.25;
            System.out.println("Viento = " + hayViento);

            if (hayViento && liebreThread != null) {
                liebreThread.interrupt();
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
        }
    }

}
