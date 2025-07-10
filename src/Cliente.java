import java.util.*;

public class Cliente extends Usuario {
    private static int idCounter = 1;
    private int id;
    private List<Almacen> almacenesAdquiridos = new ArrayList<>();

    public Cliente(String nombreCompleto, String correo, String telefono, String usuario) {
        super(nombreCompleto, correo, telefono, usuario);
        this.id = idCounter++;
    }

    public int getId() { return id; }

    public void adquirirAlmacen(Almacen almacen) {
        almacenesAdquiridos.add(almacen);
    }

    public List<Almacen> getAlmacenesAdquiridos() {
        return almacenesAdquiridos;
    }
}
