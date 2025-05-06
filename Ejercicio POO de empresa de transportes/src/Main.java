/*4. En el main:
Crear una lista de vehículos (ArrayList<Vehiculo>).

Agregar un objeto de cada tipo.

Mostrar info, costo final y acción de conducir.

Llamar al método estático mostrarReglas() desde la interfaz.

Aplicar cumplirAnios() a cada vehículo. */

import java.util.ArrayList;

public class Main {
    public static void main(String [] args){

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        Auto autoA = new Auto("Peugeot", "206", 2010, 8000, 4);
        Auto autoB = new Auto("Peugeot", "206", 2010, 8000, 2);
        Camion c = new Camion("Iveco", "pinichi", 2010, 40000, 25);
        Moto m = new Moto("Motomel", "Yamaha", 2024, 5000, 270);

        listaVehiculos.add(autoA);
        listaVehiculos.add(autoB);
        listaVehiculos.add(c);
        listaVehiculos.add(m);

        for (Vehiculo v: listaVehiculos){
            System.out.println(v.mostrarInfo());
            System.out.println("El costo final es de: " + v.calcularCostoFinal());
            
            if(v instanceof IConducible){
                ((IConducible) v).conducir();
                ((IConducible) v).realizarMantenimiento();
            }

            IConducible.mostrarReglas();

            System.out.println(v.cumplirAnios());
        }

    }
}