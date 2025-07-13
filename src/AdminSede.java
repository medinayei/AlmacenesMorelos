import java.util.*;  // Importa utilidades como List y ArrayList

/**
 * Clase que representa a un administrador de sede.
 * Este rol hereda de la clase Usuario y está vinculado a una sede específica.
 * Tiene la capacidad de registrar almacenes y clientes dentro de su sede.
 */
public class AdminSede extends Usuario {

    // Sede a la que pertenece este administrador
    private Sede sede;

    // Lista de clientes registrados por el administrador en esta sede
    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Constructor para crear un administrador de sede.
     *
     * @param nombreCompleto Nombre completo del administrador.
     * @param correo Correo electrónico del administrador.
     * @param telefono Teléfono del administrador.
     * @param usuario Nombre de usuario.
     * @param sede Sede a la que se asigna el administrador.
     */
    public AdminSede(String nombreCompleto, String correo, String telefono, String usuario, Sede sede) {
        super(nombreCompleto, correo, telefono, usuario);  // Llama al constructor de la clase base Usuario
        this.sede = sede;  // Asocia la sede a este administrador
    }

    /**
     * Obtiene la sede asociada a este administrador.
     *
     * @return Objeto Sede correspondiente.
     */
    public Sede getSede() {
        return this.sede;
    }

    /**
     * Registra un nuevo almacén en la sede administrada.
     *
     * @param tamanio Tamaño del almacén (por ejemplo: "pequeño", "mediano", "grande").
     * @param precioVenta Precio de venta del almacén.
     * @param precioRenta Precio de renta del almacén.
     */
    public void registrarAlmacen(String tamanio, double precioVenta, double precioRenta) {
        // Crea un nuevo almacén con la clave de la sede
        Almacen nuevo = new Almacen(sede.getClave(), tamanio, precioVenta, precioRenta);
        sede.agregarAlmacen(nuevo);  // Lo agrega a la sede
    }

    /**
     * Registra un nuevo cliente en esta sede.
     *
     * @param cliente Objeto Cliente a registrar.
     */
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);  // Agrega el cliente a la lista
    }

    /**
     * Devuelve la lista de clientes registrados en la sede.
     *
     * @return Lista de objetos Cliente.
     */
    public List<Cliente> getClientes() {
        return clientes;
    }
}
