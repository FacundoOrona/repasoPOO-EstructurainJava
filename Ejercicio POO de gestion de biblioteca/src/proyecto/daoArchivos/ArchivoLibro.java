package proyecto.daoArchivos;

import proyecto.entidades.Libro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Libro> cargarLibros() {
        List<Libro> libros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                libros.add(Libro.fromString(linea));
            }
        } catch (FileNotFoundException e) {
            // archivo no existe aún
        } catch (IOException e) {
            System.out.println("Error al leer libros: " + e.getMessage());
        }
        return libros;
    }

    public static void guardarListaCompleta(List<Libro> libros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Libro libro : libros) {
                bw.write(libro.getTitulo() + " | " + libro.getAutor() + " | " + libro.getAnioPublicacion());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al sobrescribir archivo de libros: " + e.getMessage());
        }
    }
}
