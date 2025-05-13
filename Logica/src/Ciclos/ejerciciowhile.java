package Ciclos;

import java.util.Scanner;

/*🔁 Ejercicio con while
🔸 Adivinar contraseña

Usando while, pedile al usuario una contraseña (por ejemplo, "1234") y no lo dejes pasar hasta que la escriba correctamente.

Condiciones:

Mostrá un mensaje de error si se equivoca.

Terminá solo cuando escriba bien. */
public class ejerciciowhile {
    public static void main(String[] args) {
        String correcta = "1234";
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la contraseña");
        String intento = scanner.nextLine();
        while (!intento.equals(correcta)) {
            System.out.println("Contraseña incorrecta");
            System.out.println("Vuelva a introducir una contraseña");
            intento = scanner.nextLine();
        }

        System.out.println("Contraseña correcta");
        scanner.close();
    }
}
