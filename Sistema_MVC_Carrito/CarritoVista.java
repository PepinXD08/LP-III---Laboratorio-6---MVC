package Laboratorio_8;

import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private Scanner scanner;

    public CarritoVista(Scanner scanner) {
        this.scanner = scanner;
    }

    public String leer(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        try {
            return Integer.parseInt(leer(mensaje));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public double leerDecimal(String mensaje) {
        try {
            return Double.parseDouble(leer(mensaje));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }

        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
