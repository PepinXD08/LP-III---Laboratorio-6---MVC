package EJERCICIO3;

public class CombateController {
    private Jugador jugador;
    private Enemigo enemigo;
    private CombateView vista;

    public CombateController(Jugador jugador, Enemigo enemigo, CombateView vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("\n¡Un " + enemigo.getNombre() + " salvaje ha aparecido!");
        boolean combateActivo = true;

        while (combateActivo && jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            vista.mostrarEstado(jugador, enemigo);
            String accion = vista.solicitarAccion();

            switch (accion) {
                case "1":
                    int danoJugador = jugador.atacar();
                    enemigo.recibirDano(danoJugador);
                    vista.mostrarMensaje("Has atacado causando " + danoJugador + " de daño.");
                    break;
                case "2":
                    Item pocion = jugador.getInventario().buscarItem("Pocion de Salud");
                    if (pocion != null && pocion.getCantidad() > 0) {
                        jugador.usarObjeto(pocion);
                        vista.mostrarMensaje("Te curaste 20 puntos de salud.");
                    } else {
                        vista.mostrarMensaje("No tienes pociones disponibles. ¡Pierdes el turno!");
                    }
                    break;
                case "3":
                    vista.mostrarMensaje("Has escapado del combate.");
                    combateActivo = false;
                    continue;
                default:
                    vista.mostrarMensaje("Acción inválida. ¡Pierdes el turno!");
            }

            if (enemigo.getSalud() > 0 && combateActivo) {
                int danoEnemigo = enemigo.atacar();
                jugador.recibirDano(danoEnemigo);
                vista.mostrarMensaje("El " + enemigo.getNombre() + " te ataca causando " + danoEnemigo + " de daño.");
            }
        }

        if (jugador.getSalud() <= 0) {
            vista.mostrarMensaje("¡Has sido derrotado en combate!");
        } else if (enemigo.getSalud() <= 0) {
            vista.mostrarMensaje("¡Has derrotado al " + enemigo.getNombre() + "!");
        }
    }
}