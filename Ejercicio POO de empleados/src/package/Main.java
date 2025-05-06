/*4. En un main:
Crear una lista de empleados (ArrayList<Empleado>).

Agregar un objeto de cada tipo.

Mostrar la presentación, el sueldo calculado y la acción de trabajar.

Llamar al método estático mostrarNormas() desde la interfaz.

Aplicar cumplirAnios() a cada empleado. */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        Desarrollador d = new Desarrollador("Juan", 20, 30000, "Java");
        Gerente g = new Gerente("Roberto", 50, 50000, 20);
        Administrativo a = new Administrativo("Romina", 24, 40000, "Informatica");

        listaEmpleados.add(d);
        listaEmpleados.add(g);
        listaEmpleados.add(a);

        for (Empleado emp : listaEmpleados) {
            
            System.out.println(emp.presentarse());
            System.out.println("Sueldo calculado: $" + emp.calcularSueldo());

            // Llamamos a trabajar, usando casting a ITrabajable
            if (emp instanceof ITrabajable) {
                ((ITrabajable) emp).trabajar();
                ((ITrabajable) emp).tomarDescanso(); // método default
            }

            // Cumplir años
            System.out.println(emp.cumplirAnios());
            System.out.println("------------------------");

        }

        // 5. Llamar al método estático de la interfaz
        ITrabajable.mostrarNormas();
        
    }
}
