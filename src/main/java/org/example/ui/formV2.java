package org.example.ui;

import org.example.facade.AppFacade;
import org.example.modelo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formV2 {

    private JTextField txtIdUsuario;
    private JTextField txtNombre;
    private JTextField txtEmail;
    private JButton btnRegistrarUsuario;
    private JPanel JPanelFormV2;
    private JTable JTablaUsuarios;

    private final AppFacade appFacade;
    private final DefaultTableModel modeloTabla;

    public formV2(AppFacade  appFacade) {
        this.appFacade = appFacade;

        JPanelFormV2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtIdUsuario = new JTextField(40);
        txtNombre = new JTextField(40);
        txtEmail = new JTextField(40);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JPanelFormV2.add(new JLabel("Id Usuario"), gbc);
        gbc.gridx = 1;
        JPanelFormV2.add(txtIdUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JPanelFormV2.add(new JLabel("Nombre"), gbc);
        gbc.gridx = 1;
        JPanelFormV2.add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JPanelFormV2.add(new JLabel("Email"), gbc);
        gbc.gridx = 1;
        JPanelFormV2.add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JPanelFormV2.add(btnRegistrarUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        JPanelFormV2.add(new JScrollPane(JTablaUsuarios), gbc);

        btnRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appFacade.registrarUsuario(txtNombre.getText(), txtEmail.getText());
                JOptionPane.showMessageDialog(null,
                        "Usuario registrado correctamente.",
                        "Alta Usuario",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        });

        modeloTabla = new DefaultTableModel(new Object[]{"Id", "Nombre", "Email"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTablaUsuarios.setModel(modeloTabla);
        cargarUsuariosEnLaTabla();

        JTablaUsuarios.getSelectionModel().addListSelectionListener(e -> {
            // Un click dispara dos eventos (al bajar y al soltar el mouse);
            // con esto nos quedamos solo con el evento final.
            if (e.getValueIsAdjusting()) return;


            int fila = JTablaUsuarios.getSelectedRow();
            if (fila == -1) return;              // no hay nada seleccionado


            // Leo cada columna de esa fila y la paso a los campos.
            // Columnas del modelo: 0 = Id, 1 = Nombre, 2 = Email
            txtIdUsuario.setText(modeloTabla.getValueAt(fila, 0).toString());
            txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
            txtEmail.setText(modeloTabla.getValueAt(fila, 2).toString());
        });


    }


    private void cargarUsuariosEnLaTabla() {
        modeloTabla.setRowCount(0);
        for (Usuario u : appFacade.obtenerTodosLosUsuarios()) {
            modeloTabla.addRow(new Object[]{u.getId(), u.getNombre(), u.getEmail()});
        }
    }
    public JPanel getJPanelFormV2() {
        return JPanelFormV2;
    }


}
