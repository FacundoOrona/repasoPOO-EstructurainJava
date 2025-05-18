package proyecto.negocio;

import java.util.Scanner;

import proyecto.entidades.Biblioteca;
import proyecto.entidades.Cliente;
import proyecto.entidades.Libro;

public class LibroNegocio {

    private Biblioteca biblioteca;

    public LibroNegocio(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    Scanner sc = new Scanner(System.in);

    public void registrarLibros() {
        System.out.println("*************************************************************");
        System.out.println("Ingrese los datos requeridos para registrar un nuevo libro");
        System.out.println("*************************************************************");
        Libro libro = new Libro();
        sc.nextLine();

        System.out.println("Titulo del libro:");
        libro.setTitulo(sc.nextLine());
        System.out.println("Autor:");
        libro.setAutor(sc.nextLine());
        System.out.println("Ingrese año de publicacion");
        libro.setAnioPublicacion(sc.nextInt());

        biblioteca.registrarLibro(libro);
        System.out.println("*******************************");
        System.out.println("Libro registrado correctamente");
        System.out.println("*******************************");
        sc.nextLine();
        sc.nextLine();
    }

    public void listarLibros() {
        System.out.println("******************************* Lista de libros *******************************");
        biblioteca.listarLibros();
    }

    public void realizarPrestamoLibro() {
        System.out.println("Ingrese los datos requeridos para prestar un libro");
        sc.nextLine();

        System.out.println("DNI del Cliente");
        String dniCliente = sc.nextLine();

        Cliente cliente = new Cliente();
        cliente = biblioteca.encontrarCliente(dniCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado o no existente");
            System.out.println("********************************************************");
            System.out.println("|| Presione una tecla para continuar ||");
            sc.nextLine();
            return;
        }

        System.out.println("Ingrese ID del libro que quiere prestar");
        int idLibro = sc.nextInt();
        sc.nextLine();

        Libro libro = new Libro();
        libro = biblioteca.encontrarLibro(idLibro);

        if (libro == null) {
            System.out.println("Libro no encontrado o no disponible");
            System.out.println("********************************************************");
            System.out.println("|| Presione una tecla para continuar ||");
            sc.nextLine();
            return;
        }

        libro.prestar();

        biblioteca.prestarLibro(cliente, libro);
    }

}
