package Intermedios;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número límite: ");
        int n = scanner.nextInt();

        int a = 0, b = 1;

        System.out.print("Serie de Fibonacci hasta " + n + ": ");

        while (0 <= n){
            System.out.println(a + " "); //0 1 1 2 3 5 13 21...
            int siguiente = a + b; // 1 2 3 5 8 13 21
            a = b; // 1 1 2 3 5 8 13 
            b = siguiente; //1 2 3 5 8 13 21
        }

        scanner.close();
    }
}
