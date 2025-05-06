/*2. Crear una interfaz Conducible con:
Método abstracto conducir().

Método default realizarMantenimiento() que imprima "Realizando mantenimiento preventivo...".

Método estático mostrarReglas() que imprima "Los conductores deben tener licencia vigente.". */
public abstract interface IConducible {

    void conducir();

    public default void realizarMantenimiento(){
        System.out.println("Realizando mantenimiento preventivo...");
    }

    public static void mostrarReglas(){
        System.out.println("Los conductores deben tener licencia vigente");
    }
}