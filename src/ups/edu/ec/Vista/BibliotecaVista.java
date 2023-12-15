package ups.edu.ec.Vista;

// Clase que representa la vista de la biblioteca, encargada de mostrar el menú y mensajes.
public class BibliotecaVista {
    
    // Método para mostrar el menú principal del sistema de gestión de biblioteca.
    public void mostrarMenu() {
        System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Registrar Usuario");
        System.out.println("3. Buscar Libro");
        System.out.println("4. Prestar Libro");
        System.out.println("5. Devolver Libro");
        System.out.println("6. Salir");
    }

    // Método para mostrar un mensaje en la consola.
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
