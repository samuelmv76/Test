package Caja;

import java.text.DecimalFormat;

class Caja {
    private double total = 0;
    
    DecimalFormat df = new DecimalFormat("0.00");
    
    public synchronized void cobrar(double cantidad, String empleado) {
        total += cantidad;
        System.out.println("Empleado "+empleado+" cobro "+df.format(cantidad)+"€. Total en caja: "+df.format(total)+"€");
        
    }

    public double getTotal() {
        return total;
    }
    
    public void cobrartest(double cantidad, String empleado) {
        total += cantidad;
        System.out.println("Empleado "+empleado+" cobro "+df.format(cantidad)+"€. Total en caja: "+df.format(total)+"€");
    }
}