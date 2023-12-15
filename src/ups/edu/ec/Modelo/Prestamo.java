package ups.edu.ec.Modelo;

import java.util.Date;

// Clase que representa un préstamo de un libro a un usuario.
public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;

    // Constructor que inicializa un préstamo con un libro, un usuario y la fecha actual.
    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = new Date();
    }

    // Método para calcular la cantidad de días transcurridos desde el préstamo.
    public int calcularDiasPrestamo() {
        long tiempoPrestamo = new Date().getTime() - fechaPrestamo.getTime();
        return (int) (tiempoPrestamo / (1000 * 60 * 60 * 24));
    }

    // Método para verificar si el préstamo sigue siendo vigente (dentro del límite de días).
    public boolean esPrestamoVigente() {
        int maxDiasPrestamo = 14;
        return calcularDiasPrestamo() <= maxDiasPrestamo;
    }
    
// Métodos de acceso y modificación para obtener y establecer los atributos del usuario.

//Getters and Setters   
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    // Método toString para obtener una representación en cadena del préstamo.
    public String toString() {
        return "Prestamo{" + "libro=" + libro + ", usuario=" + usuario + ", fechaPrestamo=" + fechaPrestamo + '}';
    }
}

