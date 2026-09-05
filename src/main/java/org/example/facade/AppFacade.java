package org.example.facade;

import org.example.conexion.ConexionBD;
import org.example.dao.UsuarioDAO;
import org.example.dao.UsuarioDAOImpl;
import org.example.modelo.Usuario;

import java.util.List;

public class AppFacade {
    private final UsuarioDAO usuarioDAO;

    public AppFacade() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    public void registrarUsuario(String nombre, String email) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setEmail(email);
        System.out.println("[Facade] Coordinando el registro de un nuevo usuario...");
        usuarioDAO.insertar(nuevoUsuario);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        System.out.println("[Facade] Solicitando la lista completa de usuarios...");
        return usuarioDAO.listarTodos();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        System.out.println("[Facade] Solicitando usuario con ID: " + id);
        return usuarioDAO.buscarPorId(id);
    }

    public void finalizarAplicacion() {
        System.out.println("[Facade] Cerrando recursos del sistema...");
        ConexionBD.cerrarConexion();
    }
}
