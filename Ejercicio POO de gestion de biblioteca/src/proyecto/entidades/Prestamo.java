package proyecto.entidades;

import java.util.Date;

public class Prestamo {
    
    private Libro libro;
    private Cliente cliente;
    private Date fechaPrestamo;
    private Date fechaDevolucion = null;

    public Prestamo(){}

    public Prestamo(Libro libro, Cliente cliente, Date fechaPrestamo, Date fechaDevolucion){
        
    }

}
