package org.example;

import org.example.facade.AppFacade;
import org.example.modelo.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AppFacade sistema = new AppFacade();
        System.out.println("=== INICIANDO PRUEBA DE PATRONES DE DISEÑO ===");

        sistema.registrarUsuario("Carlos Gomez", "carlos@email.com");
        sistema.registrarUsuario("Ana Martinez", "ana@email.com");
        sistema.registrarUsuario("Maria Perez", "mperez@email.com");
        sistema.registrarUsuario("Pedro Lopez", "plopez@email.com");

        List<Usuario> lista = sistema.obtenerTodosLosUsuarios();
        System.out.println("\n[Main] Usuarios registrados en el sistema:");
        for (Usuario u : lista) {
            System.out.println(" - " + u);
        }

        Usuario buscado = sistema.obtenerUsuarioPorId(1L);
        if (buscado != null) {
            System.out.println("[Main] Usuario encontrado: " + buscado.getNombre());
        }

        sistema.finalizarAplicacion();
        System.out.println("=== PRUEBA FINALIZADA CON ÉXITO ===");


    }
}