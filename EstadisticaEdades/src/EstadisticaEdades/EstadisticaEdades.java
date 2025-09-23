package EstadisticaEdades;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class EstadisticaEdades {
    public static void main(String[] args) {
        String fichero = "entrada801.dat";

        int contador = 0;
        int suma = 0;
        int menor =100;
        int mayor =0;
        int menoresDeEdad = 0;

        int[] edades = new int[1000];

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fichero))) {
            while (true) {
                int edad = dis.readInt();
                edades[contador] = edad;
                contador++;

                suma += edad;
                if (edad < menor) menor = edad;
                if (edad > mayor) mayor = edad;
                if (edad < 18) menoresDeEdad++;
            }
        } catch (EOFException e) {

        } catch (IOException e) {
            System.out.println("Error leyendo el fichero: " + e.getMessage());
            return;
        }

        if (contador == 0) {
            System.out.println("No hay datos para procesar.");
            return;
        }

        double media = (double) suma / contador;

        double sumaDiferencias = 0;
        for (int i = 0; i < contador; i++) {
            double diff = edades[i] - media;
            sumaDiferencias += diff * diff;
        }
        double desviacion = Math.sqrt(sumaDiferencias / contador);

        System.out.println("Número de alumnos procesados: " + contador);
        System.out.println("Media aritmética de las edades: "+ media);
        System.out.println("Edad del alumno/a más joven: " + menor);
        System.out.println("Edad del alumno/a más viejo: " + mayor);
        System.out.println("Número de alumnos/as menores de edad: " + menoresDeEdad);
        System.out.println("Desviación estándar de las edades: "+ desviacion);
    }
}
