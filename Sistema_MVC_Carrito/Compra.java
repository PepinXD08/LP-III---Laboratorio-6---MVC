package Laboratorio_8;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String usuario;
    private List<String> productos;
    private double total;

    public Compra(String usuario, List<Producto> carrito, double total) {
        this.usuario = usuario;
        this.productos = new ArrayList<>();

        for (Producto p : carrito) {
            productos.add(p.getNombre());
        }

        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public List<String> getProductos() {
        return productos;
    }

    public String toString() {
        return "Usuario: " + usuario + " | Productos: "
                + productos + " | Total: S/ " + total;
    }
}
