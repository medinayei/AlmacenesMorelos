import java.util.*;

public class AdminSede extends Usuario {
    private Sede sede;
    private List<Cliente> clientes = new ArrayList<>();

    public AdminSede(String nombreCompleto, String correo, String telefono, String usuario, Sede sede) {
        super(nombreCompleto, correo, telefono, usuario);
        this.sede = sede;
    }
    public Sede getSede() {
        return this.sede;
    }

    public void registrarAlmacen(String tamanio, double precioVenta, double precioRenta) {
        Almacen nuevo = new Almacen(sede.getClave(), tamanio, precioVenta, precioRenta);
        sede.agregarAlmacen(nuevo);
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() { return clientes; }
}
