package Modelo;

public class Jugador {
    private int id;
    private String nombre;
    private String posicion;

    public Jugador(int id, String nombre, String posicion) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + posicion + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if (!(obj instanceof Jugador)) {
        	return false;
        }
        Jugador jugador = (Jugador) obj;
        return id == jugador.id;
    }
}