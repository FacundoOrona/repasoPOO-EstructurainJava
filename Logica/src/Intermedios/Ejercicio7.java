package Intermedios;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un texto: ");
        String texto = scanner.nextLine();

        String invertido = "";

        for (int i = texto.length() - 1; i >= 0; i--){
            invertido += texto.charAt(i);
        }

        System.out.println(invertido);

        scanner.close();

    }
}
