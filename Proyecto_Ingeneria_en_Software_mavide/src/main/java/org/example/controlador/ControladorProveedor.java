package org.example.controlador;
import org.example.modelo.Proveedor;
import org.example.modelo.ModeloTablaProveedor;
import org.example.vista.VentanaProveedor;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.net.MalformedURLException;
public class ControladorProveedor extends MouseAdapter{

    private VentanaProveedor view;
    private ModeloTablaProveedor modelo;

    //Agregamos el constructor de el controlador


    public ControladorProveedor(VentanaProveedor view) {
        //Agregamos el modelo de la tabla
        this.view = view;
        modelo = new ModeloTablaProveedor();
        this.view.getTblTarjeta().setModel(modelo);

        //Agregamos los mouseListener de los botones
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);

        //Agregamos el mouseListener de la tabla
        this.view.getTblTarjeta().addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e){
        ImageIcon icono = new ImageIcon("bien.png");


        //Controlador boton cargar
        if(e.getSource() == this.view.getBtnCargar()){
            modelo.cargarDatos();

            this.view.getTblTarjeta().setModel(modelo);
            this.view.getTblTarjeta().updateUI();
            this.view.limpiar();
        }

        //Controlador boton agregar

        if (e.getSource() == this.view.getBtnAgregar()){
            Proveedor proveedor = new Proveedor();
            proveedor.setId_proveedor(this.view.getTxtIdP().getText());
            proveedor.setCalle(this.view.getTxtCalle().getText());
            proveedor.setNumero(Integer.parseInt(this.view.getTxtNumero().getText()));
            proveedor.setColonia(this.view.getTxtColonia().getText());
            proveedor.setRfc(this.view.getTxtRfc().getText());
            proveedor.setTelefono_1(Integer.parseInt(this.view.getTxtTelefono1().getText()));
            proveedor.setTelefono_2(Integer.parseInt(this.view.getTxtTelefono2().getText()));
            proveedor.setEmailp(this.view.getLblEmailp().getText());
            proveedor.setCuenta(Integer.parseInt(this.view.getTxtCuenta().getText()));
            proveedor.setId_banco(Integer.parseInt(this.view.getTxtIdBanco().getText()));
            proveedor.setEnvio(Integer.parseInt(this.view.getTxtEnvio().getText()));
            proveedor.setUrl(this.view.getTxtUrl().getText());

            if(modelo.agregarProveedor(proveedor)){
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
            Proveedor temp = modelo.getProveedorAtIndex(index);

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

            Proveedor proveedor = new Proveedor();

            //proveedor.setId_proveedor(this.view.getTxtIdP2().getText());
            proveedor.setCalle(this.view.getTxtCalle2().getText());
            proveedor.setNumero(Integer.parseInt(this.view.getTxtNumero2().getText()));
            proveedor.setColonia(this.view.getTxtColonia2().getText());
            proveedor.setRfc(this.view.getTxtRfc2().getText());
            proveedor.setTelefono_1(Integer.parseInt(this.view.getTxtTelefono12().getText()));
            proveedor.setTelefono_2(Integer.parseInt(this.view.getTxtTelefono22().getText()));
            proveedor.setEmailp(this.view.getLblEmailp2().getText());
            proveedor.setCuenta(Integer.parseInt(this.view.getTxtCuenta2().getText()));
            proveedor.setId_banco(Integer.parseInt(this.view.getTxtIdBanco2().getText()));
            proveedor.setEnvio(Integer.parseInt(this.view.getTxtEnvio2().getText()));
            proveedor.setUrl(this.view.getTxtUrl2().getText());
            proveedor.setId_proveedor(index);

            if (modelo.updateProveedor(proveedor)) {
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


