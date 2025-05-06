/*3. Crear las siguientes subclases que implementen Conducible:
A. Auto
Atributo adicional: cantidadPuertas.

calcularCostoFinal() = precioBase + 10% si tiene más de 3 puertas.

conducir() debe imprimir "Conduciendo un auto de [n] puertas." */
public class Auto extends Vehiculo implements IConducible{

    private int cantidadPuertas;

    public Auto(String marca, String modelo, int anio, double precioBase, int cantidadPuertas){
        super(marca, modelo, anio, precioBase);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }
    
    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }    

    public double calcularCostoFinal(){
        if(cantidadPuertas > 3){
            return this.getPrecioBase() * 1.10;
        }
        else{
            return this.getPrecioBase();
        }
    }

    @Override
    public void conducir() {
        System.out.println("Conduciendo un auto de "+ cantidadPuertas + " puertas");    
    }
}