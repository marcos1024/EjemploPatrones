package org.example.ui;

import org.example.facade.AppFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formUsuario {
    private JPanel panelPrincipal;
    private JTextField textIdUsuario;
    private JTextField textNombre;
    private JTextField textEmail;
    private JButton btnRegistrarUsuario;

    private final AppFacade facade;

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

        btnRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facade.registrarUsuario(textNombre.getText(), textEmail.getText());
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
