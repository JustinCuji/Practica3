package ups.edu.ec.IDao;

import java.util.List;
import ups.edu.ec.Modelo.Libro;

public interface ILibroDAO {

    // Agrega un nuevo libro a la fuente de datos.
    public void agregarLibro(Libro libro);

    // Busca un libro según un criterio (título, autor o año).
    Libro buscarLibro(String criterio);

    // Obtiene una lista con todos los libros en la fuente de datos.
    List<Libro> obtenerTodosLosLibros();

    // Actualiza la información de un libro en la fuente de datos.
    public void actualizarLibro(Libro libro);

    // Elimina un libro de la fuente de datos.
    public void eliminarLibro(Libro libro);

}
