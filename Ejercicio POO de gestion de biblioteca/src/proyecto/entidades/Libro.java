package proyecto.entidades;

import proyecto.interfaces.Prestable;

public class Libro implements Prestable{

    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
    private int id;

    public Libro(){};

    public Libro(String titulo, String autor, int anioPublicacion, int id){
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
        this.id = id;
    }

    //setters
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

    //getters
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
        return  "Id: " + id + "\n" +
                "Libro: " + titulo + "\n" + 
                "autor: " + autor + "\n" +
                "Año de publicacion: " + anioPublicacion + "\n" +
                "Disponibilidad: " + titulo + "\n";
    }

    @Override
    public void prestar() {
        disponible = false;
    }

    @Override
    public void devolver() {
        disponible = true;
    }

}

