/*C. Camion
Atributo adicional: capacidadCarga (en toneladas).

calcularCostoFinal() = precioBase + $1000 por tonelada de carga.

conducir() debe imprimir "Conduciendo un camión con capacidad de [x] toneladas." */
public class Camion extends Vehiculo implements IConducible{
    private int capacidadCarga;

    public Camion (String marca, String modelo, int anio, double precioBase, int capacidadCarga){
        super(marca, modelo, anio, precioBase);
        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }
    
    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCostoFinal() {
        return this.getPrecioBase() + (1000 * capacidadCarga);
    }

    @Override
    public void conducir() {
        System.out.println("Conduciendo un camion con capacidad de "+ capacidadCarga +" toneladas");
    }
}