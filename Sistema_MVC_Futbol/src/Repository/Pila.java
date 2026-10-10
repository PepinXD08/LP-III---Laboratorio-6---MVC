package Repository;

import java.util.ArrayList;

public class Pila<T> {
    private ArrayList<T> elementos;

    public Pila() {
        elementos = new ArrayList<>();
    }

    public void apilar(T elemento) {
        elementos.add(elemento);
    }

    public T desapilar() {
        if (elementos.isEmpty()) {
            return null;
        }
        return elementos.remove(elementos.size() - 1);
    }

    public T cima() {
        if (elementos.isEmpty()) {
            return null;
        }
        return elementos.get(elementos.size() - 1);
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }
}
