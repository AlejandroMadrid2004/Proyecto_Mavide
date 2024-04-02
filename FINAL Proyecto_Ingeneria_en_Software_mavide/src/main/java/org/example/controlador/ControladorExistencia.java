package org.example.controlador;

import org.example.modelo.Existencia;
import org.example.modelo.ModeloTablaExistencia;
import org.example.vista.VentanaExistencia;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorExistencia extends MouseAdapter {

    private VentanaExistencia view;
    private ModeloTablaExistencia modelo;

    public ControladorExistencia(VentanaExistencia view) {
        this.view = view;
        modelo = new ModeloTablaExistencia();
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

        //Controlador boton Agregar
        if (e.getSource() == this.view.getBtnAgregar()) {

            Existencia existencia = new Existencia();
            existencia.setId_producto(Integer.parseInt(this.view.getTxtid_producto().getText()));
            existencia.setId_proveedor(this.view.getTxtid_proveedor().getText());
            existencia.setCantidad(Integer.parseInt(this.view.getTxtcantidad().getText()));
            existencia.setFecha(this.view.getTxtfecha().getText());
            existencia.setUrl(this.view.getTxturl().getText());

            if (modelo.agregarExistencia(existencia)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE, icono);
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos.  Revisa la conexión", "Error al insertar",
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
            Existencia temporal = modelo.getExistenciaAtIndex(index);

            try {
                this.view.getImagenTarjeta().setIcon(temporal.getImagen());
                this.view.getImagenTarjeta().setText("");
            } catch (MalformedURLException mfue) {
                this.view.getImagenTarjeta().setIcon(error);
                JOptionPane.showMessageDialog(view, "La URL que se registro no es correcta.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
            }
        }
        if (e.getSource() == this.view.getBtnBorrar()) {
            int row = this.view.getTblTarjeta().getSelectedRow();
            int id = Integer.parseInt(String.valueOf(this.modelo.getValueAt(row, 0)));

            System.out.println(id);

            int respuesta = JOptionPane.showConfirmDialog(view, "¿Estas seguro de borrar el registro?", "Selecciona una opción",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_NO_OPTION) {
                modelo.eliminarDatos(id);
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
            int id = Integer.parseInt(String.valueOf(this.modelo.getValueAt(row, 0)));

            Existencia existencia = new Existencia();
            existencia.setId_producto(Integer.parseInt(this.view.getTxtid_producto2().getText()));
            existencia.setId_proveedor(this.view.getTxtid_proveedor2().getText());
            existencia.setCantidad(Integer.parseInt(this.view.getTxtcantidad2().getText()));
            existencia.setFecha(this.view.getTxtfecha2().getText());
            existencia.setUrl(this.view.getTxturl2().getText());

            if (modelo.updateExistencia(existencia)) {
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
