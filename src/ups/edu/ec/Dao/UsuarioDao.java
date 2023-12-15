package ups.edu.ec.Dao;

import java.util.ArrayList;
import java.util.List;
import ups.edu.ec.IDao.IUsuarioDAO;
import ups.edu.ec.Modelo.Usuario;

public class UsuarioDao implements IUsuarioDAO {
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    // Registra un nuevo usuario en la lista de usuarios.
    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    // Busca un usuario por su identificación en la lista de usuarios.
    public Usuario buscarUsuario(String identificacion) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdentificacion().equals(identificacion)) {
                return usuario;
            }
        }
        return null;
    }

    // Obtiene una lista con todos los usuarios.
    public List<Usuario> obtenerTodosLosUsuarios() {
        return new ArrayList<>(listaUsuarios);
    }

    // Actualiza los detalles de un usuario en la lista de usuarios.
    public void actualizarUsuario(Usuario usuarioActualizado) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            if (usuario.getIdentificacion().equals(usuarioActualizado.getIdentificacion())) {
                // Actualizar los detalles del usuario
                listaUsuarios.set(i, usuarioActualizado);
                break;
            }
        }
    }

    // Elimina un usuario de la lista de usuarios.
    public void eliminarUsuario(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }
}
