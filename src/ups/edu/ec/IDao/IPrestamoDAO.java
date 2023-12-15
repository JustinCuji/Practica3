package ups.edu.ec.IDao;

import java.util.List;
import ups.edu.ec.Modelo.Prestamo;
import ups.edu.ec.Modelo.Usuario;

public interface IPrestamoDAO {

    // Agrega un nuevo préstamo a la fuente de datos.
    public void agregarPrestamo(Prestamo prestamo);

    // Elimina un préstamo de la fuente de datos.
    public void eliminarPrestamo(Prestamo prestamo);

    // Obtiene una lista con todos los préstamos en la fuente de datos.
    List<Prestamo> obtenerTodosLosPrestamos();

    // Obtiene una lista de préstamos asociados a un usuario específico.
    List<Prestamo> obtenerPrestamosPorUsuario(Usuario usuario);

}
