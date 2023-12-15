package ups.edu.ec.Dao;

import java.util.ArrayList;
import java.util.List;
import ups.edu.ec.IDao.IPrestamoDAO;
import ups.edu.ec.Modelo.Prestamo;
import ups.edu.ec.Modelo.Usuario;

public class PrestamoDao implements IPrestamoDAO {
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    // Agrega un préstamo a la lista de préstamos.
    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    // Elimina un préstamo de la lista de préstamos.
    public void eliminarPrestamo(Prestamo prestamo) {
        listaPrestamos.remove(prestamo);
    }

    // Obtiene una lista con todos los préstamos.
    public List<Prestamo> obtenerTodosLosPrestamos() {
        return new ArrayList<>(listaPrestamos);
    }

    // Obtiene una lista con todos los préstamos asociados a un usuario.
    public List<Prestamo> obtenerPrestamosPorUsuario(Usuario usuario) {
        List<Prestamo> prestamosPorUsuario = new ArrayList<>();
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getUsuario().equals(usuario)) {
                prestamosPorUsuario.add(prestamo);
            }
        }
        return prestamosPorUsuario;
    }
}
