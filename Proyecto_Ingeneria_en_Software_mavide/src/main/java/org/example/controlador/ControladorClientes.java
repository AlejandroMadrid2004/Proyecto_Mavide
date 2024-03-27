package org.example.controlador;

import org.example.modelo.Clientes;
import org.example.modelo.ModeloTablaClientes;
import org.example.vista.VentanaClientes;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorClientes extends MouseAdapter {
    private VentanaClientes view;
    private ModeloTablaClientes modelo;

    public ControladorClientes(VentanaClientes view) {
        this.view = view;
        modelo = new ModeloTablaClientes();
        this.view.getTblTarjeta().setModel(modelo);

        //Agregamos los mouseListener de los botones
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);

        //Agregamos el mouseListener de la tabla
        this.view.getTblTarjeta().addMouseListener(this);
    }


    public void mouseClicked(MouseEvent e) {
        ImageIcon icono = new ImageIcon("bien.png");


        //Controlador boton cargar
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarDatos();

            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();
        }

        //Controlador boton agregar

        if (e.getSource() == this.view.getBtnAgregar()){
            Clientes clientes = new Clientes();
            clientes.setId_cliente(this.view.getTxtIdC().getText());
            clientes.setCalle(this.view.getTxtCalle().getText());
            clientes.setNumero(Integer.parseInt(this.view.getTxtNumero().getText()));
            clientes.setColonia(this.view.getTxtColonia().getText());
            clientes.setRfc(this.view.getTxtRfc().getText());
            clientes.setEmailc(this.view.getTxtEmailC().getText());
            clientes.setTelefono_1(Integer.parseInt(this.view.getTxtTelefono1().getText()));
            clientes.setTelefono_2(Integer.parseInt(this.view.getTxtTelefono2().getText()));
            clientes.setCuenta(Integer.parseInt(this.view.getTxtCuenta().getText()));
            clientes.setId_banco(Integer.parseInt(this.view.getTxtIdBanco().getText()));
            clientes.setEnvio(Integer.parseInt(this.view.getTxtEnvio().getText()));
            clientes.setUrl(this.view.getTxtUrl().getText());

            if(modelo.agregarCliente(clientes)){
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE, icono);
            }else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Revisa la conexion", "Error al insertar",
                        JOptionPane.ERROR_MESSAGE);
            }

            modelo.cargarDatos();
            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();
        }


        //Controlador del anuncio
        if (e.getSource() == this.view.getTblTarjeta()){

            Icon error = new ImageIcon("mal.png");

            int index = this.view.getTblTarjeta().getSelectedRow();
            Clientes temp = modelo.getClientesAtIndex(index);

            try{
                this.view.getImagenTarjeta().setIcon(temp.getImagen());
                this.view.getImagenTarjeta().setText("");
            }catch(MalformedURLException mfue){
                this.view.getImagenTarjeta().setIcon(error);
                JOptionPane.showMessageDialog(view,"La URL que se registro no es correcta.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
            }

        }


        //Control Boton Borrar
        if (e.getSource() == this.view.getBtnBorrar()){
            int row = this.view.getTblTarjeta().getSelectedRow();
            String index = String.valueOf(this.modelo.getValueAt(row,0));

            System.out.println(index);

            int respuesta = JOptionPane.showConfirmDialog(view, "¿Estas seguro de borrar el registro?","Selecciona una opcion",JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_NO_OPTION){
                modelo.eliminarDatos(index);
                JOptionPane.showMessageDialog(view,"El registro fue borrado","Aviso",JOptionPane.INFORMATION_MESSAGE,icono);
            }else{
                JOptionPane.showMessageDialog(view,"El objeto no fue eliminado","Error al eliminar",JOptionPane.ERROR_MESSAGE);
            }

            modelo.cargarDatos();
            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();
        }


        //Controlador Boton Actualizar
        if(e.getSource() == this.view.getBtnActualizar()) {
            int row = this.view.getTblTarjeta().getSelectedRow();
            String index = String.valueOf(this.modelo.getValueAt(row, 0));

            Clientes clientes = new Clientes();

            //clientes.setId_proveedor(this.view.getTxtIdP2().getText());
            clientes.setCalle(this.view.getTxtCalle2().getText());
            clientes.setNumero(Integer.parseInt(this.view.getTxtNumero2().getText()));
            clientes.setColonia(this.view.getTxtColonia2().getText());
            clientes.setRfc(this.view.getTxtRfc2().getText());
            clientes.setEmailc(this.view.getTxtEmailC2().getText());
            clientes.setTelefono_1(Integer.parseInt(this.view.getTxtTelefono12().getText()));
            clientes.setTelefono_2(Integer.parseInt(this.view.getTxtTelefono22().getText()));
            clientes.setCuenta(Integer.parseInt(this.view.getTxtCuenta2().getText()));
            clientes.setId_banco(Integer.parseInt(this.view.getTxtIdBanco2().getText()));
            clientes.setEnvio(Integer.parseInt(this.view.getTxtEnvio2().getText()));
            clientes.setUrl(this.view.getTxtUrl2().getText());
            clientes.setId_cliente(index);

            if (modelo.updateCliente(clientes)) {
                JOptionPane.showMessageDialog(view, "Se ha modificado el registro", "Aviso", JOptionPane.INFORMATION_MESSAGE, icono);
                this.view.getTblTarjeta().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo modificar", "Error", JOptionPane.ERROR_MESSAGE);
                this.view.getTblTarjeta().updateUI();
            }

            modelo.cargarDatos();
            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();
        }
        this.view.getTblTarjeta().updateUI();

    }
}


