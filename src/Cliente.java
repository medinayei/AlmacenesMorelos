import java.util.*;  // Importa utilidades como List y ArrayList

/**
 * Clase que representa a un cliente del sistema.
 * Hereda de la clase Usuario e incluye un identificador único y
 * una lista de almacenes que ha adquirido.
 */
public class Cliente extends Usuario {

    // Contador estático para generar IDs únicos para los clientes
    private static int idCounter = 1;

    // Identificador único del cliente
    private int id;

    // Lista de almacenes adquiridos por este cliente
    private List<Almacen> almacenesAdquiridos = new ArrayList<>();

    /**
     * Constructor que crea un nuevo cliente con los datos básicos.
     *
     * @param nombreCompleto Nombre completo del cliente.
     * @param correo Correo electrónico del cliente.
     * @param telefono Teléfono del cliente.
     * @param usuario Nombre de usuario (también se usa como contraseña por defecto).
     */
    public Cliente(String nombreCompleto, String correo, String telefono, String usuario) {
        super(nombreCompleto, correo, telefono, usuario);  // Llama al constructor de Usuario
        this.id = idCounter++;  // Asigna un ID único e incrementa el contador
    }

    /**
     * Devuelve el ID único del cliente.
     *
     * @return ID del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Asocia un almacén adquirido por el cliente.
     *
     * @param almacen Almacén que el cliente ha adquirido.
     */
    public void adquirirAlmacen(Almacen almacen) {
        almacenesAdquiridos.add(almacen);
    }

    /**
     * Devuelve la lista de almacenes adquiridos por el cliente.
     *
     * @return Lista de almacenes adquiridos.
     */
    public List<Almacen> getAlmacenesAdquiridos() {
        return almacenesAdquiridos;
    }
}
/**
 *Mena albino Israel
 * Benjamin
 * Jenifer
 *Yeimi Media Mariaca
 * yovani David
 * */