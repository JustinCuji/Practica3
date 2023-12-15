package ups.edu.ec.Dao;

import java.util.ArrayList;
import java.util.List;
import ups.edu.ec.IDao.ILibroDAO;
import ups.edu.ec.Modelo.Libro;

public class LibroDao implements ILibroDAO {
    private ArrayList<Libro> listaLibros = new ArrayList<>();

    // Agrega un libro a la lista de libros.
    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    // Busca un libro por título, autor o año en la lista de libros.
    public Libro buscarLibro(String criterio) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(criterio) ||
                libro.getAutor().equalsIgnoreCase(criterio) ||
                String.valueOf(libro.getAño()).equalsIgnoreCase(criterio)) {
                return libro;
            }
        }
        return null;
    }

    // Obtiene una lista con todos los libros.
    public List<Libro> obtenerTodosLosLibros() {
        return new ArrayList<>(listaLibros);
    }

    // Actualiza los detalles de un libro en la lista de libros.
    public void actualizarLibro(Libro libroActualizado) {
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libro = listaLibros.get(i);
            if (libro.getTitulo().equals(libroActualizado.getTitulo())) {
                // Actualiza los detalles del libro.
                listaLibros.set(i, libroActualizado);
                break;
            }
        }
    }

    // Elimina un libro de la lista de libros.
    public void eliminarLibro(Libro libro) {
        listaLibros.remove(libro);
    }
}


