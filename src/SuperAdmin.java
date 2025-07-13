import java.util.*;  // Importa todas las clases del paquete java.util, como List y ArrayList

/**
 * Clase que representa al Super Administrador del sistema.
 * Este rol tiene los permisos más altos y puede:
 * - Registrar nuevas sedes.
 * - Asignar un administrador a cada sede.
 */
public class SuperAdmin {

    // Lista de sedes registradas por el super administrador
    private List<Sede> sedes = new ArrayList<>();

    // Lista de administradores de sede asignados
    private List<AdminSede> adminsSede = new ArrayList<>();

    /**
     * Registra una nueva sede en el sistema.
     * @param municipio Nombre del municipio donde se ubica la sede.
     * @return La nueva instancia de la sede creada.
     */
    public Sede registrarSede(String municipio) {
        Sede nueva = new Sede(municipio); // Se crea la nueva sede
        sedes.add(nueva);                // Se agrega a la lista de sedes
        return nueva;
    }

    /**
     * Asigna un administrador a una sede específica, si aún no tiene uno.
     * @param sede Sede a la que se le va a asignar un administrador.
     * @param nombre Nombre del administrador.
     * @param correo Correo electrónico del administrador.
     * @param telefono Teléfono del administrador.
     * @param usuario Nombre de usuario del administrador.
     * @return El nuevo administrador de sede asignado.
     * @throws IllegalArgumentException Si la sede ya tiene un administrador asignado.
     */
    public AdminSede asignarAdminSede(Sede sede, String nombre, String correo, String telefono, String usuario) {
        if (sede.getAdmin() == null) {  // Verifica si la sede aún no tiene administrador
            AdminSede admin = new AdminSede(nombre, correo, telefono, usuario, sede); // Crea al admin
            sede.setAdmin(admin);      // Asigna el administrador a la sede
            adminsSede.add(admin);     // Lo añade a la lista de administradores
            return admin;
        } else {
            // Si ya tiene administrador, lanza una excepción
            throw new IllegalArgumentException("La sede ya tiene un administrador asignado.");
        }
    }

    /**
     * Devuelve la lista completa de sedes registradas.
     * @return Lista de objetos Sede.
     */
    public List<Sede> getSedes() {
        return sedes;
    }
}
/**
 *Mena albino Israel
 * Benjamin
 * Jenifer
 *Yeimi Media Mariaca
 * yovani David
 * */