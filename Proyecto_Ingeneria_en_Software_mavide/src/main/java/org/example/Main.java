package org.example;

import org.example.controlador.*;
import org.example.vista.*;

public class Main {
    public static void main(String[] args) {

    /*
        VentanaProveedor view = new VentanaProveedor("Prueba 2");
        ControladorProveedor controller = new ControladorProveedor(view);

        VentanaBanco view = new VentanaBanco("Prueba 3");
        ControladorBanco controller = new ControladorBanco(view);


        VentanaExistencia view = new VentanaExistencia("Prueba 4");
        ControladorExistencia controller = new ControladorExistencia(view);


        VentanaClientes view = new VentanaClientes("Prueba 5");
        ControladorClientes controller = new ControladorClientes(view);


        VentanaPedido view = new VentanaPedido("Prueba 6");
        ControladorPedido controller = new ControladorPedido(view);
     */

        VentanaListaPrecio view = new VentanaListaPrecio("Prueba 7");
        ControladorListaPrecio controller = new ControladorListaPrecio(view);

    }
}
