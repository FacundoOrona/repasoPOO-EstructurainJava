package proyecto.entidades;

import java.util.Date;

public class Prestamo {

    private Libro libro;
    private Cliente cliente;
    private Date fechaPrestamo;
    private Date fechaDevolucion = null;

    public Prestamo() {}

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
        return "Libro prestado: " + libro.getTitulo() +
                " | Cliente: " + cliente.getNombre() +
                " | Fecha de préstamo: " + fechaPrestamo +
                " | Fecha de devolución: " + (fechaDevolucion != null ? fechaDevolucion : "No devuelto");
    }

    public void devolverLibro() {
        Date fechadev = new Date();
        setFechaDevolucion(fechadev);
        libro.devolver();
        System.out.println("El libro ha sido devuelto con éxito");
    }

    public boolean isActivo() {
        return !libro.getDisponible();
    }

    public String toDataString() {
        return libro.getId() + " | " +
               cliente.getDni() + " | " +
               fechaPrestamo.getTime() + " | " +
               (fechaDevolucion != null ? fechaDevolucion.getTime() : "null");
    }

    public static Prestamo fromDataString(String linea) {
        String[] partes = linea.split(" \\| ");
        if (partes.length != 4)
            return null;

        int idLibro = Integer.parseInt(partes[0].trim());
        String dni = partes[1].trim();
        long fechaPrestamoMillis = Long.parseLong(partes[2].trim());
        String fechaDevolucionStr = partes[3].trim();

        Cliente cliente = Biblioteca.encontrarClienteStatic(dni);
        Libro libro = Biblioteca.encontrarLibroStatic(idLibro);

        if (cliente == null || libro == null) {
            return null;
        }

        Prestamo prestamo = new Prestamo(libro, cliente, new Date(fechaPrestamoMillis));
        if (!fechaDevolucionStr.equals("null")) {
            prestamo.setFechaDevolucion(new Date(Long.parseLong(fechaDevolucionStr)));
        }

        return prestamo;
    }
}
