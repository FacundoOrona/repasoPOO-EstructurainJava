package proyecto.entidades;

import java.util.List;

public class Cliente extends Usuario{
    
    private List<Prestamo> prestamosActivos; 

    public Cliente(){}

    public Cliente(String nombre, String dni, String email, List<Prestamo> prestamosActivos){
        super(nombre, dni, email);
        this.prestamosActivos = prestamosActivos;
    }

    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }
    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

}
