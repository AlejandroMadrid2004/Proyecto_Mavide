package org.example.controlador;

import org.example.vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal {

    private VentanaPrincipal ventanaPrincipal;

    public ControladorPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        asignarAccionesBotones(); // Llamada al método para asignar acciones a los botones
    }

    private void asignarAccionesBotones() {
        ventanaPrincipal.getBtnTablaB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaBanco view = new VentanaBanco("Tabla Banco");
                ControladorBanco controller = new ControladorBanco(view);
            }
        });

        ventanaPrincipal.getBtnTablaC().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaClientes view = new VentanaClientes("Tabla Clientes");
                ControladorClientes controller = new ControladorClientes(view);
            }
        });

        ventanaPrincipal.getBtnTablaE().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaExistencia view = new VentanaExistencia("Tabla Existencia");
                ControladorExistencia controller = new ControladorExistencia(view);
            }
        });

        ventanaPrincipal.getBtnTablaLP().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaListaPrecio view = new VentanaListaPrecio("Tabla Lista de Precios");
                ControladorListaPrecio controllador = new ControladorListaPrecio(view);
            }
        });

        ventanaPrincipal.getBtnTablaPe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPedido view = new VentanaPedido("Tabla Pedidos");
                ControladorPedido controller = new ControladorPedido(view);
            }
        });

        ventanaPrincipal.getBtnTablaPro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaProveedor view = new VentanaProveedor("Tabla Proveedores");
                ControladorProveedor controller = new ControladorProveedor(view);
            }
        });

        ventanaPrincipal.getBtnCerrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CerrarPrograma();
            }
        });

    }

    private void abrirVentanaBanco() {
        VentanaBanco view = new VentanaBanco("Tabla Banco");
        ControladorBanco controller = new ControladorBanco(view);
        view.setVisible(true);
    }

    private void abrirVentanaClientes() {
        VentanaClientes view = new VentanaClientes("Tabla Clientes");
        ControladorClientes controller = new ControladorClientes(view);
        view.setVisible(true);
    }

    private void abrirVentanaExistencia() {
        VentanaExistencia view = new VentanaExistencia("Tabla Existencia");
        ControladorExistencia controller = new ControladorExistencia(view);
        view.setVisible(true);
    }

    private void abrirVentanaListaPrecio() {
        VentanaListaPrecio view = new VentanaListaPrecio("Tabla Lista de Precios");
        ControladorListaPrecio controller = new ControladorListaPrecio(view);
        view.setVisible(true);
    }

    private void abrirVentanaPedido() {
        VentanaPedido view = new VentanaPedido("Tabla Pedidos");
        ControladorPedido controller = new ControladorPedido(view);
        view.setVisible(true);
    }

    private void abrirVentanaProveedor() {
        VentanaProveedor view = new VentanaProveedor("Tabla Proveedores");
        ControladorProveedor controller = new ControladorProveedor(view);
        view.setVisible(true);
    }

    private void CerrarPrograma(){
        int opcion = JOptionPane.showConfirmDialog(ventanaPrincipal,"¿Desea salir?","Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }

}
