package proyecto.entidades;


import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
    
    private List<Prestamo> prestamosActivos;

    public Cliente(){prestamosActivos = new ArrayList<>();}

    public Cliente(String nombre, String dni, String email, List<Prestamo> prestamosActivos){
        super(nombre, dni, email);
        prestamosActivos = new ArrayList<>();
        this.prestamosActivos = prestamosActivos;
    }

    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }
    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public Cliente encontrarCliente(String dni, List<Usuario> usuarios) {
        Cliente c = null;
        for (Usuario u : usuarios) {
            if (u.getDni().equals(dni) && u instanceof Cliente) {
                c = (Cliente) u;
            }
        }
        return c;
    }

}
