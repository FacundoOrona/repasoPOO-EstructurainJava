package proyecto.entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private List<Prestamo> prestamosActivos;

    public Cliente() {
        prestamosActivos = new ArrayList<>();
    }

    public Cliente(String nombre, String dni, String email, List<Prestamo> prestamosActivos) {
        super(nombre, dni, email);
        prestamosActivos = new ArrayList<>();
    }

    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public Cliente encontrarCliente(String dni, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("Comparando: " + cliente.getDni() + " con " + dni);
            if (cliente.getDni().equals(dni)) {
                System.out.println("✔ Cliente encontrado.");
                return cliente;
            }
        }
        System.out.println("❌ Cliente no encontrado.");
        return null;
    }

}
