import java.util.*;
import java.time.LocalDate;

public class Sede {
    private static int contadorSede = 1;
    private String clave;
    private String municipio;
    private LocalDate fechaRegistro;
    private List<Almacen> almacenes = new ArrayList<>();
    private AdminSede admin;

    public Sede(String municipio) {
        this.municipio = municipio;
        this.fechaRegistro = LocalDate.now();
        this.clave = generarClave();
    }

    private String generarClave() {
        Random rand = new Random();
        int numeroAleatorio = 1000 + rand.nextInt(9000);
        String clave = "A" + contadorSede + "-" + fechaRegistro.toString().replace("-", "") + "-" + numeroAleatorio;
        contadorSede++;
        return clave;
    }

    public String getClave() { return clave; }
    public String getMunicipio() { return municipio; }
    public AdminSede getAdmin() { return admin; }
    public void setAdmin(AdminSede admin) {
        this.admin = admin;
    }
    public void agregarAlmacen(Almacen almacen) {
        almacenes.add(almacen);
    }
    public List<Almacen> getAlmacenes() { return almacenes; }
}
