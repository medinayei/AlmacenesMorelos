import java.util.*;

public class SuperAdmin {
    private List<Sede> sedes = new ArrayList<>();
    private List<AdminSede> adminsSede = new ArrayList<>();

    public Sede registrarSede(String municipio) {
        Sede nueva = new Sede(municipio);
        sedes.add(nueva);
        return nueva;
    }

    public AdminSede asignarAdminSede(Sede sede, String nombre, String correo, String telefono, String usuario) {
        if (sede.getAdmin() == null) {
            AdminSede admin = new AdminSede(nombre, correo, telefono, usuario, sede);
            sede.setAdmin(admin);
            adminsSede.add(admin);
            return admin;
        } else {
            throw new IllegalArgumentException("La sede ya tiene un administrador asignado.");
        }
    }

    public List<Sede> getSedes() { return sedes; }
}
