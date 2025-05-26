package proyecto.entidades;

import java.util.List;

import proyecto.interfaces.Prestable;

public class Libro implements Prestable {

    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
    private int id;
    private static int idContador = 0;

    public Libro() {
        this.id = generarId();
        this.disponible = true;
    };

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
        this.id = generarId();
    }

    private static int generarId() {
        return idContador++;
    }

    // setters
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // getters
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean getDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        return  "Id: " + id + " | " +
                "Libro: " + titulo + " | " +
                "Autor: " + autor + " | " +
                "Año de publicación: " + anioPublicacion + " | " +
                "Disponibilidad: " + (disponible ? "Disponible" : "No disponible") + " | ";
    }

    @Override
    public void prestar() {
        disponible = false;
    }

    @Override
    public void devolver() {
        disponible = true;
    }


    public Libro encontrarLibroPorTitulo(String titulo, List<Libro> libros) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

}
