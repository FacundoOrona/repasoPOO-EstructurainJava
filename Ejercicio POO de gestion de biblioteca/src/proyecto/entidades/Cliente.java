package proyecto.entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private List<Prestamo> prestamosActivos;

    public Cliente() {
        super(); 
        prestamosActivos = new ArrayList<>();
    }

    public Cliente(String nombre, String dni, String email) {
        super(nombre, dni, email);
        prestamosActivos = new ArrayList<>();
    }

    public Cliente(String nombre, String dni, String email, List<Prestamo> prestamosActivos) {
        super(nombre, dni, email);
        this.prestamosActivos = prestamosActivos;
    }

    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public static Cliente fromString(String linea) {
        String[] partes = linea.split(",");
        if (partes.length >= 3) {
            return new Cliente(partes[0], partes[1], partes[2]);
        } else {
            return new Cliente();
        }
    }
}

