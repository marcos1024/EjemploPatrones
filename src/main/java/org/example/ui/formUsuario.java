package org.example.ui;

import org.example.facade.AppFacade;
import org.example.modelo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formUsuario {
    private JPanel panelPrincipal;
    private JTextField textIdUsuario;
    private JTextField textNombre;
    private JTextField textEmail;
    private JButton btnRegistrarUsuario;
    private JTable jTListadoUsuario;
    private JButton btnBuscarXId;
    private JTextField txtBuscarId;
    private JLabel LbResultadoBusqueda;

    private final AppFacade facade;
    private final DefaultTableModel modeloTabla;

    public formUsuario(AppFacade facade) {
        this.facade = facade;

        panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        textIdUsuario = new JTextField(35);
        textNombre = new JTextField(35);
        textEmail = new JTextField(35);
        btnRegistrarUsuario = new JButton("Registrar Usuario");
        modeloTabla = new DefaultTableModel(new Object[]{"Id", "Nombre", "Email"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        txtBuscarId = new JTextField(35);
        btnBuscarXId = new JButton("Buscar Usuario");
        LbResultadoBusqueda = new JLabel("Resultado Buscado");
        jTListadoUsuario = new JTable(modeloTabla);

        gbc.gridx = 0; gbc.gridy = 0;
        panelPrincipal.add(new JLabel("Id Usuario"), gbc);
        gbc.gridx = 1;
        panelPrincipal.add(textIdUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelPrincipal.add(new JLabel("Nombre"), gbc);
        gbc.gridx = 1;
        panelPrincipal.add(textNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelPrincipal.add(new JLabel("Email"), gbc);
        gbc.gridx = 1;
        panelPrincipal.add(textEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panelPrincipal.add(btnRegistrarUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panelPrincipal.add(new JScrollPane(jTListadoUsuario), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 5;
        panelPrincipal.add(new JLabel("Buscar por Id"), gbc);
        gbc.gridx = 1;
        panelPrincipal.add(txtBuscarId, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        panelPrincipal.add(btnBuscarXId, gbc);

        gbc.gridx = 0; gbc.gridy = 7;
        panelPrincipal.add(LbResultadoBusqueda, gbc);

        btnRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facade.registrarUsuario(textNombre.getText(), textEmail.getText());
                textNombre.setText("");
                textEmail.setText("");
                cargarUsuarios();
            }
        });

        cargarUsuarios();
        btnBuscarXId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LbResultadoBusqueda.setText(facade.obtenerUsuarioPorId(Long.valueOf(txtBuscarId.getText())).toString());
            }
        });
    }

    private void cargarUsuarios() {
        modeloTabla.setRowCount(0);
        for (Usuario u : facade.obtenerTodosLosUsuarios()) {
            modeloTabla.addRow(new Object[]{u.getId(), u.getNombre(), u.getEmail()});
        }
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
