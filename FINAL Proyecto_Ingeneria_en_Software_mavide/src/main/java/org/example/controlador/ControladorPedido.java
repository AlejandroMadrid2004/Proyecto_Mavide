package org.example.controlador;

import org.example.modelo.ModeloTablaPedido;
import org.example.modelo.Pedido;
import org.example.vista.VentanaPedido;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorPedido extends MouseAdapter {

    private VentanaPedido view;
    private ModeloTablaPedido modelo;

    public ControladorPedido(VentanaPedido view){
        this.view = view;
        modelo = new ModeloTablaPedido();
        this.view.getTblTarjeta().setModel(modelo);

        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);

        this.view.getTblTarjeta().addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e){
        ImageIcon icono = new ImageIcon("bien.png");

        if(e.getSource() == this.view.getBtnCargar()){

            modelo.cargarDatos();

            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();

        }

        //Controlador boton Agregar
        if(e.getSource() == this.view.getBtnAgregar()){
            Pedido pedido = new Pedido();
            pedido.setId_pedido(Integer.parseInt(this.view.getTxtIdPedido().getText()));
            pedido.setId_clientes(this.view.getTxtIdClientes().getText());
            pedido.setId_producto(this.view.getTxtIdProducto().getText());
            pedido.setId_proveedor(this.view.getTxtIdProveedor().getText());
            pedido.setPrecio(this.view.getTxtPrecio().getText());
            pedido.setRfc(this.view.getTxtRfc().getText());
            pedido.setDetalles(this.view.getTxtDetalles().getText());
            pedido.setFecha(this.view.getTxtFecha().getText());
            pedido.setUrl(this.view.getTxtUrl().getText());

            if(modelo.agregarPedido(pedido)){
                JOptionPane.showMessageDialog(view,"Se agregó correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE, icono);
            }else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Revisa la conexión", "Error al insertar",
                        JOptionPane.ERROR_MESSAGE);
            }

            modelo.cargarDatos();
            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();

        }

        if (e.getSource() == this.view.getTblTarjeta()) {

            Icon error = new ImageIcon("mal.png");

            int index = this.view.getTblTarjeta().getSelectedRow();
            Pedido temporal = modelo.getPedidoAtIndex(index);

            try{
                this.view.getImagenTarjeta().setIcon(temporal.getImagen());
                this.view.getImagenTarjeta().setText("");
            }catch(MalformedURLException mfue){
                this.view.getImagenTarjeta().setIcon(error);
                JOptionPane.showMessageDialog(view,"La URL que se registró no es correcta.","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
            }
        }

        if(e.getSource() == this.view.getBtnBorrar()){
            int row = this.view.getTblTarjeta().getSelectedRow();
            int index = Integer.parseInt(String.valueOf(this.modelo.getValueAt(row,0)));

            System.out.println(index);

            int respuesta = JOptionPane.showConfirmDialog(view, "¿Estás seguro de borrar el registro?","Selecciona una opción",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_NO_OPTION){
                modelo.eliminarDatos(String.valueOf(index));
                JOptionPane.showMessageDialog(view,"El registro fue borrado","Aviso",JOptionPane.INFORMATION_MESSAGE,icono);
            }else{
                JOptionPane.showMessageDialog(view,"El objeto no fue eliminado","Error al eliminar",JOptionPane.ERROR_MESSAGE);
            }

            modelo.cargarDatos();
            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();
        }

        if(e.getSource() == this.view.getBtnActualizar()){
            int row = this.view.getTblTarjeta().getSelectedRow();
            int index = Integer.parseInt(String.valueOf(this.modelo.getValueAt(row,0)));

            Pedido pedido = new Pedido();
            pedido.setId_pedido(Integer.parseInt(this.view.getTxtIdPedido2().getText()));
            pedido.setId_clientes(this.view.getTxtIdClientes2().getText());
            pedido.setId_producto(this.view.getTxtIdProducto2().getText());
            pedido.setId_proveedor(this.view.getTxtIdProveedor2().getText());
            pedido.setPrecio(this.view.getTxtPrecio2().getText());
            pedido.setRfc(this.view.getTxtRfc2().getText());
            pedido.setDetalles(this.view.getTxtDetalles2().getText());
            pedido.setFecha(this.view.getTxtFecha2().getText());
            pedido.setUrl(this.view.getTxtUrl2().getText());

            if(modelo.updatePedido(pedido)){
                JOptionPane.showMessageDialog(view,"Se modificó correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE, icono);
            }else {
                JOptionPane.showMessageDialog(view, "No se pudo modificar en la base de datos. Revisa la conexión", "Error al modificar",
                        JOptionPane.ERROR_MESSAGE);
            }

            modelo.cargarDatos();
            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();
        }
        this.view.getTblTarjeta().updateUI();
    }

}

