package proyecto.entidades;

import java.util.Date;

public class Prestamo {

    private Libro libro;
    private Cliente cliente;
    private Date fechaPrestamo;
    private Date fechaDevolucion = null;

    public Prestamo() {
    }

    public Prestamo(Libro libro, Cliente cliente, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;
        this.cliente = cliente;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
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
        return super.toString();
    }



}
