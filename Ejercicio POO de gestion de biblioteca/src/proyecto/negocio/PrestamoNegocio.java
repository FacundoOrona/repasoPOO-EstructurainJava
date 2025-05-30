package proyecto.negocio;

import java.util.Scanner;

import proyecto.daoArchivos.ArchivoPrestamo;
import proyecto.entidades.Biblioteca;
import proyecto.entidades.Cliente;
import proyecto.entidades.Libro;
import proyecto.entidades.Prestamo;

public class PrestamoNegocio {

    private Biblioteca biblioteca;

    public PrestamoNegocio(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    Scanner sc = new Scanner(System.in);

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

    public void listarPrestamosActivos() {
        System.out.println("Lista de prestamos activos");
        biblioteca.mostrarPrestamosActivos();
    }

    public void devolverLibroPrestado() {
        System.out.println("Ingrese el ID del libro que quiere devolver");
        int idDevolver = sc.nextInt();
        sc.nextLine();

        Prestamo prestamo = biblioteca.encontrarPrestamo(idDevolver);

        if (prestamo == null) {
            System.out.println("Libro no encontrado o aún sigue disponible");
            System.out.println("********************************************************");
            System.out.println("|| Presione una tecla para continuar ||");
            sc.nextLine();
            return;
        }

        prestamo.devolverLibro();

        // Guardar cambios en archivo
        ArchivoPrestamo.guardarPrestamos(biblioteca.getPrestamos());

        System.out.println("El libro \"" + prestamo.getLibro().getTitulo() + "\" fue devuelto con éxito");
        System.out.println("********************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

}
