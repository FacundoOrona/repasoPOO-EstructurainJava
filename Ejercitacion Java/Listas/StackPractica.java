package Listas;
import java.util.Stack;

public class StackPractica {
    public static void main(String[] args) {
        Stack<String> pila = new Stack<>();

        pila.push("Libro 1");
        pila.push("Libro 2");
        pila.push("Libro 3");

        while (!pila.isEmpty()) {
            System.out.println("Sacando: " + pila.pop());
        }
    }
}
