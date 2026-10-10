package EJERCICIO3;

public class Main {
    public static void main(String[] args) {
        InventarioModel inventario = new InventarioModel();
        Item espada = new Item("Espada Larga", 1, "Arma", "Espada básica.");
        Item pocion = new Item("Pocion de Salud", 2, "Poción", "Cura salud.");
        inventario.agregarItem(espada);
        inventario.agregarItem(pocion);

        Jugador jugador = new Jugador("Heroe", 100, 2, inventario);
        jugador.equiparArma(espada);
        
        Enemigo orco = new Enemigo("Orco Guerrero", 60, 2, "Monstruo");

        CombateView vistaCombate = new CombateView();
        CombateController controlador = new CombateController(jugador, orco, vistaCombate);

        controlador.iniciarCombate();
    }
}