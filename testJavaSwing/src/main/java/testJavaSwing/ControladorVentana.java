package testJavaSwing;

import java.awt.*;
import java.util.Random;

public class ControladorVentana {

    private VentanaPrincipal ventana;
    private Random random;

    public ControladorVentana(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.random = new Random();
    }

    public void cambiarColorFondo() {
        Color colorAleatorio = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        ventana.getPanelPrincipal().setBackground(colorAleatorio);
    }

    public void redimensionarVentana() {
        ventana.setSize(VentanaPrincipal.ANCHO_PREDETERMINADO, VentanaPrincipal.ALTO_PREDETERMINADO);
    }

    public void restaurarVentana() {
        ventana.setSize(VentanaPrincipal.ANCHO_INICIAL, VentanaPrincipal.ALTO_INICIAL);
    }
}
