package Intermedios;
/*Números primos

Ingresar un número y decir si es primo. */
public class Ejercicio6 {
    public static void main(String[] args) {
        int n = 7;

        if (esPrimo(n)){
            System.out.println(n + " es primo");
        } else {
            System.out.println(n + " no es primo");
        }
    }

    public static boolean esPrimo(int n){
    if (n <= 1) return false; // 1 no es primo
    if (n == 2) return true; // 2 es primo

    for(int i = 2; i <= n-1; i++){ //Recorro desde 2 hasta el mismo numero ingresado, y consulto si por cada vuelta que i ++ el operador resto es 0
        if (n % i == 0) {
            return false;
        }
    }

    return true;
    }

}


