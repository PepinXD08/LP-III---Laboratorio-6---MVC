package Controlador;

import java.util.ArrayList;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partido;
import Repository.Repositorio;
import Repository.Pila;
import Excepciones.*;

public class FutbolController {
    private Repositorio<Equipo> equipos;
    private Repositorio<Jugador> jugadores;
    private Pila<Partido> partidos;

    public FutbolController() {
        equipos = new Repositorio<>();
        jugadores = new Repositorio<>();
        partidos = new Pila<>();
    }

    public void registrarEquipo(Equipo equipo) throws EquipoYaRegistradoException {
        for (Equipo e : equipos.listar()) {
            if (e.equals(equipo)) {
                throw new EquipoYaRegistradoException("El equipo ya está registrado");
            }
        }
        equipos.agregar(equipo);
    }

    public void registrarJugador(Jugador jugador) throws JugadorYaRegistradoException {
        for (Jugador j : jugadores.listar()) {
            if (j.equals(jugador)) {
                throw new JugadorYaRegistradoException("El jugador ya está registrado");
            }
        }
        jugadores.agregar(jugador);
    }

    public void agregarJugadorEquipo(int idEquipo, int idJugador) throws EquipoNoEncontradoException, JugadorNoEncontradoException, JugadorYaRegistradoException, EquipoCompletoException {
        Equipo equipo = buscarEquipo(idEquipo);
        Jugador jugador = buscarJugador(idJugador);

        if (equipo.getJugadores().contains(jugador)) {
            throw new JugadorYaRegistradoException("El jugador ya pertenece al equipo");
        }
        if (equipo.getJugadores().size() >= 5) {
            throw new EquipoCompletoException("El equipo ya tiene 5 jugadores");
        }
        equipo.agregarJugador(jugador);
    }

    public void registrarPartido(int idLocal, int idVisitante, int golesLocal, int golesVisitante) throws EquipoNoEncontradoException, PartidoInvalidoException, ResultadoInvalidoException {
        Equipo local = buscarEquipo(idLocal);
        Equipo visitante = buscarEquipo(idVisitante);

        if (local.equals(visitante)) {
            throw new PartidoInvalidoException("Un equipo no puede jugar contra sí mismo");
        }
        if (golesLocal < 0 || golesVisitante < 0) {
            throw new ResultadoInvalidoException("Los goles no pueden ser negativos");
        }
        Partido partido = new Partido(local, visitante, golesLocal, golesVisitante);
        partidos.apilar(partido);
    }

    public ArrayList<Equipo> listarEquipos() {
        return equipos.listar();
    }

    public ArrayList<Jugador> listarJugadores() {
        return jugadores.listar();
    }

    public Partido obtenerUltimoPartido() {
        return partidos.cima();
    }

    private Equipo buscarEquipo(int id) throws EquipoNoEncontradoException {
        for (Equipo equipo : equipos.listar()) {
            if (equipo.getId() == id) {
                return equipo;
            }
        }
        throw new EquipoNoEncontradoException("No se encontró el equipo con ID " + id);
    }

    private Jugador buscarJugador(int id) throws JugadorNoEncontradoException {
        for (Jugador jugador : jugadores.listar()) {
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        throw new JugadorNoEncontradoException("No se encontró el jugador con ID " + id);
    }
}
