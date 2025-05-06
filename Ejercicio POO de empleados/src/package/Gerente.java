/*C. Gerente
Tiene un atributo adicional cantidadEmpleadosACargo.

Implementa calcularSueldo() sumando 30% al salario base + $100 por cada empleado a cargo.

Sobrescribe trabajar() para decir "Supervisando un equipo de [n] empleados." */

public class Gerente extends Empleado implements ITrabajable {

    private int cantidadEmpleadosACargo;

    public Gerente(String n, int e, double sb, int cant){
        super(n, e, sb);
        this.cantidadEmpleadosACargo = cant;
    }

    public void setCantidadEmpleadosACargo(int cant){
        this.cantidadEmpleadosACargo = cant;
    }

    public int getCantidadEmpleadosACargo(){
        return cantidadEmpleadosACargo;
    }

    @Override
    public double calcularSueldo() {
        double salarioAumentado = (this.getSalarioBase() * 1.30) + (cantidadEmpleadosACargo * 100);
        return salarioAumentado; 
    }

    @Override
    public void trabajar() {
        System.out.println("Supervisando un equipo de " + cantidadEmpleadosACargo + " empleados a cargo");
    }
    
}
