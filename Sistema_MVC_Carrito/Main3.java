package Laboratorio_8;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UsuarioModelo um = new UsuarioModelo();
        UsuarioVista uv = new UsuarioVista(scanner);
        UsuarioControlador uc = new UsuarioControlador(um, uv);

        Usuario usuario = uc.autenticar();

        if (usuario == null) {
            scanner.close();
            return;
        }

        CarritoModelo cm = new CarritoModelo();
        CarritoVista cv = new CarritoVista(scanner);
        CarritoControlador cc = new CarritoControlador(cm, cv);

        ResenaModelo rm = new ResenaModelo(cm);
        ResenaVista rv = new ResenaVista();
        ResenaControlador rc = new ResenaControlador(rm, rv, cv);

        int opcion;

        do {
            System.out.println("\n===== CARRITO DE COMPRAS =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Agregar al carrito");
            System.out.println("4. Ver carrito y total");
            System.out.println("5. Eliminar del carrito");
            System.out.println("6. Realizar compra");
            System.out.println("7. Ver historial de compras");
            System.out.println("8. Registrar resena");
            System.out.println("9. Ver resenas");
            System.out.println("10. Salir");

            opcion = cv.leerEntero("Seleccione: ");

            switch (opcion) {
                case 1:
                    cc.registrarProducto();
                    break;
                case 2:
                    cc.listarProductos();
                    break;
                case 3:
                    cc.agregarAlCarrito();
                    break;
                case 4:
                    cc.verCarrito();
                    break;
                case 5:
                    cc.eliminarDelCarrito();
                    break;
                case 6:
                    cc.comprar(usuario.getUsuario());
                    break;
                case 7:
                    for (Compra c : cm.getHistorial()) {
                        if (c.getUsuario().equalsIgnoreCase(
                                usuario.getUsuario())) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 8:
                    rc.registrar(usuario);
                    break;
                case 9:
                    rc.mostrar();
                    break;
                case 10:
                    System.out.println("Sesion finalizada.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 10);

        scanner.close();
    }
}
