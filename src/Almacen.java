import java.time.LocalDate;  // Importa la clase LocalDate para manejar fechas sin tiempo

/**
 * Clase que representa un almacén dentro de una sede.
 * Contiene información sobre su tamaño, precios y fecha de registro.
 */
public class Almacen {

    // Contador estático para generar claves únicas de almacenes
    private static int contadorAlmacen = 1;

    // Clave única del almacén (formada por la clave de la sede + número consecutivo)
    private String clave;

    // Tamaño del almacén (por ejemplo: pequeño, mediano, grande)
    private String tamanio;

    // Precio de venta del almacén
    private double precioVenta;

    // Precio de renta mensual del almacén
    private double precioRentaMensual;

    // Fecha en la que se registró el almacén
    private LocalDate fechaRegistro;

    /**
     * Constructor para crear un nuevo almacén.
     *
     * @param claveSede Clave de la sede donde se ubica el almacén.
     * @param tamanio Tamaño del almacén.
     * @param precioVenta Precio de venta del almacén.
     * @param precioRentaMensual Precio mensual de renta del almacén.
     */
    public Almacen(String claveSede, String tamanio, double precioVenta, double precioRentaMensual) {
        this.fechaRegistro = LocalDate.now(); // Establece la fecha actual como fecha de registro
        this.clave = claveSede + "-" + contadorAlmacen++; // Genera clave única usando sede + contador
        this.tamanio = tamanio;
        this.precioVenta = precioVenta;
        this.precioRentaMensual = precioRentaMensual;
    }

    /**
     * Devuelve la clave única del almacén.
     *
     * @return Clave del almacén.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Devuelve el tamaño del almacén.
     *
     * @return Tamaño como cadena (pequeño, mediano, grande, etc.).
     */
    public String getTamanio() {
        return tamanio;
    }

    /**
     * Devuelve el precio de venta del almacén.
     *
     * @return Precio de venta.
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Devuelve el precio mensual de renta del almacén.
     *
     * @return Precio de renta mensual.
     */
    public double getPrecioRentaMensual() {
        return precioRentaMensual;
    }

    /**
     * Devuelve la fecha en la que fue registrado el almacén.
     *
     * @return Fecha de registro.
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
}
