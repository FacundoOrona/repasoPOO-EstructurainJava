/*1. Crear una clase abstracta Vehiculo con:
Atributos privados: marca, modelo, anio, precioBase.

Métodos:

Getters y setters.

Método abstracto calcularCostoFinal().

Método mostrarInfo() que devuelva una cadena con todos los datos del vehículo.

Método cumplirAnios() que incremente el año y muestre un mensaje.

 */
public abstract class Vehiculo{
    private String marca;
    private String modelo;
    private int anio;
    private double precioBase;

    public Vehiculo(String marca, String modelo, int anio, double precioBase){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioBase = precioBase;
    }


    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMarca(){
        return marca;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getModelo(){
        return modelo;
    }

    public void setAnio(int anio){
        this.anio = anio;
    }
    public int getAnio(){
        return anio;
    }

    public void setPrecioBase(double precioBase){
        this.precioBase = precioBase;
    }
    public double getPrecioBase(){
        return precioBase;
    }

    public abstract double calcularCostoFinal();

    public String mostrarInfo(){
        return "Marca: " + marca + "\n" + "Modelo: " + modelo + "\n" + "Año: " + anio + "\n" + "Precio base: " + precioBase + "\n ----------------";
    }

    public String cumplirAnios(){
        this.anio++;
        return "El auto es del: " + anio;
    }

}