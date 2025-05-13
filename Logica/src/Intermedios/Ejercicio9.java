package Intermedios;

/*Contar vocales

Contar cuántas vocales tiene una palabra ingresada. */
public class Ejercicio9 {
    public static void main(String[] args) {
        String cadena = "cadena";
        int acumulador = 0;

        for (int i = 0; i <= cadena.length(); i++) {
            char letra = cadena.charAt(i);

            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                acumulador++;
            }
        }

        System.out.println("El texto ingresado tiene :" + acumulador + " vocales");
    }
}
