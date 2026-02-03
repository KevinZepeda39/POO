package Ejemplo3Guia2;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Ejemplo3 {

    // ================= EJEMPLO 6 =================
    static HashMap<String, String> libros = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ejemplo6(); // biblioteca
    }

    // ================= EJEMPLO 3 =================
    static void ejemplo3() {
        int result = JOptionPane.showConfirmDialog(null, "Replace existing selection?");

        System.out.println("El numero devuelto por showConfirmDialog es: " + result);

        switch (result) {
            case JOptionPane.YES_OPTION:
                System.out.println("Yes");
                break;
            case JOptionPane.NO_OPTION:
                System.out.println("No");
                break;
            case JOptionPane.CANCEL_OPTION:
                System.out.println("Cancel");
                break;
            case JOptionPane.CLOSED_OPTION:
                System.out.println("Closed");
                break;
        }
    }

    // ================= EJEMPLO 4 =================
    static void ejemplo4() {
        try {
            double a = 1, b = -2, c = 5;

            if (a == 0)
                throw new ArithmeticException("No es ecuación cuadrática");

            double d = calcularDeterminante(a, b, c);
            System.out.println("\nDeterminante: " + d);

            if (d > 0) {
                System.out.println("Raices reales");
            } else if (d == 0) {
                System.out.println("Raiz unica");
            } else {
                System.out.println("Raices complejas");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static double calcularDeterminante(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }

    // ================= EJEMPLO 5 =================
    static void ejemplo5(String nombreCliente, double montoCompra) {

        Random r = new Random();
        int bolita = r.nextInt(4);

        double descuento = 0;
        String color = "";

        switch (bolita) {
            case 0:
                color = "Café";
                descuento = 0.10;
                break;
            case 1:
                color = "Roja";
                descuento = 0.15;
                break;
            case 2:
                color = "Azul";
                descuento = 0.25;
                break;
            case 3:
                color = "Verde";
                descuento = 0.50;
                break;
        }

        System.out.println("\nCliente: " + nombreCliente);
        System.out.println("Bolita: " + color);
        System.out.println("Total a pagar: $" + (montoCompra - (montoCompra * descuento)));
    }

    // ================= EJEMPLO 6 =================
    static void ejemplo6() {
        int opcion;

        do {
            System.out.println("\n=== MENU BIBLIOTECA ===");
            System.out.println("1. Registrar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Finalizar");
            System.out.print("Opcion: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    leerLibros();
                    break;
                case 3:
                    actualizarLibro();
                    break;
                case 4:
                    eliminarLibro();
                    break;
                case 5:
                    System.out.println("Regresando al programa principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);
    }

    static void crearLibro() {
        String isbn = solicitarISBN();
        if (isbn == null) return;

        if (libros.containsKey(isbn)) {
            System.out.println("El ISBN ya existe.");
            return;
        }

        System.out.print("Titulo del libro: ");
        String titulo = sc.nextLine();
        libros.put(isbn, titulo);
        System.out.println("Libro registrado.");
    }

    static void leerLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros.");
            return;
        }

        for (Map.Entry<String, String> l : libros.entrySet()) {
            System.out.println("ISBN: " + l.getKey() + " | Titulo: " + l.getValue());
        }
    }

    static void actualizarLibro() {
        String isbn = solicitarISBN();
        if (isbn == null) return;

        if (!libros.containsKey(isbn)) {
            System.out.println("No existe ese ISBN.");
            return;
        }

        System.out.print("Nuevo titulo: ");
        libros.put(isbn, sc.nextLine());
        System.out.println("Libro actualizado.");
    }

    static void eliminarLibro() {
        String isbn = solicitarISBN();
        if (isbn == null) return;

        if (libros.remove(isbn) != null)
            System.out.println("Libro eliminado.");
        else
            System.out.println("ISBN no encontrado.");
    }

    static String solicitarISBN() {
        int intentos = 0;
        String regex = "^(\\d{10}|\\d{13})$";

        while (intentos < 3) {
            System.out.print("Ingrese ISBN (10 o 13 digitos): ");
            String isbn = sc.nextLine();

            if (isbn.matches(regex))
                return isbn;

            intentos++;
            System.out.println("ISBN invalido (" + intentos + "/3)");
        }

        System.out.println("Operacion cancelada.");
        return null;
    }

    static int leerEntero() {
        while (!sc.hasNextInt()) {
            System.out.println("Debe ingresar un numero.");
            sc.next();
        }
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }
}
