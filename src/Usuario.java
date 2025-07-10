public class Usuario {
    protected String nombreCompleto;
    protected String correo;
    protected String telefono;
    protected String usuario;
    protected String contrasena;

    public Usuario(String nombreCompleto, String correo, String telefono, String usuario) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasena = usuario;
    }

    public String getUsuario() { return usuario; }
    public String getContrasena() { return contrasena; }
}
