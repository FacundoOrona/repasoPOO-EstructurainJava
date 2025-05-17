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
        empleados.add(empleado);
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void registrarLibro(Libro libro) {
        libros.add(libro);
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
        System.out.println("****************************************************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }

    public void listarEmpleados() {
        for (Empleado e : empleados) {
            System.out.println(e.toString());
            System.out.println("------------------------------------------------------------------------------");
        }
        System.out.println("****************************************************************************************");
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
        System.out.println("****************************************************************************************");
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
        System.out.println("****************************************************************************************");
        System.out.println("|| Presione una tecla para continuar ||");
        sc.nextLine();
    }
}
