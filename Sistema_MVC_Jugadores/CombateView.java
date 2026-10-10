package EJERCICIO3;

import java.util.Scanner;

public class CombateView {
    private Scanner scanner;

    public CombateView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n=== ESTADO DEL COMBATE ===");
        System.out.println(jugador.getNombre() + " (Nvl " + jugador.getNivel() + ") - Salud: " + jugador.getSalud());
        System.out.println(enemigo.getNombre() + " [" + enemigo.getTipo() + "] - Salud: " + enemigo.getSalud());
        System.out.println("==========================");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String solicitarAccion() {
        System.out.println("\n¿Qué deseas hacer?");
        System.out.println("1. Atacar");
        System.out.println("2. Usar Poción");
        System.out.println("3. Huir");
        System.out.print("Selecciona una acción: ");
        return scanner.nextLine();
    }
}