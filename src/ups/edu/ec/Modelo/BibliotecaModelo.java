package ups.edu.ec.Modelo;

// Clase que encapsula una instancia de la clase Biblioteca.
public class BibliotecaModelo {
    private Biblioteca biblioteca;

    // Constructor que inicializa una instancia de BibliotecaModelo con una Biblioteca proporcionada.
    public BibliotecaModelo(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    // Método para obtener la instancia de Biblioteca contenida en el modelo.
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    // Método toString para obtener una representación en cadena del BibliotecaModelo.
    public String toString() {
        return "BibliotecaModelo{" + "biblioteca=" + biblioteca + '}';
    }
}
