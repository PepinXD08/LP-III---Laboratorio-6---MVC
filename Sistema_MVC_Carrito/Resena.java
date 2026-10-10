package Laboratorio_8;

public class Resena {
    private String usuario;
    private String producto;
    private int calificacion;
    private String comentario;

    public Resena(String usuario, String producto, int calificacion,
                  String comentario) {
        this.usuario = usuario;
        this.producto = producto;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getProducto() {
        return producto;
    }

    public String toString() {
        return producto + " | " + usuario + " | "
                + calificacion + "/5 | " + comentario;
    }
}
