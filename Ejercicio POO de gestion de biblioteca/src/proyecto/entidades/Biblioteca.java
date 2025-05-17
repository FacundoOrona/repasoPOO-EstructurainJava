package proyecto.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;
    private List<Empleado> empleados;
    private List<Cliente> clientes;

    private Scanner sc = new Scanner(System.in);

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
        empleados = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void registrarEmpleado(Empleado empleado) {
        System.out.println("Empleado en capa negocio: " + empleado.toString());
        empleados.add(empleado);

    }

    public void registrarCliente(Cliente c) {
        System.out.println("Ingrese los datos para registrar Cliente");
        System.out.println("Nombre:");
        c.setNombre(sc.nextLine());
        System.out.println("Email:");
        c.setEmail(sc.nextLine());
        System.out.println("DNI:");
        c.setDni(sc.nextLine());
        clientes.add(c);
    }

    public void registrarLibro(Libro l) {
        sc.nextLine();
        System.out.println("Titulo del libro:");
        l.setTitulo(sc.nextLine());
        System.out.println("Autor:");
        l.setAutor(sc.nextLine());
        System.out.println("Ingrese año de publicacion");
        l.setAnioPublicacion(sc.nextInt());
        libros.add(l);
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== Libros ===\n");
        for (Libro l : libros) {
            sb.append(l).append("\n");
        }

        sb.append("\n=== Usuarios ===\n");
        for (Usuario u : usuarios) {
            sb.append(u).append("\n");
        }

        sb.append("\n=== Préstamos ===\n");
        for (Prestamo p : prestamos) {
            sb.append(p).append("\n");
        }

        return sb.toString();
    }

    public void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c.toString());
            System.out.println("------------------------------------------------------------------------------");
        }
        System.out.println("********************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public void listarEmpleados() {
        for (Empleado e : empleados) {
            System.out.println(e.toString());
            System.out.println("------------------------------------------------------------------------------");
        }
        System.out.println("********************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public void prestarLibro(String dniCliente, int idLibro) {
        Cliente c = new Cliente();
        c = c.encontrarCliente(dniCliente, clientes);
        if (c == null) {
            System.out.println("Cliente no encontrado o no existente");
            System.out.println("********************************************************");
            System.out.println("|| Presione una tecla para continuar ||");
            sc.nextLine();
            return;
        }

        Libro l = new Libro();
        l = l.encontrarLibro(idLibro, libros);
        if (l == null) {
            System.out.println("Libro no encontrado o no disponible");
            System.out.println("********************************************************");
            System.out.println("|| Presione una tecla para continuar ||");
            sc.nextLine();
            return;
        }

        l.prestar();

        Prestamo p = new Prestamo(l, c, new Date());
        prestamos.add(p);
        System.out.println(
                "Préstamo realizado correctamente del libro " + l.getTitulo() + " al Usuario " + c.getNombre());
        System.out.println("********************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public void devolverLibro(int idLibro) {
        Libro l = new Libro();
        l = l.encontrarLibroPrestado(idLibro, libros);

        if (l == null) {
            System.out.println("Libro no encontrado o aun sigue disponible");
            System.out.println("********************************************************");
            System.out.println("|| Presione una tecla para continuar ||");
            sc.nextLine();
            return;
        }

        // encontrar prestamo
        Prestamo p = new Prestamo();
        p = p.encontrarPrestamo(idLibro, prestamos);
        p.devolverLibro();

        System.out.println("El libro " + l.getTitulo() + " fue devuelto con exito");
        System.out.println("********************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public void mostrarPrestamosActivos() {
        for (Prestamo p : prestamos) {
            if (p.isActivo()) {
                System.out.println(p.toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        System.out.println("********************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        Libro l = new Libro();
        l = l.encontrarLibroPorTitulo(titulo, libros);
        if (l == null) {
            System.out.println("Libro no encontrado");
            return null;
        } else {
            System.out.println("Libro " + l.getTitulo() + " encontrado");
            return l;
        }
    }

    public void listarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro.toString());
            System.out.println("------------------------------------------------------------------------------");
        }
        System.out.println("********************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }
}
