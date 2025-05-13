package Iniciales;
/*Suma de números hasta N

Ingresar un número n y mostrar la suma de todos los números desde 1 hasta n. */
public class Ejercicio4 {
    public static void main(String[] args) {
        int n = 5;
        int acu = 0;

        for( int i = 0; i <= n; i++){
            acu+=i;
        }

        System.out.println("Total acumulado : "+acu);

    }
    
}
