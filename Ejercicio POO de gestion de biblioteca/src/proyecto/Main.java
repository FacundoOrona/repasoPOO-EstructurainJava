package proyecto;

import java.util.Scanner;

import proyecto.entidades.Biblioteca;
import proyecto.entidades.Cliente;
import proyecto.entidades.Empleado;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("*BIENVENIDO A LA BIBLIOTECA DE TAPALQUÉ");
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("Elija una opcion");
            System.out.println("1 - Registrar un nuevo usuario");
            System.out.println("2 - Registrar un nuevo libro");
            System.out.println("3 - Realizar un prestamo de libro");
            System.out.println("4 - Mostrar prestamos activo");
            System.out.println("5 - Devolver un libro");
            System.out.println("6 - Listar Empleados");
            System.out.println("7 - Listar Clientes");
            System.out.println("8 - Listar Libros");
            System.out.println("9 - Salir del programa");
            opc = sc.nextInt();

            switch (opc) {
                case 1: // Registrar un usuario.
                    System.out.println("Desea registrar un Empleado (Ingrese 1) o un  Cliente (Ingrese 2)");
                    int n = sc.nextInt();
                    sc.nextLine(); // Limpia el buffer después de nextInt()

                    if (n == 1) {
                        Empleado empleado = new Empleado();
                        biblioteca.registrarEmpleado(empleado);
                        System.out.println("*********************************");
                        System.out.println("Empleado registrado correctamente");
                        System.out.println("*********************************");
                    } else if (n == 2) {
                        Cliente cliente = new Cliente();
                        biblioteca.registrarCliente(cliente);
                        System.out.println("*********************************");
                        System.out.println("Cliente registrado correctamente");
                        System.out.println("*********************************");
                    } else {
                        System.out.println("***No se ingresó un valor válido***");
                    }
                    break;
                case 2: // Registrar un libro

                    break;
                case 3: // Prestamo de libro

                    break;
                case 4: // Mostrar prestamos activos

                    break;
                case 5: // devolver libro

                    break;
                case 6: // Salir del programa

                    break;
                case 7: // Salir del programa

                    break;
                case 8: // Salir del programa

                    break;
                case 9: // Salir del programa

                    break;
                default:
                    System.out.println("Opcion valida, por favor.");
                    break;
            }

        } while (opc != 6);
        sc.close();
    }
}
