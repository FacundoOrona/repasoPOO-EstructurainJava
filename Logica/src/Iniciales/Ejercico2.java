package Iniciales;

/*Mayor de tres números

Pedir 3 números y mostrar cuál es el mayor. */
public class Ejercico2 {
     public static void main(String[] args) {
        int n1 = 4, n2 = 2, n3 = 6;

        if (n1 > n2 && n1 > n3) {
            System.out.println(n1 + " es el mayor");
        } else if (n2 > n1 && n2 > n3) {
            System.out.println(n2 + " es el mayor");
        } else {
            System.out.println(n3 + " es el mayor");
        }
    }
}
