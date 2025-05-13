package Ciclos;
/*🔸 Imprimir números impares del 1 al 100

Usando un bucle for, mostrálos en pantalla uno por uno. */
public class ejerciciofor {
    public static void main(String[] args) {

        for(int i = 1; i <= 100; i++){
            if(i % 2 != 0){
                System.out.println(i);
            }
        }

    }
    
}
