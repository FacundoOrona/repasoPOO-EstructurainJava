/*B. Moto
Atributo adicional: cilindrada.

calcularCostoFinal() = precioBase + $500 si la cilindrada es mayor a 250.

conducir() debe imprimir "Conduciendo una moto de [x]cc." */
public class Moto extends Vehiculo implements IConducible{

    private int cilindrada;

    public Moto(String marca, String modelo, int anio, double precioBase, int cilindrada){
        super(marca, modelo, anio, precioBase);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularCostoFinal() {
        if(cilindrada > 250){
            return this.getPrecioBase() + 500;
        }
        else{
            return this.getPrecioBase();
        }
    }

    @Override
    public void conducir() {
        System.out.println("Conduciendo una moto de " + cilindrada + "cc");
    }
}