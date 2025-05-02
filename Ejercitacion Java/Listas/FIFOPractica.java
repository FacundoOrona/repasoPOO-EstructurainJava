package Listas;
import java.util.LinkedList;
import java.util.Queue;

public class FIFOPractica {
    public static void main(String[] args){
        Queue<String> filaClientes = new LinkedList<>();

        //Clientes que van llegando a la panaderia
        filaClientes.add("Clara");
        filaClientes.add("Facu");
        filaClientes.add("Juan");

        System.out.println("Comienzan a atenden en la panaderia:\n");

        while (!filaClientes.isEmpty()){
            String cliente = filaClientes.poll(); //El primero en llegar es el atendido 
            System.out.println("Atendiendo a: " + cliente);
        }
    }
}
