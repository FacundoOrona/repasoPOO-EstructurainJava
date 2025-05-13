package Iniciales;

/*Par o impar

Ingresar un número y decir si es par o impar. */

public class Ejercicio1 {
    public static void main(String[] args) {
        int n = 6;

        if(n % 2 == 0){
            System.out.println(n + " es par");
        }
        else{
            System.out.println(n + " es impar");
        }
    }
}
