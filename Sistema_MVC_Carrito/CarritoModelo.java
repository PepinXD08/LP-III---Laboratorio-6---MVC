package Laboratorio_8;
import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {
    private List<Producto> productos = new ArrayList<>();
    private List<Producto> carrito = new ArrayList<>();
    private List<Compra> historial = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public List<Compra> getHistorial() {
        return historial;
    }

    public boolean agregarAlCarrito(int indice) {
        if (indice < 0 || indice >= productos.size()) {
            return false;
        }

        Producto p = productos.get(indice);
        int cantidad = 0;

        for (Producto item : carrito) {
            if (item == p) {
                cantidad++;
            }
        }

        if (cantidad >= p.getStock()) {
            return false;
        }

        carrito.add(p);
        return true;
    }

    public boolean eliminarDelCarrito(int indice) {
        if (indice < 0 || indice >= carrito.size()) {
            return false;
        }

        carrito.remove(indice);
        return true;
    }

    public double subtotal() {
        double total = 0;

        for (Producto p : carrito) {
            total += p.getPrecio();
        }

        return total;
    }

    public double descuento() {
        if (subtotal() >= 200) {
            return subtotal() * 0.15;
        }

        if (subtotal() >= 100) {
            return subtotal() * 0.10;
        }

        return 0;
    }

    public double envio() {
        return carrito.isEmpty() || subtotal() >= 150 ? 0 : 10;
    }

    public double total() {
        return subtotal() - descuento() + envio();
    }

    public boolean comprar(String usuario) {
        if (carrito.isEmpty()) {
            return false;
        }

        for (Producto p : carrito) {
            if (p.getStock() <= 0) {
                return false;
            }
        }

        double monto = total();

        for (Producto p : carrito) {
            p.reducirStock();
        }

        historial.add(new Compra(usuario,
                new ArrayList<>(carrito), monto));

        carrito.clear();
        return true;
    }

    public boolean comproProducto(String usuario, String producto) {
        for (Compra c : historial) {
            if (c.getUsuario().equalsIgnoreCase(usuario)) {
                for (String p : c.getProductos()) {
                    if (p.equalsIgnoreCase(producto)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
