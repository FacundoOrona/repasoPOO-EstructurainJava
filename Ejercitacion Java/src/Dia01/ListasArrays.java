package Dia01;
import java.util.ArrayList;

public class ListasArrays {
    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");

        for (String fruta : frutas) {
            System.out.println(fruta);
        }
    }
}
