package proyecto.entidades;

import java.util.List;
import proyecto.entidades.Prestamo;

public class Cliente extends Usuario{
    
    private List<Prestamo> prestamosActivos; 

    public Cliente(){};

    public Cliente(String nombre, String dni, String email, List<Prestamo> prestamosActivos){
        super(nombre, dni, email);
        this.prestamosActivos = prestamosActivos;
    }

}
