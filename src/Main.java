import java.util.*;
import java.io.*;

public class Main {
    static final String SUPER_USER = "root";
    static final String SUPER_PASS = "admin123";
    static Scanner scanner = new Scanner(System.in);

    static SuperAdmin superAdmin = new SuperAdmin();
    static Map<String, AdminSede> admins = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Bienvenido al Sistema de Venta y Renta de Almacenes ===");
            System.out.print("Ingrese usuario: ");
            String user = scanner.nextLine();
            System.out.print("Ingrese contraseña: ");
            String pass = scanner.nextLine();

            if (user.equals(SUPER_USER) && pass.equals(SUPER_PASS)) {
                menuSuperAdmin();
            } else if (admins.containsKey(user) && admins.get(user).getContrasena().equals(pass)) {
                menuAdminSede(admins.get(user));
            } else {
                System.out.println("Credenciales incorrectas. Intente de nuevo.\n");
            }
        }
    }

    static void menuSuperAdmin() {
        while (true) {
            System.out.println("\n--- MENÚ SUPERADMIN ---");
            System.out.println("1. Registrar nueva sede");
            System.out.println("2. Asignar administrador a sede");
            System.out.println("3. Ver sedes registradas");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            String opc = scanner.nextLine();

            switch (opc) {
                case "1":
                    System.out.print("Municipio de la sede: ");
                    String municipio = scanner.nextLine();
                    Sede sede = superAdmin.registrarSede(municipio);
                    guardarEnArchivo("sedes.txt", sede.getClave() + " | " + municipio);
                    System.out.println("Sede registrada con clave: " + sede.getClave());
                    break;
                case "2":
                    if (superAdmin.getSedes().isEmpty()) {
                        System.out.println("No hay sedes disponibles.");
                        break;
                    }
                    System.out.println("Sedes disponibles:");
                    for (int i = 0; i < superAdmin.getSedes().size(); i++) {
                        Sede s = superAdmin.getSedes().get(i);
                        System.out.println((i + 1) + ". " + s.getClave() + " - " + s.getMunicipio());
                    }
                    System.out.print("Seleccione la sede (número): ");
                    int index = Integer.parseInt(scanner.nextLine()) - 1;
                    Sede sedeSeleccionada = superAdmin.getSedes().get(index);

                    if (sedeSeleccionada.getAdmin() != null) {
                        System.out.println("Esta sede ya tiene un administrador asignado.");
                        break;
                    }

                    System.out.println("Ingrese los datos del administrador:");
                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Nombre de usuario: ");
                    String user = scanner.nextLine();

                    AdminSede nuevoAdmin = superAdmin.asignarAdminSede(sedeSeleccionada, nombre, correo, tel, user);
                    admins.put(user, nuevoAdmin);
                    guardarEnArchivo("admins.txt", user + " | " + nuevoAdmin.getContrasena() + " | Sede: " + sedeSeleccionada.getClave());
                    System.out.println("Administrador registrado con éxito.");
                    break;
                case "3":
                    for (Sede s : superAdmin.getSedes()) {
                        System.out.println(s.getClave() + " - " + s.getMunicipio());
                    }
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    static void menuAdminSede(AdminSede admin) {
        while (true) {
            System.out.println("\n--- MENÚ ADMIN SEDE ---");
            System.out.println("1. Registrar nuevo almacén");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Ver almacenes registrados");
            System.out.println("4. Ver clientes registrados");
            System.out.println("5. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            String opc = scanner.nextLine();

            switch (opc) {
                case "1":
                    System.out.print("Tamaño (G/M/C): ");
                    String tam = scanner.nextLine();
                    System.out.print("Precio venta: ");
                    double venta = Double.parseDouble(scanner.nextLine());
                    System.out.print("Precio renta mensual: ");
                    double renta = Double.parseDouble(scanner.nextLine());

                    admin.registrarAlmacen(tam, venta, renta);
                    Almacen ult = admin.getSede().getAlmacenes().get(admin.getSede().getAlmacenes().size() - 1);
                    guardarEnArchivo("almacenes.txt", ult.getClave() + " | " + tam + " | Venta: " + venta + " | Renta: " + renta);
                    System.out.println("Almacén registrado: " + ult.getClave());
                    break;
                case "2":
                    System.out.print("Nombre completo: ");
                    String nom = scanner.nextLine();
                    System.out.print("Correo: ");
                    String email = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Usuario: ");
                    String user = scanner.nextLine();

                    Cliente cliente = new Cliente(nom, email, tel, user);
                    admin.registrarCliente(cliente);
                    guardarEnArchivo("clientes.txt", "ID " + cliente.getId() + " | " + user + " | " + nom);
                    System.out.println("Cliente registrado con ID: " + cliente.getId());
                    break;
                case "3":
                    for (Almacen a : admin.getSede().getAlmacenes()) {
                        System.out.println(a.getClave() + " - " + a.getTamanio() +
                                " | Venta: " + a.getPrecioVenta() + " | Renta: " + a.getPrecioRentaMensual());
                    }
                    break;
                case "4":
                    for (Cliente c : admin.getClientes()) {
                        System.out.println("ID " + c.getId() + " | " + c.nombreCompleto);
                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    static void guardarEnArchivo(String nombreArchivo, String linea) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }
}
