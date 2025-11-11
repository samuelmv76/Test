package testJavaSwing;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public static final int ANCHO_INICIAL = 400;
    public static final int ALTO_INICIAL = 300;
    public static final int ANCHO_PREDETERMINADO = 600;
    public static final int ALTO_PREDETERMINADO = 400;

    private JPanel panelPrincipal;
    private JButton btnColorFondo;
    private JButton btnRedimensionar;
    private JButton btnRestaurar;

    private ControladorVentana controlador;

    public VentanaPrincipal() {
        super("Interfaz Gráfica - Ejemplo con Swing");

        inicializarComponentes();
        configurarVentana();

        controlador = new ControladorVentana(this);
        agregarEventos();
    }

    private void inicializarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelPrincipal.setBackground(Color.LIGHT_GRAY);

        btnColorFondo = new JButton("Cambiar color de fondo");
        btnRedimensionar = new JButton("Redimensionar ventana");
        btnRestaurar = new JButton("Restaurar tamaño original");

        panelPrincipal.add(btnColorFondo);
        panelPrincipal.add(btnRedimensionar);
        panelPrincipal.add(btnRestaurar);

        add(panelPrincipal);
    }

    private void configurarVentana() {
        setSize(ANCHO_INICIAL, ALTO_INICIAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void agregarEventos() {
        btnColorFondo.addActionListener(e -> controlador.cambiarColorFondo());
        btnRedimensionar.addActionListener(e -> controlador.redimensionarVentana());
        btnRestaurar.addActionListener(e -> controlador.restaurarVentana());
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
