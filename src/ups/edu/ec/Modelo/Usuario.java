package ups.edu.ec.Modelo;

import java.util.ArrayList;
import java.util.Iterator;

// Clase que representa a un usuario en el sistema de la biblioteca.
public class Usuario {
    private String nombre;
    private String identificacion;
    private String correo;
    private ArrayList<Prestamo> listaPrestamos;

    // Constructor que inicializa un usuario con nombre, identificación, correo y una lista de préstamos vacía.
    public Usuario(String nombre, String identificacion, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
        this.listaPrestamos = new ArrayList<>();
    }

    // Método para mostrar información básica sobre el usuario.
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificación: " + identificacion);
        System.out.println("Correo: " + correo);
    }

    // Método para solicitar un préstamo de un libro.
    public void solicitarPrestamo(Libro libro) {
        if (libro.isDisponible()) {
            Prestamo prestamo = new Prestamo(libro, this);
            libro.prestar();
            agregarPrestamo(prestamo);
            System.out.println("Préstamo solicitado con éxito.");
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    // Método para devolver un libro prestado por el usuario.
    public void devolverLibro(Libro libro) {
        Iterator<Prestamo> iterator = listaPrestamos.iterator();
        while (iterator.hasNext()) {
            Prestamo prestamo = iterator.next();
            if (prestamo.getLibro().equals(libro) && prestamo.esPrestamoVigente()) {
                libro.devolver();
                iterator.remove();
                System.out.println("Devolución exitosa. Libro marcado como disponible.");
                return;
            }
        }
        System.out.println("Error: El usuario no tiene el libro prestado o el préstamo ha expirado.");
    }

    // Método para agregar un préstamo a la lista de préstamos del usuario.
    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    // Métodos de acceso y modificación para obtener y establecer los atributos del usuario.
    //Getters and setters
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }
}
