/*B. Desarrollador
Tiene un atributo adicional lenguajeFavorito.

Implementa calcularSueldo() sumando 20% al salario base.

Sobrescribe trabajar() para decir "Programando en [lenguajeFavorito]." */

public class Desarrollador extends Empleado implements ITrabajable {
    
    private String lenguajeFavorito;

    public Desarrollador(String n, int e, double sb, String lf){
        super(n, e, sb);
        this.lenguajeFavorito = lf;
    }

    public String getLenguajeFavorito(){
        return lenguajeFavorito;
    }

    public void setLenguajeFavorito(String lf){
        this.lenguajeFavorito = lf;
    }

    @Override
    public double calcularSueldo() {
        double salarioTotal = this.getSalarioBase() * 1.20;
        return salarioTotal;
    }

    @Override
    public void trabajar() {
        System.out.println("Programando en " + lenguajeFavorito);
    }
}
