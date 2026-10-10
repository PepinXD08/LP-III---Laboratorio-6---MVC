package Laboratorio_8;

import java.util.ArrayList;
import java.util.List;

public class UsuarioModelo {
    private List<Usuario> usuarios = new ArrayList<>();

    public boolean registrar(String nombre, String usuario,
                             String contrasena) {
        if (nombre.isBlank() || usuario.isBlank()
                || contrasena.isBlank()) {
            return false;
        }

        for (Usuario u : usuarios) {
            if (u.getUsuario().equalsIgnoreCase(usuario)) {
                return false;
            }
        }

        usuarios.add(new Usuario(nombre, usuario, contrasena));
        return true;
    }

    public Usuario iniciarSesion(String usuario, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equalsIgnoreCase(usuario)
                    && u.validarContrasena(contrasena)) {
                return u;
            }
        }

        return null;
    }
}
