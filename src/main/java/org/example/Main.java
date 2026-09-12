package org.example;

import org.example.facade.AppFacade;
import org.example.modelo.Usuario;
import org.example.ui.formUsuario;
import org.example.ui.formV2;

import javax.swing.*;
import javax.swing.SwingUtilities;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        AppFacade sistema = new AppFacade();
//        System.out.println("=== INICIANDO PRUEBA DE PATRONES DE DISEÑO ===");
//
//        sistema.registrarUsuario("Carlos Gomez", "carlos@email.com");
//        sistema.registrarUsuario("Ana Martinez", "ana@email.com");
//        sistema.registrarUsuario("Maria Perez", "mperez@email.com");
//        sistema.registrarUsuario("Pedro Lopez", "plopez@email.com");
//
//        List<Usuario> lista = sistema.obtenerTodosLosUsuarios();
//        System.out.println("\n[Main] Usuarios registrados en el sistema:");
//        for (Usuario u : lista) {
//            System.out.println(" - " + u);
//        }
//
//        Usuario buscado = sistema.obtenerUsuarioPorId(1L);
//        if (buscado != null) {
//            System.out.println("[Main] Usuario encontrado: " + buscado.getNombre());
//        }
//
//        sistema.finalizarAplicacion();
//        System.out.println("=== PRUEBA FINALIZADA CON ÉXITO ===");

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Alta de usuarios");

            formV2 form = new formV2(new AppFacade());
            frame.setContentPane(form.getJPanelFormV2());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });



    }
}