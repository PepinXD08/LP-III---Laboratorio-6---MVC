package Laboratorio_8;

public class ResenaControlador {
    private ResenaModelo modelo;
    private ResenaVista vista;
    private CarritoVista entrada;

    public ResenaControlador(ResenaModelo modelo, ResenaVista vista,
                             CarritoVista entrada) {
        this.modelo = modelo;
        this.vista = vista;
        this.entrada = entrada;
    }

    public void registrar(Usuario usuario) {
        String producto = entrada.leer("Producto comprado: ");
        int nota = entrada.leerEntero("Calificacion (1-5): ");
        String comentario = entrada.leer("Comentario: ");

        if (modelo.agregar(usuario.getUsuario(), producto,
                nota, comentario)) {
            System.out.println("Resena registrada.");
        } else {
            System.out.println("No se pudo registrar. Verifique la compra, "
                    + "los datos o si ya califico el producto.");
        }
    }

    public void mostrar() {
        vista.mostrar(modelo.getResenas());
    }
}
