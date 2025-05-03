package Dia01;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListPractica {
    public static void Main(String[] args){
        Queue<String> cola = new LinkedList<>();

        cola.add("Cliente 1");
        cola.add("Cliente 2");
        cola.add("Cliente 3");

        while (!cola.isEmpty()){
            System.out.println("Atendiendo a :" + cola.poll());
        }
    }
    
}
