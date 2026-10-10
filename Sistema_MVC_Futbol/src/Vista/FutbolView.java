package Vista;

import java.util.Scanner;
import Controlador.FutbolController;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partido;
import Excepciones.*;

public class FutbolView {
    private Scanner scanner;
    private FutbolController controller;

    public FutbolView(FutbolController controller) {
        this.scanner = new Scanner(System.in);
        this.controller = controller;
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (opcion) {
                    case 1:
                        registrarEquipo();
                        break;
                    case 2:
                        mostrarEquipos();
                        break;
                    case 3:
                        registrarJugador();
                        break;
                    case 4:
                        agregarJugadorEquipo();
                        break;
                    case 5:
                        registrarPartido();
                        break;
                    case 6:
                        mostrarUltimoPartido();
                        break;
                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (FutbolException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 7);
    }

    private void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE FÚTBOL =====");
        System.out.println("1. Registrar equipo");
        System.out.println("2. Mostrar equipos");
        System.out.println("3. Registrar jugador");
        System.out.println("4. Agregar jugador a equipo");
        System.out.println("5. Registrar partido");
        System.out.println("6. Mostrar último partido");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void registrarEquipo() throws DatoInvalidoException, EquipoYaRegistradoException {
        System.out.print("ID del equipo: ");
        int id = leerEntero();

        System.out.print("Nombre del equipo: ");
        String nombre = scanner.nextLine();

        controller.registrarEquipo(new Equipo(id, nombre));
        System.out.println("Equipo registrado correctamente");
    }

    private void mostrarEquipos() {
        System.out.println("\n===== EQUIPOS =====");

        for (Equipo equipo : controller.listarEquipos()) {
            System.out.println(equipo);
        }
    }

    private void registrarJugador() throws DatoInvalidoException, JugadorYaRegistradoException {
        System.out.print("ID del jugador: ");
        int id = leerEntero();

        System.out.print("Nombre del jugador: ");
        String nombre = scanner.nextLine();

        System.out.print("Posición: ");
        String posicion = scanner.nextLine();

        controller.registrarJugador(new Jugador(id, nombre, posicion));
        System.out.println("Jugador registrado correctamente");
    }

    private void agregarJugadorEquipo() throws DatoInvalidoException, EquipoNoEncontradoException, JugadorNoEncontradoException, JugadorYaRegistradoException, EquipoCompletoException {
        System.out.print("ID del equipo: ");
        int idEquipo = leerEntero();

        System.out.print("ID del jugador: ");
        int idJugador = leerEntero();

        controller.agregarJugadorEquipo(idEquipo, idJugador);
        System.out.println("Jugador agregado al equipo");
    }

    private void registrarPartido() throws DatoInvalidoException, EquipoNoEncontradoException, PartidoInvalidoException, ResultadoInvalidoException {
        System.out.print("ID del equipo local: ");
        int idLocal = leerEntero();

        System.out.print("ID del equipo visitante: ");
        int idVisitante = leerEntero();

        System.out.print("Goles del local: ");
        int golesLocal = leerEntero();

        System.out.print("Goles del visitante: ");
        int golesVisitante = leerEntero();

        controller.registrarPartido(idLocal, idVisitante, golesLocal, golesVisitante);
        System.out.println("Partido registrado correctamente");
    }

    private void mostrarUltimoPartido() {
        Partido partido = controller.obtenerUltimoPartido();
        if (partido == null) {
            System.out.println("No hay partidos registrados");
        } else {
            System.out.println("\nÚltimo partido:");
            System.out.println(partido);
        }
    }
    
    private int leerEntero() throws DatoInvalidoException {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new DatoInvalidoException("Dato incorrecto");
        }
    }
}