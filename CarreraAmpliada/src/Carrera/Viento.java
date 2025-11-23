package Carrera;

public class Viento extends Thread {

    private static volatile boolean hayViento = false;
    //volatile se pone para que la variable se pueda usar bien entre hilos, para que sea inmediato los cambios
    private Thread liebreThread;

    public void registrarLiebre(Thread t) {
        this.liebreThread = t;
    }

    @Override
    public void run() {
        while (true) {

            hayViento = Math.random() < 0.25;//esto genera un boolean si es menor de 0.25 true al reves false

            System.out.println("Viento = " + hayViento);

           //si hay viento se despierta a la liebre
            if (hayViento && liebreThread != null) {
                liebreThread.interrupt();
            }

            try {
                Thread.sleep(10000); //viento aleatorio cada 10s
            } catch (InterruptedException e) {
            	
            }
        }
    }

    public static boolean hayViento() {
        return hayViento;
    }
}
