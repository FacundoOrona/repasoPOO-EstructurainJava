package zAvanzados;
/*Validación de contraseña

Pedir una contraseña y validar que tenga al menos 8 caracteres, una mayúscula, una minúscula y un número */
public class Ejericicio12 {
    public static void main(String[] args) {
        String contrasenia = "polo";
        String prueba = "pola";

        if (prueba.equals(contrasenia)) {
            System.out.println("Contraseña correcta");
        }
        else{
            System.err.println("Contraseña incorrecta");
        }
    }
}
