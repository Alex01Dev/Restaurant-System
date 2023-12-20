/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteamli;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author alexm
 */
public class VentanaRestaurante extends JFrame {
    private JTextArea areaTexto;

    public VentanaRestaurante() {
        super("Lista de Pedidos del Restaurante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane);

        setLocationRelativeTo(null);
        setVisible(true);
    }

  public void mostrarLista(pilaClientes inicio) {
        areaTexto.setText(""); // Limpiar el área de texto

        if (!listaVacia(inicio)) {
            pilaClientes recorrido = inicio;

            while (recorrido != null) {
                areaTexto.append("\n[--Turno: " + recorrido.dato + " --Platillo: " + recorrido.platillo
                        + " --Bebida: " + recorrido.bebida + " --Postre: " + recorrido.postre
                        + " --Costo: " + recorrido.costo + "--]");
                recorrido = recorrido.siguiente;
            }
        } else {
            areaTexto.setText("--- No hay turnos para mostrar ---");
        }
    }

    private boolean listaVacia(pilaClientes inicio) {
        return inicio == null;
    }
}