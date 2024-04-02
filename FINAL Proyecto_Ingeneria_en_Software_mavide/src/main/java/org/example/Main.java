package org.example;

import org.example.controlador.*;
import org.example.vista.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal("Proyecto Mavide");
                ControladorPrincipal controladorPrincipal = new ControladorPrincipal(ventanaPrincipal);
                ventanaPrincipal.setVisible(true);
            }
        });






    }
}
