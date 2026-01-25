package Ejercicio5;

import javax.swing.JOptionPane;

public class Ejercicio5 {

    public static void main(String[] args) {

        double c1 = solicitarCapacitor("Ingrese el valor del capacitor 1 (µF):");
        double c2 = solicitarCapacitor("Ingrese el valor del capacitor 2 (µF):");
        double c3 = solicitarCapacitor("Ingrese el valor del capacitor 3 (µF):");

        if (!datosValidos(c1, c2, c3)) {
            JOptionPane.showMessageDialog(null,
                    "No ingresó un valor apropiado.\nEl programa finalizará.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double serie = calcularSerie(c1, c2, c3);
        double paralelo = calcularParalelo(c1, c2, c3);

        mostrarResultados(c1, c2, c3, serie, paralelo);
    }

    // ===== ENTRADA =====
    public static double solicitarCapacitor(String mensaje) {
        String valor = JOptionPane.showInputDialog(mensaje);

        if (valor == null || valor.trim().isEmpty()) {
            return -1;
        }

        return Double.parseDouble(valor);
    }

    // ===== VALIDACIÓN =====
    public static boolean datosValidos(double c1, double c2, double c3) {
        return c1 > 0 && c2 > 0 && c3 > 0;
    }

    // ===== CÁLCULOS =====
    public static double calcularSerie(double c1, double c2, double c3) {
        return 1 / ((1 / c1) + (1 / c2) + (1 / c3));
    }

    public static double calcularParalelo(double c1, double c2, double c3) {
        return c1 + c2 + c3;
    }

    // ===== SALIDA =====
    public static void mostrarResultados(double c1, double c2, double c3,
                                         double serie, double paralelo) {

        System.out.println("--- CAPACITORES INGRESADOS ---");
        System.out.println("C1 = " + c1 + " µF");
        System.out.println("C2 = " + c2 + " µF");
        System.out.println("C3 = " + c3 + " µF");

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Capacitor equivalente en SERIE: " + serie + " µF");
        System.out.println("Capacitor equivalente en PARALELO: " + paralelo + " µF");
    }
}
