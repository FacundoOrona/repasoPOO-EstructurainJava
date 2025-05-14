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
        String biblioteca = " ";
        for(Libro l : libros){
            l.toString();
        }
        return biblioteca;
    }

    public Cliente encontrarCliente(String dni) {
        Cliente c = null;
        for (Usuario u : usuarios) {
            if (u.getDni().equals(dni) && u instanceof Cliente) {
                c = (Cliente) u;
            }
        }
        return c;
    }

    public Libro encontrarLibro(int id) {
        Libro l = null;
        for (Libro libro : libros) {
            if (libro.getId() == id && libro.getDisponible()) {
                l = libro;
                l.setDisponible(false);
            }
        }
        return l;
    }

    public void prestarLibro(String dniCliente, int idLibro) {
        Cliente c = encontrarCliente(dniCliente);
        if (c == null) {
            System.out.println("❌ Cliente no encontrado o no existente");
            return;
        }

        Libro l = encontrarLibro(idLibro);
        if (l == null) {
            System.out.println("❌ Libro no encontrado o no disponible");
            return;
        }

        Prestamo p = new Prestamo(l, c, new Date());
        prestamos.add(p);
        System.out.println("✅ Préstamo realizado correctamente");
    }
}
