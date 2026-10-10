package EJERCICIO3;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item armaEquipada;

    public Jugador(String nombre, int salud, int nivel, InventarioModel inventario) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = inventario;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public InventarioModel getInventario() { return inventario; }

    public void equiparArma(Item arma) {
        if (arma != null && arma.getTipo().equalsIgnoreCase("Arma")) {
            this.armaEquipada = arma;
        }
    }

    public int atacar() {
        int danoBase = 5 * nivel;
        if (armaEquipada != null) {
            return danoBase + 10;
        }
        return danoBase;
    }

    public void usarObjeto(Item item) {
        if (item != null && item.getCantidad() > 0 && item.getTipo().equalsIgnoreCase("Poción")) {
            this.salud += 20;
            item.usarItem();
        }
    }

    public void recibirDano(int dano) {
        this.salud -= dano;
        if (this.salud < 0) this.salud = 0;
    }
}