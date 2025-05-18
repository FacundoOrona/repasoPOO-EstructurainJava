package proyecto;

import java.util.Scanner;

import proyecto.entidades.Biblioteca;
import proyecto.negocio.ClienteNegocio;
import proyecto.negocio.ConsolaNegocio;
import proyecto.negocio.EmpleadoNegocio;
import proyecto.negocio.LibroNegocio;
import proyecto.negocio.PrestamoNegocio;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        ConsolaNegocio consola = new ConsolaNegocio();
        LibroNegocio libroNegocio = new LibroNegocio(biblioteca);
        ClienteNegocio clienteNegocio = new ClienteNegocio(biblioteca);
        EmpleadoNegocio empleadoNegocio = new EmpleadoNegocio(biblioteca);
        PrestamoNegocio prestamoNegocio = new PrestamoNegocio(biblioteca);

        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            consola.limpiarConsola();
            System.out.println("**** || BIENVENIDO A LA BIBLIOTECA DE TAPALQUÉ || ****");
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
            System.out.println("==============================");
            opc = sc.nextInt();

            switch (opc) {
                case 1: // Registrar un usuario.
                    consola.limpiarConsola();
                    System.out.println("Si desea registrar un Empleado (Ingrese 1) o un  Cliente (Ingrese 2)");
                    int n = sc.nextInt();
                    sc.nextLine();
                    if (n == 1) {
                        empleadoNegocio.registrarEmpleado();
                    } else if (n == 2) {
                        clienteNegocio.registrarCliente();
                    } else {
                        System.out.println("***No se ingresó un valor válido***");
                    }
                    break;
                case 2: // Registrar un libro
                    consola.limpiarConsola();
                    libroNegocio.registrarLibros();
                    break;
                case 3: // Prestamo de libro
                    consola.limpiarConsola();
                    prestamoNegocio.realizarPrestamoLibro();
                    break;
                case 4: // Mostrar prestamos activos
                    consola.limpiarConsola();
                    prestamoNegocio.listarPrestamosActivos();;
                    break;
                case 5: // devolver libro
                    consola.limpiarConsola();
                    System.out.println("Ingrese el ID del libro que quiere devolver");
                    int idDevolver = sc.nextInt();
                    biblioteca.devolverLibro(idDevolver);
                    break;
                case 6: // Listar empleados
                    consola.limpiarConsola();
                    empleadoNegocio.listarEmpleados();
                    ;
                    break;
                case 7: // Listar clientes
                    consola.limpiarConsola();
                    clienteNegocio.listarClientes();
                    break;
                case 8: // Listar libros
                    consola.limpiarConsola();
                    libroNegocio.listarLibros();
                    break;
                case 9: // Salir del programa
                    consola.limpiarConsola();
                    System.out.println("|| Usted esta saliendo del programa, gracias por visitarnos!. ||");
                    break;
                default:
                    System.out.println("Opcion invalida, por favor ingrese una correcta.");
                    break;
            }

        } while (opc != 9);
        sc.close();
    }
}
