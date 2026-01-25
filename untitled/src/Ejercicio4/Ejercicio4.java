package Ejercicio4;
import javax.swing.JOptionPane;

public class Ejercicio4 {
    public static void main(String[] args) {
        String primernumero;
        String segundonumero;
        int numero1, numero2;
        int suma;

        primernumero = JOptionPane.showInputDialog("Digite el primer numero");
        segundonumero = JOptionPane.showInputDialog("Digite el segundo numero");

        numero1 = Integer.parseInt(primernumero);
        numero2 = Integer.parseInt(segundonumero);

        if (numero1 < 0 || numero2 < 0) {
            JOptionPane.showMessageDialog(null,
                    "No se pueden ingresar números negativos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        suma = numero1 + numero2;

        JOptionPane.showMessageDialog(null, "La suma es: " + suma,
                "Resultado", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);
    }
}