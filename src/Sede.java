import java.util.*;               // Importa utilidades como List, ArrayList y Random
import java.time.LocalDate;       // Importa la clase LocalDate para manejar fechas sin tiempo

/**
 * Clase que representa una sede del sistema.
 * Cada sede tiene una clave única, un municipio, una fecha de registro,
 * una lista de almacenes y un administrador asignado.
 */
public class Sede {

    // Contador estático para numerar las sedes creadas
    private static int contadorSede = 1;

    // Clave única generada para identificar la sede
    private String clave;

    // Nombre del municipio donde se ubica la sede
    private String municipio;

    // Fecha de creación de la sede
    private LocalDate fechaRegistro;

    // Lista de almacenes registrados en esta sede
    private List<Almacen> almacenes = new ArrayList<>();

    // Administrador asignado a esta sede (puede ser null)
    private AdminSede admin;

    /**
     * Constructor que inicializa una nueva sede.
     *
     * @param municipio Nombre del municipio donde se ubica la sede.
     */
    public Sede(String municipio) {
        this.municipio = municipio;
        this.fechaRegistro = LocalDate.now();     // Asigna la fecha actual como fecha de registro
        this.clave = generarClave();              // Genera una clave única para la sede
    }

    /**
     * Genera una clave única para la sede en el formato:
     * A{contador}-{fechaAAAAMMDD}-{númeroAleatorio}
     *
     * @return Clave generada.
     */
    private String generarClave() {
        Random rand = new Random();
        int numeroAleatorio = 1000 + rand.nextInt(9000); // Genera un número aleatorio de 4 cifras
        String clave = "A" + contadorSede + "-" + fechaRegistro.toString().replace("-", "") + "-" + numeroAleatorio;
        contadorSede++;  // Incrementa el contador global para la siguiente sede
        return clave;
    }

    /**
     * Devuelve la clave única de la sede.
     *
     * @return Clave de la sede.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Devuelve el municipio donde se ubica la sede.
     *
     * @return Nombre del municipio.
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Obtiene el administrador asignado a la sede.
     *
     * @return Objeto AdminSede asignado.
     */
    public AdminSede getAdmin() {
        return admin;
    }

    /**
     * Asigna un administrador a la sede.
     *
     * @param admin Administrador que se va a asignar.
     */
    public void setAdmin(AdminSede admin) {
        this.admin = admin;
    }

    /**
     * Agrega un nuevo almacén a la sede.
     *
     * @param almacen Objeto Almacen a agregar.
     */
    public void agregarAlmacen(Almacen almacen) {
        almacenes.add(almacen);
    }

    /**
     * Devuelve la lista de almacenes registrados en esta sede.
     *
     * @return Lista de almacenes.
     */
    public List<Almacen> getAlmacenes() {
        return almacenes;
    }
}
