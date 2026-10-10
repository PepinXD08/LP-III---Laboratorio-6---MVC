package Repository;

import java.util.ArrayList;

public interface IRepositorio<T> {
    void agregar(T elemento);
    ArrayList<T> listar();
}