package org.example.controlador;

import org.example.modelo.ListaPrecio;
import org.example.modelo.ModeloTablaListaPrecio;
import org.example.vista.VentanaListaPrecio;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorListaPrecio extends MouseAdapter {

    private VentanaListaPrecio view;
    private ModeloTablaListaPrecio modelo;

    public ControladorListaPrecio(VentanaListaPrecio view) {
        this.view = view;
        modelo = new ModeloTablaListaPrecio();
        this.view.getTblTarjeta().setModel(modelo);

        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);

        this.view.getTblTarjeta().addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        ImageIcon icono = new ImageIcon("bien.png");

        if (e.getSource() == this.view.getBtnCargar()) {

            modelo.cargarDatos();

            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();

        }

        // Controlador boton Agregar
        if (e.getSource() == this.view.getBtnAgregar()) {
            ListaPrecio listaPrecio = new ListaPrecio();
            int row = this.view.getTblTarjeta().getSelectedRow();
            int index = Integer.parseInt(String.valueOf(this.modelo.getValueAt(row,0)));

            listaPrecio.setId_precios(Integer.parseInt(this.view.getTxtIdLista().getText()));
            listaPrecio.setId_productos(this.view.getTxtIdProducto().getText());
            listaPrecio.setCosto(Double.parseDouble(this.view.getTxtCosto().getText()));
            listaPrecio.setVolumen(this.view.getTxtVolumen().getText());
            listaPrecio.setFecha(this.view.getTxtFecha().getText());
            listaPrecio.setUrl(this.view.getTxtUrl().getText());

            if (modelo.agregarListaPrecio(listaPrecio)) {
                JOptionPane.showMessageDialog(view, "Se agregó correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE, icono);
            } else {
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
            ListaPrecio temporal = modelo.getListaPrecioAtIndex(index);

            try {
                this.view.getImagenTarjeta().setIcon(temporal.getImagen());
                this.view.getImagenTarjeta().setText("");
            } catch (MalformedURLException mfue) {
                this.view.getImagenTarjeta().setIcon(error);
                JOptionPane.showMessageDialog(view, "La URL que se registró no es correcta.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
            }
        }

        if (e.getSource() == this.view.getBtnBorrar()) {
            int row = this.view.getTblTarjeta().getSelectedRow();
            String index = String.valueOf(this.modelo.getValueAt(row, 0));

            System.out.println(index);

            int respuesta = JOptionPane.showConfirmDialog(view, "¿Estás seguro de borrar el registro?", "Selecciona una opción",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_NO_OPTION) {
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

        if (e.getSource() == this.view.getBtnActualizar()) {
            int row = this.view.getTblTarjeta().getSelectedRow();
            int index = Integer.parseInt(String.valueOf(this.modelo.getValueAt(row,0)));

            ListaPrecio listaPrecio = new ListaPrecio();

            listaPrecio.setId_precios(Integer.parseInt(this.view.getTxtIdLista2().getText()));
            listaPrecio.setId_productos(this.view.getTxtIdProducto2().getText());
            listaPrecio.setCosto(Double.parseDouble(this.view.getTxtCosto2().getText()));
            listaPrecio.setVolumen(this.view.getTxtVolumen2().getText());
            listaPrecio.setFecha(this.view.getTxtFecha2().getText());
            listaPrecio.setUrl(this.view.getTxtUrl2().getText());

            if (modelo.updateListaPrecio(listaPrecio)) {
                JOptionPane.showMessageDialog(view, "Se modificó correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE, icono);
            } else {
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

