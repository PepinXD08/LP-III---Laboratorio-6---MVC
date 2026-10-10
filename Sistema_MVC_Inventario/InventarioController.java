package EJERCICIO3;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem(Item item) {
        modelo.agregarItem(item);
        vista.mostrarMensaje("Se ha agregado al inventario: " + item.getNombre());
    }

    public void eliminarItem(Item item) {
        modelo.eliminarItem(item);
        vista.mostrarMensaje("Se ha eliminado del inventario: " + item.getNombre());
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void buscarItem(String nombre) {
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarMensaje("Item encontrado: " + item.getNombre() + " (" + item.getTipo() + ")");
        } else {
            vista.mostrarMensaje("No se encontró el item con nombre: " + nombre);
        }
    }

    public void mostrarDetalles(String nombre) {
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }
}