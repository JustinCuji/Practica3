package ups.edu.ec.Controlador;

// Clase abstracta que representa a una persona.
public abstract class Persona {
    protected String nombre;
    protected String identificacion;

    // Constructor que inicializa los atributos nombre e identificación.
    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    // Método abstracto para mostrar información de la persona. Las clases hijas deben implementar este método.
    public abstract void mostrarInformacion();
}
