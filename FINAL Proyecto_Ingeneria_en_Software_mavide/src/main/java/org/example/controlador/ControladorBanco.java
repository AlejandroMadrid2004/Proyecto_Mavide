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

        // Agregamos los mouseListener de los botones
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);

        // Agregamos el mouseListener de la tabla
        this.view.getTblTarjeta().addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        ImageIcon icono = new ImageIcon("bien.png");

        // Controlador boton cargar
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarDatos();
            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();

        }

        //Controlador boton agregar
        if (e.getSource() == this.view.getBtnAgregar()) {
            Banco banco = new Banco();
            banco.setId_banco(Integer.parseInt(this.view.getTxtIdB().getText()));
            banco.setNumero(Integer.parseInt(this.view.getTxtNumero().getText()));
            banco.setUrl(this.view.getTxtUrl().getText());

            if (modelo.agregarBanco(banco)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE, icono);
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Revisa la conexión", "Error al insertar",
                        JOptionPane.ERROR_MESSAGE);
            }

            modelo.cargarDatos();
            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();
        }

        //Controlador del anuncio
        if (e.getSource() == this.view.getTblTarjeta()) {
            Icon error = new ImageIcon("mal.png");
            int index = this.view.getTblTarjeta().getSelectedRow();
            Banco temp = modelo.getBancoAtIndex(index);

            try {
                this.view.getImagenTarjeta().setIcon(temp.getImagen());
                this.view.getImagenTarjeta().setText("");
            } catch (MalformedURLException mfue) {
                this.view.getImagenTarjeta().setIcon(error);
                JOptionPane.showMessageDialog(view, "La URL que se registró no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
            }
        }

        //Controlador Boton Borrar
        if (e.getSource() == this.view.getBtnBorrar()) {
            int row = this.view.getTblTarjeta().getSelectedRow();
            String index = String.valueOf(this.modelo.getValueAt(row, 0));

            System.out.println(index);

            int respuesta = JOptionPane.showConfirmDialog(view, "¿Estás seguro de borrar el registro?", "Selecciona una opción",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                modelo.eliminarDatos(index);
                JOptionPane.showMessageDialog(view, "El registro fue borrado", "Aviso", JOptionPane.INFORMATION_MESSAGE, icono);
            } else {
                JOptionPane.showMessageDialog(view, "El objeto no fue eliminado", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }

            modelo.cargarDatos();
            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();
        }

        //Controlador Boton Actualizar
        if (e.getSource() == this.view.getBtnActualizar()) {
            int row = this.view.getTblTarjeta().getSelectedRow();
            String index = String.valueOf(this.modelo.getValueAt(row, 0));

            Banco banco = new Banco();
            banco.setNumero(Integer.parseInt(this.view.getTxtNumero2().getText()));
            banco.setUrl(this.view.getTxtUrl2().getText());
            banco.setId_banco(Integer.parseInt(index));

            if (modelo.updateBanco(banco)) {
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
