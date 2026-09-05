package org.example.dao;

import org.example.modelo.Usuario;

import java.util.List;

public interface UsuarioDAO {
    void insertar(Usuario usuario);
    Usuario buscarPorId(Long id);
    List<Usuario> listarTodos();
}
