package proyecto.entidades;

public abstract class Usuario {

    private final int id;
    private String nombre;
    private String dni;
    private String email;
    private static int idContador = 0;

    public Usuario() {
        this.id = generarId();
    }

    public Usuario(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.id = generarId();
    }

    private static int generarId() {
        return idContador++;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNombre() + " - " + getDni() + " - " + getEmail();
    }

}
