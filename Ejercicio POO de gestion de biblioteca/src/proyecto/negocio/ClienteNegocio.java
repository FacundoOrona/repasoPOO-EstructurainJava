package proyecto.negocio;

import java.util.Scanner;

import proyecto.entidades.Biblioteca;
import proyecto.entidades.Cliente;

public class ClienteNegocio {

    private Biblioteca biblioteca;

    public ClienteNegocio(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    Scanner sc = new Scanner(System.in);

    public void registrarCliente() {
        Cliente cliente = new Cliente();

        System.out.println("Ingrese los datos para registrar Cliente");
        System.out.println("Nombre:");
        cliente.setNombre(sc.nextLine());
        System.out.println("Email:");
        cliente.setEmail(sc.nextLine());
        System.out.println("DNI:");
        cliente.setDni(sc.nextLine());

        biblioteca.registrarCliente(cliente);

        System.out.println("*********************************");
        System.out.println("Cliente registrado correctamente");
        System.out.println("*********************************");
        sc.nextLine();
    }

    public void listarClientes() {
        System.out.println("******************************* Lista de clientes *******************************");
        biblioteca.listarClientes();
    }

    public void eliminarCliente() {
        System.out.println("Ingrese el DNI del cliente a eliminar:");
        String dni = sc.nextLine();
        boolean eliminado = biblioteca.eliminarCliente(dni);
        
        if (eliminado) {
            System.out.println("*********************************");
            System.out.println("Cliente eliminado correctamente");
            System.out.println("*********************************");
        } else {
            System.out.println("No se encontró un cliente con ese DNI.");
        }
        sc.nextLine();
    }
}
