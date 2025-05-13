package zAvanzados;
/*Número perfecto

Ver si un número es perfecto (igual a la suma de sus divisores propios positivos). */
public class Ejercicio13 {
    public static void main(String[] args) {
        int n = 20;
        int acu = 0;

        for(int i = 1; i < n; i++){
            if(n % i == 0){
                acu+=i;
            }
        }

        if(n == acu){
            System.err.println("El numero es perfecto");
        }else{
            System.out.println("El numero no es perfecto");
        }

    }
    
}
