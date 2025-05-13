package zAvanzados;
/*Palíndromo

Verificar si una palabra o frase es palíndroma (igual al derecho y al revés). */
public class Ejercicio11 {
    public static void main(String[] args) {
        String cadena = "cadena";
        String invertida = "";
        cadena = cadena.replaceAll("\\s+", "").toLowerCase();

        for(int i = cadena.length(); i > 0 ; i--){
            invertida += cadena.charAt(i - 1);
        }

        if (cadena.equals(invertida)){
            System.out.println("Son palindromas");
        }else{
            System.out.println("No son palindromas");
        }
    }
}
