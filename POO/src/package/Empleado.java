abstract class Empleado{

    //atributos
    private String nombre;
    private int edad;
    private double salarioBase;

    //constructor
    public Empleado(String n, int e, double sb){
        this.nombre = n;
        this.edad = e;
        this.salarioBase = sb;
    }

    //getters y setters
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String n){
        this.nombre = n;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int e){
        this.edad = e;
    }

    public double getSalarioBase(){
        return salarioBase;
    }

    public void setSalarioBase(double sb){
        this.salarioBase = sb;
    }

    //metodo abstracto
    public abstract double calcularSueldo();

    //metodos
    public String presentarse(){
        return "Hola soy " + nombre + " y tengo " + edad + "años";
    }

    public String cumplirAnios(){
        this.edad++; // actualiza la edad real
        return "El empleado " + nombre + " cumplió " + edad + " años.";
    }

}