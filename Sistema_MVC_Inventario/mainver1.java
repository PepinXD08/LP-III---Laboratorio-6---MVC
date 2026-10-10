package EJERCICIO3;

public class mainver1 {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);

        Item espada = new Item("Espada Larga", 1, "Arma", "Espada básica de hierro.");
        Item pocion = new Item("Poción de Salud", 5, "Poción", "Restaura 50 puntos de salud al usuario.");

        controlador.agregarItem(espada);
        controlador.agregarItem(pocion);

        controlador.verInventario();

        controlador.buscarItem("Espada Larga");
        controlador.mostrarDetalles("Poción de Salud");

        controlador.eliminarItem(pocion);
        controlador.verInventario();
    }
}