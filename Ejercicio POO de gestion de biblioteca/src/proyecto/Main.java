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
            System.out.println("** || BIENVENIDO A LA BIBLIOTECA DE TAPALQUÉ || ****");
            System.out.println(" ");
            System.out.println("  ============= MENU PRINCIPAL ===============");
            System.out.println("               Elija una opcion");
            System.out.println("1 - Menu de usuaros");
            System.out.println("2 - Menu de libros");
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

                case 1: // Menu de usuarios.
                    int opcMenuUsuario;
                    do {
                        consola.limpiarConsola();
                        System.out.println("    MENU DE USUARIOS");
                        System.out.println("1 - Registar nuevo usuario");
                        System.out.println("2 - Mostrar listado de usuarios");
                        System.out.println("3 - Dar de baja un usuario");
                        System.out.println("==============================");
                        opcMenuUsuario = sc.nextInt();
                        switch (opcMenuUsuario) {
                            case 1: // Registar nuevo usuario
                                consola.limpiarConsola();
                                System.out.println(
                                        "Si desea registrar un Empleado (Ingrese 1) o un  Cliente (Ingrese 2)");
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
                            case 2: // Listado de Usuarios
                                System.out.println("Si desea listar Empleados (Ingrese 1) o Clientes (Ingrese 2)");
                                int n1 = sc.nextInt();
                                sc.nextLine();
                                if (n1 == 1) {
                                    consola.limpiarConsola();
                                    empleadoNegocio.listarEmpleados();
                                } else if (n1 == 2) {
                                    consola.limpiarConsola();
                                    clienteNegocio.listarClientes();
                                } else {
                                    System.out.println("***No se ingresó un valor válido***");
                                }
                                break;
                            case 3: // Dar de baja Usuario
                                break;

                            case 4: // Volver al menu principal
                                System.out.println("Volviendo al menu principal");
                                break;
                            default:
                                System.out.println("Ingrese una opcion valida por favor");
                                break;
                        }
                    } while (opcMenuUsuario != 4);

                    break;
                case 2: // Menu de libros
                    int opcMenuLibros;
                    do {
                        consola.limpiarConsola();
                        System.out.println("        MENU DE LIBROS");
                        System.out.println("1 - Registrar un nuevo libro");
                        System.out.println("2 - Mostrar listado de libros");
                        System.out.println("3 - Buscar libro por titulo");
                        System.out.println("4 - Dar de baja un libro");
                        System.out.println("5 - Volver al menu principal");
                        opcMenuLibros = sc.nextInt();

                        switch (opcMenuLibros) {
                            case 1: // Registar libro
                                consola.limpiarConsola();
                                libroNegocio.registrarLibros();
                                break;
                            case 2: // Mostrar lista de libros
                                consola.limpiarConsola();
                                libroNegocio.listarLibros();
                                break;
                            case 3: // Buscar libro por titulo
                                break;
                            case 4: // Dar de baja un libro
                                break;
                            case 5:
                                System.out.println("Volviendo al menu principal...");
                                break;
                            default:
                                System.out.println("Ingrese una opcion valida por favor");
                                break;
                        }
                    } while (opcMenuLibros != 5);

                    break;
                case 3: // Prestamo de libro
                    consola.limpiarConsola();
                    prestamoNegocio.realizarPrestamoLibro();
                    break;
                case 4: // Mostrar prestamos activos
                    consola.limpiarConsola();
                    prestamoNegocio.listarPrestamosActivos();
                    ;
                    break;
                case 5: // devolver libro
                    consola.limpiarConsola();
                    prestamoNegocio.devolverLibroPrestado();
                    break;
                case 6: // Listar empleados

                    break;
                case 7: // Listar clientes

                    break;
                case 8: // Listar libros

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
