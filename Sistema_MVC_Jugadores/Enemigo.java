package EJERCICIO3;

import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;
    private Random random;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
        this.random = new Random();
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public String getTipo() { return tipo; }

    public int atacar() {
        int danoBase = 4 * nivel;
        if (random.nextInt(100) < 20) {
            return danoBase * 2;
        }
        return danoBase;
    }

    public void recibirDano(int dano) {
        this.salud -= dano;
        if (this.salud < 0) this.salud = 0;
    }
}