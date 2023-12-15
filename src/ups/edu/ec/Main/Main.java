package ups.edu.ec.Main;

import ups.edu.ec.Controlador.BibliotecaControlador;
import ups.edu.ec.Dao.LibroDao;
import ups.edu.ec.Dao.PrestamoDao;
import ups.edu.ec.Dao.UsuarioDao;
import ups.edu.ec.Modelo.Biblioteca;
import ups.edu.ec.Modelo.BibliotecaModelo;
import ups.edu.ec.Vista.BibliotecaVista;

public class Main {
	 public static void main(String[] args) {
	        // Crear instancias de los DAOs
	        LibroDao libroDAO = new LibroDao();
	        UsuarioDao usuarioDao = new UsuarioDao();
	        PrestamoDao prestamoDAO = new PrestamoDao();

	        // Crear una instancia de BibliotecaModelo con los DAOs
	        BibliotecaModelo model = new BibliotecaModelo(
	                new Biblioteca("Biblioteca Central", null, libroDAO, usuarioDao, prestamoDAO));

	        // Crear una instancia de BibliotecaVista
	        BibliotecaVista view = new BibliotecaVista();

	        // Crear una instancia de BibliotecaControlador con el modelo, la vista y los DAOs
	        BibliotecaControlador controller = new BibliotecaControlador(model, view, libroDAO, usuarioDao, prestamoDAO);

	        // Ejecutar el controlador
	        controller.ejecutar();
	    }
	}