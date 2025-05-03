package src.Dia05;

public class Main {
    public static void main(String[] args) {
        Animal miPerro = new Perro("Firulais");
        Animal miGato = new Gato("Michi");

        miPerro.hacerSonido(); // Firulais dice: ¡Guau!
        miGato.hacerSonido();  // Michi dice: ¡Miau!
    }
}
