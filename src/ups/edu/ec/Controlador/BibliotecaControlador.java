package ups.edu.ec.Controlador;

import java.util.Scanner;

import ups.edu.ec.IDao.ILibroDAO;
import ups.edu.ec.IDao.IPrestamoDAO;
import ups.edu.ec.IDao.IUsuarioDAO;
import ups.edu.ec.Modelo.BibliotecaModelo;
import ups.edu.ec.Modelo.Libro;
import ups.edu.ec.Modelo.Prestamo;
import ups.edu.ec.Modelo.Usuario;
import ups.edu.ec.Vista.BibliotecaVista;

// Clase que actúa como el controlador del sistema de gestión de biblioteca.
public class BibliotecaControlador {

    private BibliotecaModelo modelo;
    private BibliotecaVista vista;
    private Scanner scanner;
    private ILibroDAO libroDAO;
    private IUsuarioDAO usuarioDAO;
    private IPrestamoDAO prestamoDAO;

    // Constructor que inicializa el controlador con el modelo, vista y las interfaces DAO.
    public BibliotecaControlador(BibliotecaModelo model, BibliotecaVista view, ILibroDAO libroDAO, IUsuarioDAO usuarioDAO, IPrestamoDAO prestamoDAO) {
        this.modelo = model;
        this.vista = view;
        this.scanner = new Scanner(System.in);
        this.libroDAO = libroDAO;
        this.usuarioDAO = usuarioDAO;
        this.prestamoDAO = prestamoDAO;
    }

    // Método principal que ejecuta la lógica del sistema de gestión de biblioteca.
    public void ejecutar() {
        int opcion;

        do {
            vista.mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    prestarLibro();
                    break;
                case 5:
                    devolverLibro();
                    break;
                case 6:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    // Método para agregar un libro al sistema.
    private void agregarLibro() {
        vista.mostrarMensaje("Ingrese el título del libro: ");
        String tituloLibro = scanner.nextLine();
        vista.mostrarMensaje("Ingrese el autor del libro: ");
        String autorLibro = scanner.nextLine();
        vista.mostrarMensaje("Ingrese el año del libro: ");
        int añoLibro = scanner.nextInt();
        Libro nuevoLibro = new Libro(tituloLibro, autorLibro, añoLibro);

        libroDAO.agregarLibro(nuevoLibro);

        vista.mostrarMensaje("Libro agregado con éxito.");
    }

    // Método para registrar a un nuevo usuario en el sistema.
    private void registrarUsuario() {
        vista.mostrarMensaje("Ingrese el nombre del usuario: ");
        String nombreUsuario = scanner.nextLine();
        vista.mostrarMensaje("Ingrese la identificación del usuario: ");
        String idUsuario = scanner.nextLine();
        vista.mostrarMensaje("Ingrese el correo del usuario: ");
        String correoUsuario = scanner.nextLine();
        Usuario nuevoUsuario = new Usuario(nombreUsuario, idUsuario, correoUsuario);

        usuarioDAO.registrarUsuario(nuevoUsuario);

        vista.mostrarMensaje("Usuario registrado con éxito.");
    }

    // Método para buscar un libro en el sistema.
    private void buscarLibro() {
        vista.mostrarMensaje("Ingrese el título, autor o año del libro a buscar: ");
        String criterioBusqueda = scanner.nextLine();

        // Buscar el libro utilizando el LibroDAO
        Libro libroEncontrado = libroDAO.buscarLibro(criterioBusqueda);

        if (libroEncontrado != null) {
            libroEncontrado.mostrarInformacion();
        } else {
            vista.mostrarMensaje("Libro no encontrado.");
        }
    }

    // Método para prestar un libro a un usuario.
    private void prestarLibro() {
        vista.mostrarMensaje("Ingrese el título del libro a prestar: ");
        String tituloLibro = scanner.nextLine();

        // Buscar el libro utilizando el LibroDAO
        Libro libroPrestar = libroDAO.buscarLibro(tituloLibro);

        if (libroPrestar != null && libroPrestar.isDisponible()) {
            vista.mostrarMensaje("Ingrese la identificación del usuario que realizará el préstamo: ");
            String idUsuario = scanner.nextLine();

            // Buscar el usuario utilizando el UsuarioDAO
            Usuario usuarioPrestamo = usuarioDAO.buscarUsuario(idUsuario);

            if (usuarioPrestamo != null) {
                // Prestar el libro utilizando el PrestamoDAO
                prestamoDAO.agregarPrestamo(new Prestamo(libroPrestar, usuarioPrestamo));
                libroPrestar.prestar();
                vista.mostrarMensaje("Préstamo realizado con éxito.");
            } else {
                vista.mostrarMensaje("Usuario no encontrado. Verifique la identificación.");
            }
        } else if (libroPrestar == null) {
            vista.mostrarMensaje("Libro no encontrado.");
        } else {
            vista.mostrarMensaje("El libro no está disponible para préstamo.");
        }
    }

    // Método para devolver un libro al sistema.
    private void devolverLibro() {
        vista.mostrarMensaje("Ingrese el título del libro a devolver: ");
        String tituloLibro = scanner.nextLine();

        // Buscar el libro utilizando el LibroDAO
        Libro libroDevolver = libroDAO.buscarLibro(tituloLibro);

        if (libroDevolver != null && !libroDevolver.isDisponible()) {
            vista.mostrarMensaje("Ingrese la identificación del usuario que devolverá el libro: ");
            String idUsuario = scanner.nextLine();

            // Buscar el usuario utilizando el UsuarioDAO
            Usuario usuarioDevolucion = usuarioDAO.buscarUsuario(idUsuario);

            if (usuarioDevolucion != null) {
                // Devolver el libro utilizando el PrestamoDAO
                prestamoDAO.eliminarPrestamo(new Prestamo(libroDevolver, usuarioDevolucion));
                libroDevolver.devolver();
                vista.mostrarMensaje("Devolución realizada con éxito. Libro marcado como disponible.");
            } else {
                vista.mostrarMensaje("Usuario no encontrado. Verifique la identificación.");
            }
        } else if (libroDevolver == null) {
            vista.mostrarMensaje("Libro no encontrado.");
        } else {
            vista.mostrarMensaje("El libro ya está disponible o no fue prestado por esta biblioteca.");
        }
    }
}

