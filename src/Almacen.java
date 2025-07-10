import java.time.LocalDate;

public class Almacen {
    private static int contadorAlmacen = 1;
    private String clave;
    private String tamanio;
    private double precioVenta;
    private double precioRentaMensual;
    private LocalDate fechaRegistro;

    public Almacen(String claveSede, String tamanio, double precioVenta, double precioRentaMensual) {
        this.fechaRegistro = LocalDate.now();
        this.clave = claveSede + "-" + contadorAlmacen++;
        this.tamanio = tamanio;
        this.precioVenta = precioVenta;
        this.precioRentaMensual = precioRentaMensual;
    }

    public String getClave() { return clave; }
    public String getTamanio() { return tamanio; }
    public double getPrecioVenta() { return precioVenta; }
    public double getPrecioRentaMensual() { return precioRentaMensual; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
}
