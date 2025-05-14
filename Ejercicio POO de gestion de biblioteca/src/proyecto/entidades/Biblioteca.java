package proyecto.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void registrarLibro(Libro l) {
        libros.add(l);
    }

    public void registrarUsuario(Usuario u) {
        usuarios.add(u);
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

        Prestamo p = new Prestamo(l, c, new Date());
        prestamos.add(p);
        System.out.println("✅ Préstamo realizado correctamente");
    }
}
