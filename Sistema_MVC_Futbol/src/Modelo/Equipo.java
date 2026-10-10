package Modelo;

import java.util.ArrayList;

public class Equipo {
    private int id;
    private String nombre;
    private ArrayList<Jugador> jugadores;

    public Equipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " | Jugadores: " + jugadores.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if (!(obj instanceof Equipo)) {
        	return false;
        }
        Equipo equipo = (Equipo) obj;
        return id == equipo.id;
    }
}
