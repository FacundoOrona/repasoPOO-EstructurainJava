package proyecto.negocio;

import java.util.Scanner;

import proyecto.entidades.Biblioteca;
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

    public void buscarLibroPorTitulo() {
        System.out.println("Ingrese el titulo del libro que desea buscar:");
        String titulo = sc.nextLine();

        Libro libro = biblioteca.buscarLibroPorTitulo(titulo);
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro);
        } else {
            System.out.println("No se encontró un libro con ese título.");
        }
        sc.nextLine();
    }

    public void eliminarLibro() {
        System.out.println("Ingrese el ID del libro que desea eliminar:");
        int id = sc.nextInt();
        sc.nextLine();

        boolean eliminado = biblioteca.eliminarLibro(id);
        if (eliminado) {
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("No se encontró un libro con ese ID.");
        }
        sc.nextLine();
    }

    public void editarLibro() {
        System.out.println("Ingrese el ID del libro que desea editar:");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        Libro libro = biblioteca.buscarLibroPorId(id);

        if (libro == null) {
            System.out.println("No se encontró un libro con ese ID.");
            return;
        }

        System.out.println("Libro encontrado:");
        System.out.println(libro);

        System.out.println("Ingrese el nuevo título (dejar en blanco para no modificar):");
        String nuevoTitulo = sc.nextLine();
        if (!nuevoTitulo.isEmpty())
            libro.setTitulo(nuevoTitulo);

        System.out.println("Ingrese el nuevo autor (dejar en blanco para no modificar):");
        String nuevoAutor = sc.nextLine();
        if (!nuevoAutor.isEmpty())
            libro.setAutor(nuevoAutor);

        System.out.println("Ingrese el nuevo año de publicación (0 para no modificar):");
        String entradaAnio = sc.nextLine();
        if (!entradaAnio.isEmpty()) {
            try {
                int nuevoAnio = Integer.parseInt(entradaAnio);
                if (nuevoAnio > 0)
                    libro.setAnioPublicacion(nuevoAnio);
            } catch (NumberFormatException e) {
                System.out.println("Año inválido. Se mantiene el actual.");
            }
        }

        biblioteca.actualizarLibro(libro);
        System.out.println("Libro actualizado correctamente.");
    }

}
