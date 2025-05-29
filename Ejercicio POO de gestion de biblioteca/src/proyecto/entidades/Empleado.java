package proyecto.entidades;

import java.util.List;
import java.util.Scanner;

public class Empleado extends Usuario {

    Scanner sc = new Scanner(System.in);

    public Empleado() {
    }

    public Empleado(String nombre, String dni, String email) {
        super(nombre, dni, email);
    }

    public void verPrestamo(List<Prestamo> prestamos) {
        for (Prestamo p : prestamos) {
            System.out.println("Libro: " + p.getLibro().getTitulo());
            System.out.println("Cliente: " + p.getCliente().getNombre());
            System.out.println("fechaPrestamo: " + p.getFechaPrestamo());

            if (p.getFechaDevolucion() != null) {
                System.out.println("El libro esta disponible");
            } else {
                System.out.println("El libro aun no ha sido devuelto");
            }

        }
    }

    public void registrarLibro(Libro libro) {
        System.out.println("Ingrese los datos para registrar el libro");
        System.out.println("Ingrese titulo:");
        String titulo = sc.nextLine();
        libro.setTitulo(titulo);
        System.out.println("Ingrese autor:");
        String autor = sc.nextLine();
        libro.setAutor(autor);
        System.out.println("Ingrese año de publicacion");
        int anio = sc.nextInt();
        libro.setAnioPublicacion(anio);
        libro.setDisponible(true);
    }

    public static Empleado fromString(String linea) {
        String[] partes = linea.split(" - ");
        if (partes.length >= 3) {
            return new Empleado(partes[0], partes[1], partes[2]);
        } else {
            System.out.println("Línea inválida: " + linea);
            return new Empleado();
        }
    }

}