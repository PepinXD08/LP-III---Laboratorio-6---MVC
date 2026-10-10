package Laboratorio_8;

public class UsuarioControlador {
    private UsuarioModelo modelo;
    private UsuarioVista vista;

    public UsuarioControlador(UsuarioModelo modelo, UsuarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public Usuario autenticar() {
        while (true) {
            vista.mostrarMenu();
            String opcion = vista.leer("Opcion: ");

            if (opcion.equals("1")) {
                String nombre = vista.leer("Nombre: ");
                String usuario = vista.leer("Usuario: ");
                String contrasena = vista.leer("Contrasena: ");

                if (modelo.registrar(nombre, usuario, contrasena)) {
                    System.out.println("Registro exitoso.");
                } else {
                    System.out.println("Datos invalidos o usuario existente.");
                }
            } else if (opcion.equals("2")) {
                String usuario = vista.leer("Usuario: ");
                String contrasena = vista.leer("Contrasena: ");

                Usuario u = modelo.iniciarSesion(usuario, contrasena);

                if (u != null) {
                    System.out.println("Bienvenido, " + u.getNombre());
                    return u;
                }

                System.out.println("Credenciales incorrectas.");
            } else if (opcion.equals("3")) {
                return null;
            } else {
                System.out.println("Opcion no valida.");
            }
        }
    }
}
