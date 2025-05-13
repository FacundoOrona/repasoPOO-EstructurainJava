package Ciclos;

import java.util.Scanner;

/*🔁 Ejercicio con do while
🔸 Menú interactivo

Creá un menú de opciones que se muestre al menos una vez y se repita hasta que el usuario elija “Salir”. */
public class ejerciciodowhile {
    public static void main(String[] args) {
        String opc = " ";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Ingrese una opcion");
            System.out.println("a - saludar");
            System.out.println("b - presentarse");
            System.out.println("c - salir del programa");

            opc = scanner.nextLine();
            switch (opc) {
                case "a":
                    System.out.println("Hola");
                    break;
                case "b":
                    System.out.println("Hola me presento");
                    break;
                case "c":
                    System.out.println("Usted ha salido del programa");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }

        } while (!opc.equals("c"));

        scanner.close();
    }
}
