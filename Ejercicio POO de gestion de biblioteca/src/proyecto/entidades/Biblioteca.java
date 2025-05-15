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

    public void registrarEmpleado(Empleado e) {
        System.out.println("Ingrese los datos para registrar Empleado");
        System.out.println("Nombre");
            e.setNombre(sc.nextLine());
        System.out.println("Email");
            e.setEmail(sc.nextLine());
        System.out.println("DNI");
            e.setDni(sc.nextLine());
        empleados.add(e);
    }

    public void registrarCliente(Cliente c) {
        System.out.println("Ingrese los datos para registrar Cliente");
        System.out.println("Nombre");
            c.setNombre(sc.nextLine());
        System.out.println("Email");
            c.setEmail(sc.nextLine());
        System.out.println("DNI");
            c.setDni(sc.nextLine());
        clientes.add(c);
    }

    public void registrarLibro(Libro l) {
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

    public void prestarLibro(String dniCliente, int idLibro) {
        Cliente c = new Cliente();
        c = c.encontrarCliente(dniCliente, usuarios);
        if (c == null) {
            System.out.println("❌ Cliente no encontrado o no existente");
            return;
        }

        Libro l = new Libro();
        l = l.encontrarLibro(idLibro, libros);

        if (l == null) {
            System.out.println("❌ Libro no encontrado o no disponible");
            return;
        }

        l.prestar();

        Prestamo p = new Prestamo(l, c, new Date());
        prestamos.add(p);
        System.out.println("✅ Préstamo realizado correctamente");
    }

    public void devolverLibro(int idLibro) {
        Libro l = new Libro();
        l = l.encontrarLibro(idLibro, libros);

        if (l == null) {
            System.out.println("❌ Libro no encontrado o no disponible");
            return;
        }

        // encontrar prestamo
        Prestamo p = new Prestamo();
        p = p.encontrarPrestamo(idLibro, prestamos);
        p.devolverLibro();

        System.out.println("✅El libro " + l.getTitulo() + " fue devuelto con exito");
    }

    public void mostrarPrestamosActivos() {
        for (Prestamo p : prestamos) {
            if (p.isActivo()) {
                System.out.println(p.toString());
            }
        }
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
}
