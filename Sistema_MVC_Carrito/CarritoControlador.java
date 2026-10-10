package Laboratorio_8;

public class CarritoControlador {
    private CarritoModelo modelo;
    private CarritoVista vista;

    public CarritoControlador(CarritoModelo modelo, CarritoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void registrarProducto() {
        String nombre = vista.leer("Nombre: ").trim();
        double precio = vista.leerDecimal("Precio: ");
        int stock = vista.leerEntero("Stock: ");

        if (!nombre.isEmpty() && precio > 0 && stock > 0) {
            modelo.agregarProducto(new Producto(nombre, precio, stock));
            vista.mostrarMensaje("Producto registrado.");
        } else {
            vista.mostrarMensaje("Datos invalidos.");
        }
    }

    public void listarProductos() {
        vista.mostrarProductos(modelo.getProductos());
    }

    public void agregarAlCarrito() {
        listarProductos();
        int n = vista.leerEntero("Numero del producto: ");

        if (modelo.agregarAlCarrito(n - 1)) {
            vista.mostrarMensaje("Producto agregado al carrito.");
        } else {
            vista.mostrarMensaje("Producto invalido o sin stock.");
        }
    }

    public void verCarrito() {
        vista.mostrarProductos(modelo.getCarrito());
        vista.mostrarMensaje("Subtotal: S/ " + modelo.subtotal());
        vista.mostrarMensaje("Descuento: S/ " + modelo.descuento());
        vista.mostrarMensaje("Envio: S/ " + modelo.envio());
        vista.mostrarMensaje("Total: S/ " + modelo.total());
    }

    public void eliminarDelCarrito() {
        vista.mostrarProductos(modelo.getCarrito());
        int n = vista.leerEntero("Numero a eliminar: ");

        if (modelo.eliminarDelCarrito(n - 1)) {
            vista.mostrarMensaje("Producto eliminado.");
        } else {
            vista.mostrarMensaje("Numero invalido.");
        }
    }

    public void comprar(String usuario) {
        if (modelo.comprar(usuario)) {
            vista.mostrarMensaje("Compra realizada correctamente.");
        } else {
            vista.mostrarMensaje("El carrito esta vacio o hay un problema de stock.");
        }
    }
}

