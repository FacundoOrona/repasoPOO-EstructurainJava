package zAvanzados;
import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int saldo = 5000;
        char opcion;

        do {
            System.out.println("\nElija una opción:");
            System.out.println("a - Mostrar saldo");
            System.out.println("b - Extraer dinero");
            System.out.println("c - Ingresar dinero");
            System.out.println("d - Salir");
            System.out.print("Opción: ");
            opcion = scanner.next().charAt(0);

            switch (opcion) {
                case 'a':
                    System.out.println("El saldo es de $" + saldo);
                    break;
                case 'b':
                    System.out.print("Ingrese un monto a extraer: ");
                    int extraccion = scanner.nextInt();
                    if (extraccion <= saldo) {
                        saldo -= extraccion;
                        System.out.println("Usted ha retirado $" + extraccion);
                        System.out.println("Saldo actual: $" + saldo);
                    } else {
                        System.out.println("Fondos insuficientes.");
                    }
                    break;
                case 'c':
                    System.out.print("Ingrese el monto a ingresar: ");
                    int ingreso = scanner.nextInt();
                    saldo += ingreso;
                    System.out.println("Usted ha ingresado $" + ingreso);
                    System.out.println("Saldo actual: $" + saldo);
                    break;
                case 'd':
                    System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 'd');

        scanner.close();
    }
}
