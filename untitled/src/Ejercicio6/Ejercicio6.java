package Ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

    // Constante permitida
    public static final double DENSIDAD_GASOLINA = 750.0; // kg/m³

    public static void main(String[] args) {

        double radio = solicitarRadio();
        double altura = solicitarAltura();

        double dieselLitros = calcularDieselLitros(radio, altura);
        double gasolinaKg = calcularGasolinaKg(radio, altura);

        imprimirResultados(dieselLitros, gasolinaKg);
    }

    // ===== MÉTODOS DE ENTRADA =====

    public static double solicitarRadio() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el radio del tanque (m): ");
        return sc.nextDouble();
    }

    public static double solicitarAltura() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la altura del tanque (m): ");
        return sc.nextDouble();
    }

    // ===== MÉTODOS DE CÁLCULO =====

    public static double calcularDieselLitros(double r, double h) {
        double volumenM3 = Math.PI * r * r * h;
        return volumenM3 * 1000; // Litros
    }

    public static double calcularGasolinaKg(double r, double h) {
        double volumenM3 = Math.PI * r * r * h;
        return volumenM3 * DENSIDAD_GASOLINA; // kg
    }

    // ===== MÉTODO DE SALIDA =====

    public static void imprimirResultados(double diesel, double gasolina) {
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Volumen máximo de Diesel: " + diesel + " Litros");
        System.out.println("Cantidad límite de Gasolina: " + gasolina + " Kilogramos");
    }
}
