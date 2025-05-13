package Intermedios;
/*Calculadora simple

Pedir dos números y una operación (+, -, *, /) y mostrar el resultado. */
public class Ejercicio10 {
    public static void main(String[] args) {
        int n1 = 2, n2 = 4;
        char operador = '+';

        switch (operador) {
            case '+':
                System.out.println(n1 + n2);
                break;
            case '-':
                System.out.println(n1 - n2);
                break;
            case '*':
                System.out.println(n1 * n2);
                break;
            case '/':
                if (n2 != 0) {
                    System.out.println(n1 / n2);
                } else {
                    System.out.println("Error: división por cero");
                }
                break;
            default:
                System.out.println("Operador no válido");
        }
    }
}
