package Repository;

import java.util.ArrayList;

public class Repositorio<T> implements IRepositorio<T> {
    private ArrayList<T> elementos;

    public Repositorio() {
        elementos = new ArrayList<>();
    }

    @Override
    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    @Override
    public ArrayList<T> listar() {
        return elementos;
    }
}