package ups.edu.ec.IDao;

import java.util.List;
import ups.edu.ec.Modelo.Usuario;

public interface IUsuarioDAO {

    // Registra un nuevo usuario en la fuente de datos.
    public void registrarUsuario(Usuario usuario);

    // Busca un usuario por su identificación en la fuente de datos.
    Usuario buscarUsuario(String identificacion);

    // Obtiene una lista con todos los usuarios en la fuente de datos.
    List<Usuario> obtenerTodosLosUsuarios();

    // Actualiza la información de un usuario en la fuente de datos.
    public void  actualizarUsuario(Usuario usuario);

    // Elimina un usuario de la fuente de datos.
    public void  eliminarUsuario(Usuario usuario);

}
