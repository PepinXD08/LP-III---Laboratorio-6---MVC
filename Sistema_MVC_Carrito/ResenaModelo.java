package Laboratorio_8;

import java.util.ArrayList;
import java.util.List;

public class ResenaModelo {
    private List<Resena> resenas = new ArrayList<>();
    private CarritoModelo carritoModelo;

    public ResenaModelo(CarritoModelo carritoModelo) {
        this.carritoModelo = carritoModelo;
    }

    public boolean agregar(String usuario, String producto,
                           int calificacion, String comentario) {
        if (producto.isBlank() || comentario.isBlank()
                || calificacion < 1 || calificacion > 5) {
            return false;
        }

        if (!carritoModelo.comproProducto(usuario, producto)) {
            return false;
        }

        for (Resena r : resenas) {
            if (r.getUsuario().equalsIgnoreCase(usuario)
                    && r.getProducto().equalsIgnoreCase(producto)) {
                return false;
            }
        }

        resenas.add(new Resena(usuario, producto,
                calificacion, comentario));
        return true;
    }

    public List<Resena> getResenas() {
        return resenas;
    }
}
