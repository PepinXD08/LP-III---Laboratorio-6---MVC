package Laboratorio_8;

import java.util.Scanner;

public class UsuarioVista {
    private Scanner scanner;

    public UsuarioVista(Scanner scanner) {
        this.scanner = scanner;
    }

    public String leer(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMenu() {
        System.out.println("\n1. Registrarse");
        System.out.println("2. Iniciar sesion");
        System.out.println("3. Salir");
    }
}

