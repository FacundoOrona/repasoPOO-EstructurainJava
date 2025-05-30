package proyecto.daoArchivos;

import proyecto.entidades.Libro;

import java.io.*;

public class ArchivoLibro {

    private static final String ARCHIVO = "libros.txt";

    public static void guardarLibro(Libro libro) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(libro.getTitulo() + " | " + libro.getAutor() + " | " + libro.getAnioPublicacion());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar libro: " + e.getMessage());
        }
    }

}
