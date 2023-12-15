package ups.edu.ec.Modelo;

import ups.edu.ec.IDao.ILibroDAO;
import ups.edu.ec.IDao.IPrestamoDAO;
import ups.edu.ec.IDao.IUsuarioDAO;

// La clase Biblioteca representa una biblioteca y utiliza interfaces para interactuar con objetos específicos.
public class Biblioteca {
    private String nombre;
    private String direccion;
    private ILibroDAO libroDAO;
    private IUsuarioDAO usuarioDAO;
    private IPrestamoDAO prestamoDAO;

    // Constructor que inicializa una instancia de Biblioteca con la información proporcionada.
    public Biblioteca(String nombre, String direccion, ILibroDAO libroDAO, IUsuarioDAO usuarioDAO, IPrestamoDAO prestamoDAO) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.libroDAO = libroDAO;
        this.usuarioDAO = usuarioDAO;
        this.prestamoDAO = prestamoDAO;
    }

    // Método para agregar un libro utilizando el DAO correspondiente.
    public void agregarLibro(Libro libro) {
        libroDAO.agregarLibro(libro);
    }

    // Método para registrar un usuario utilizando el DAO correspondiente.
    public void registrarUsuario(Usuario usuario) {
        usuarioDAO.registrarUsuario(usuario);
    }

    // Método para buscar un libro utilizando el DAO correspondiente.
    public Libro buscarLibro(String criterio) {
        return libroDAO.buscarLibro(criterio);
    }

    // Método para prestar un libro a un usuario.
    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libro.isDisponible()) {
            Prestamo prestamo = new Prestamo(libro, usuario);
            prestamoDAO.agregarPrestamo(prestamo);
            usuario.agregarPrestamo(prestamo);
            libro.prestar();
            System.out.println("Préstamo exitoso.");
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    // Método para devolver un libro prestado por un usuario.
    public void devolverLibro(Libro libroDevolver, Usuario usuarioDevolucion) {
        boolean libroPrestado = false;

        // Verificar si el usuario tiene el libro prestado y si el préstamo es vigente.
        for (Prestamo prestamo : usuarioDevolucion.getListaPrestamos()) {
            if (prestamo.getLibro().equals(libroDevolver) && prestamo.esPrestamoVigente()) {
                libroPrestado = true;
                prestamoDAO.eliminarPrestamo(prestamo);
                break;
            }
        }

        if (libroPrestado) {
            libroDevolver.setDisponible(true);
            System.out.println("Devolución exitosa. Libro marcado como disponible.");
        } else {
            System.out.println("Error: El usuario no tiene el libro prestado o el préstamo ha expirado.");
        }
    }

    // Método toString para obtener una representación en cadena de la Biblioteca.
    public String toString() {
        return "Biblioteca{" + "nombre=" + nombre + ", direccion=" + direccion + ", libroDAO=" + libroDAO +
                ", usuarioDAO=" + usuarioDAO + ", prestamoDAO=" + prestamoDAO + '}';
    }
}

