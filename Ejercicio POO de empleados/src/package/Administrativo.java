/*3. Crear las siguientes subclases de Empleado que implementen Trabajable:
A. Administrativo
Tiene un atributo adicional sector.

Implementa calcularSueldo() sumando 10% al salario base.

Sobrescribe trabajar() para decir "Gestionando documentos del sector [sector]." */

public class Administrativo extends Empleado implements ITrabajable{

    private String sector;

    public Administrativo(String n, int e, double sb, String s){
        super(n, e, sb);
        this.sector = s;
    }

    public String getSector() {
        return sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    
    @Override
    public double calcularSueldo() {
        double salarioTotal = this.getSalarioBase() * 1.10;
        return salarioTotal;
    }

    @Override
    public void trabajar() {
        System.out.println("Gestionando documentos del sector " + sector);
    }

}