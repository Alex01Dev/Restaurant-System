/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restauranteamli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestauranteAmli {

    private static JFrame frame;
    private static JPanel panel;
    private static JButton tomarTurnoButton, mostrarTurnosButton, tomarPedidoButton, actualizarPedidoButton,
            corteCajaButton, crearStockButton, salirButton;

    private static metodosRestaurante restaurante = new metodosRestaurante();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Restaurante Amli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));

        // Crear botones con colores
        tomarTurnoButton = createButton("Tomar Turno", Color.GREEN);
        mostrarTurnosButton = createButton("Mostrar Turnos", Color.BLUE);
        tomarPedidoButton = createButton("Tomar Pedido", Color.ORANGE);
        actualizarPedidoButton = createButton("Actualizar Pedido", Color.MAGENTA);
        corteCajaButton = createButton("Corte de Caja", Color.RED);
        crearStockButton = createButton("Crear Stock", Color.CYAN);
        salirButton = createButton("Salir", Color.GRAY);

        // Agregar ActionListener a los botones
        tomarTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int turno = restaurante.tomarNuevoTurno();
                JOptionPane.showMessageDialog(null, "Se ha tomado el turno: " + turno);
            }
        });

        mostrarTurnosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restaurante.mostrarLista();
            }
        });

        tomarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int turno = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Turno del cliente: "));
                restaurante.tomarPedido(turno, 0, 0, 0);
            }
        });

        actualizarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int turno = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Turno del cliente: "));
                restaurante.tomarPedido(turno, 0, 0, 0);
            }
        });

        corteCajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int turno = 0;
                restaurante.mostrarInformacionFinal(turno);
            }
        });

        crearStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restaurante.crearStock();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Agregar botones al panel
        panel.add(tomarTurnoButton);
        panel.add(mostrarTurnosButton);
        panel.add(tomarPedidoButton);
        panel.add(actualizarPedidoButton);
        panel.add(corteCajaButton);
        panel.add(crearStockButton);
        panel.add(salirButton);

        // Agregar panel al frame
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        // Configurar el frame
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setFocusPainted(false); // Quitar el borde al obtener el foco
        return button;
    }
}
