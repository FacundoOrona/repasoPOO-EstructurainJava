package proyecto.entidades;

import java.util.Date;
import java.util.List;

public class Prestamo {

    private Libro libro;
    private Cliente cliente;
    private Date fechaPrestamo;
    private Date fechaDevolucion = null;

    public Prestamo() {
    }

    public Prestamo(Libro libro, Cliente cliente, Date fechaPrestamo) {
        this.libro = libro;
        this.cliente = cliente;
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro +
                ", cliente=" + cliente +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + (fechaDevolucion != null ? fechaDevolucion : "No devuelto") +
                '}';
    }

    public void devolverLibro() {
        Date fechadev = new Date();
        setFechaDevolucion(fechadev);
        libro.devolver();
        System.out.println("El libro ha sido devuelto con exito");
    }

    public boolean isActivo() {
        if (libro.getDisponible()) {
            return false;
        } else {
            return true;
        }
    }

    public Prestamo encontrarPrestamo (int idLibro, List<Prestamo> prestamos){
        Prestamo p = null;
        for (Prestamo lp : prestamos){
            if(lp.getLibro().getId() == idLibro){
                p = lp;
            }
        }
        return p;
    }

}
