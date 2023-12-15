package ups.edu.ec.Modelo;

// Clase que representa un libro en el sistema de la biblioteca.
public class Libro {
    private String titulo;
    private String autor;
    private int año;
    private boolean disponible;

    // Constructor que inicializa un libro con título, autor y año proporcionados. El libro se establece como disponible.
    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.disponible = true;
    }

    // Método para marcar un libro como prestado.
    public void prestar() {
        disponible = false;
    }

    // Método para marcar un libro como devuelto y disponible.
    public void devolver() {
        disponible = true;
    }

    // Método para mostrar información detallada sobre el libro.
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + año);
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }
    
// Métodos de acceso y modificación para obtener y establecer los atributos del usuario.
//getters and setters    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
