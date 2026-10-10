package Excepciones;

public class JugadorYaRegistradoException extends FutbolException {
    public JugadorYaRegistradoException(String mensaje) {
        super(mensaje);
    }
}