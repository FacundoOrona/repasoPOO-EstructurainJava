/*2. Crear una interfaz Trabajable con:
Método trabajar().

Método tomarDescanso() con implementación default que imprima "Tomando un descanso breve...".

Método estático mostrarNormas() que imprima "Las normas de trabajo son confidenciales.". */

public interface ITrabajable{

    public abstract void trabajar();

    public default void tomarDescanso(){
        System.out.println("Tomando un breve descanso...");
    }

    public static void mostrarNormas(){
        System.out.println("Las normas de trabajo son confidenciales");
    }

}