package org.example.controlador;

import org.example.modelo.Banco;
import org.example.modelo.ModeloTablaBanco;
import org.example.vista.VentanaBanco;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorBanco extends MouseAdapter {

    private VentanaBanco view;
    private ModeloTablaBanco modelo;

    public ControladorBanco(VentanaBanco view){
        this.view = view;
        modelo = new ModeloTablaBanco();
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
            Banco banco = new Banco();
            banco.setId_banco(this.view.getTxtIdB().getText());
            banco.setNumero(Integer.parseInt(this.view.getTxtNumero().getText()));
            banco.setUrl(this.view.getTxtUrl().getText());

            if(modelo.agregarBanco(banco)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE, icono);
            }else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Revisa la conexion", "Error al insertar",
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
            Banco temporal = modelo.getBancoAtIndex(index);

            try{
                this.view.getImagenTarjeta().setIcon(temporal.getImagen());
                this.view.getImagenTarjeta().setText("");
            }catch(MalformedURLException mfue){
                this.view.getImagenTarjeta().setIcon(error);
                JOptionPane.showMessageDialog(view,"La URL que se registro no es correcta.","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
            }
        }

        if(e.getSource() == this.view.getBtnBorrar()){
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

        if(e.getSource() == this.view.getBtnActualizar()){
            int row = this.view.getTblTarjeta().getSelectedRow();
            String index = String.valueOf(this.modelo.getValueAt(row,0));

            Banco banco = new Banco();
            banco.setId_banco(this.view.getTxtIdB2().getText());
            banco.setNumero(Integer.parseInt(this.view.getTxtNumero2().getText()));
            banco.setUrl(this.view.getTxtUrl2().getText());

            if(modelo.agregarBanco(banco)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE, icono);
            }else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Revisa la conexion", "Error al insertar",
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
