package proyecto.negocio;

import java.util.Scanner;

import proyecto.entidades.Biblioteca;
import proyecto.entidades.Libro;

public class LibroNegocio {

    Biblioteca biblioteca = new Biblioteca();
    Scanner sc = new Scanner(System.in);

    public void registrarLibros() {
        System.out.println("*************************************************************");
        System.out.println("Ingrese los datos requeridos para registrar un nuevo libro");
        System.out.println("*************************************************************");
        Libro libro = new Libro();

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

}
