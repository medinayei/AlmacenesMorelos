/**
 * Clase base que representa a un usuario del sistema.
 * Esta clase es heredada por roles específicos como AdminSede, entre otros.
 */
public class Usuario {

    // Nombre completo del usuario
    protected String nombreCompleto;

    // Correo electrónico del usuario
    protected String correo;

    // Número de teléfono del usuario
    protected String telefono;

    // Nombre de usuario utilizado para iniciar sesión
    protected String usuario;

    // Contraseña del usuario (por defecto se asigna igual que el nombre de usuario)
    protected String contrasena;

    /**
     * Constructor que inicializa los datos básicos del usuario.
     *
     * @param nombreCompleto Nombre completo del usuario.
     * @param correo Correo electrónico del usuario.
     * @param telefono Número telefónico del usuario.
     * @param usuario Nombre de usuario (también se asigna como contraseña por defecto).
     */
    public Usuario(String nombreCompleto, String correo, String telefono, String usuario) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasena = usuario; // Por defecto, la contraseña es igual al nombre de usuario
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return Nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña asignada.
     */
    public String getContrasena() {
        return contrasena;
    }
}
