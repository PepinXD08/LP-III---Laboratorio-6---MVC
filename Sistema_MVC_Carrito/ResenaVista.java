package Laboratorio_8;

import java.util.List;

public class ResenaVista {
    public void mostrar(List<Resena> resenas) {
        if (resenas.isEmpty()) {
            System.out.println("No hay resenas.");
            return;
        }

        for (Resena r : resenas) {
            System.out.println(r);
        }
    }
}
