package Caja;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Caja caja = new Caja();

        Thread ana = new Thread(new Empleado(caja, "Ana"));
        Thread luis = new Thread(new Empleado(caja, "Luis"));
        Thread maria = new Thread(new Empleado(caja, "María"));
        DecimalFormat df = new DecimalFormat("0.00");
        ana.start();
        luis.start();
        maria.start();

        try {
            ana.join();
            luis.join();
            maria.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("TOTAL FINAL EN CAJA: "+df.format(caja.getTotal())+"€");
    }
}