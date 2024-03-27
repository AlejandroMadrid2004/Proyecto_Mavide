package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPedido extends JFrame {

    // Labels
    private JLabel lblIdPedido;
    private JLabel lblIdClientes;
    private JLabel lblIdProducto;
    private JLabel lblIdProveedor;
    private JLabel lblPrecio;
    private JLabel lblRfc;
    private JLabel lblDetalles;
    private JLabel lblFecha;
    private JLabel lblUrl;

    private JLabel imagenTarjeta;

    // TextFields
    private JTextField txtIdPedido;
    private JTextField txtIdClientes;
    private JTextField txtIdProducto;
    private JTextField txtIdProveedor;
    private JTextField txtPrecio;
    private JTextField txtRfc;
    private JTextField txtDetalles;
    private JTextField txtFecha;
    private JTextField txtUrl;

    //Label 2
    private JLabel lblIdPedido2;
    private JLabel lblIdClientes2;
    private JLabel lblIdProducto2;
    private JLabel lblIdProveedor2;
    private JLabel lblPrecio2;
    private JLabel lblRfc2;
    private JLabel lblDetalles2;
    private JLabel lblFecha2;
    private JLabel lblUrl2;

    private JLabel imagenTarjeta2;

    // TextFields
    private JTextField txtIdPedido2;
    private JTextField txtIdClientes2;
    private JTextField txtIdProducto2;
    private JTextField txtIdProveedor2;
    private JTextField txtPrecio2;
    private JTextField txtRfc2;
    private JTextField txtDetalles2;
    private JTextField txtFecha2;
    private JTextField txtUrl2;

    // Botones
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnBorrar;
    private JButton btnActualizar;

    // Tabla
    private JTable tblTarjeta;
    private JScrollPane scrollPane;

    // Paneles
    private JPanel panel1; // Formulario para capturar datos
    private JPanel panel2; // Tabla para mostrar base de datos
    private JPanel panel3; // Imagen URL
    private JPanel panel4; // Boton Eliminar y Actualizar datos

    public VentanaPedido(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 800);

        // Panel 1
        panel1 = new JPanel(new GridLayout(10, 2));
        panel1.setBackground(new Color(248, 183, 183));

        // Labels
        lblIdPedido = new JLabel("ID Pedido");
        lblIdClientes = new JLabel("ID Clientes:");
        lblIdProducto = new JLabel("ID Producto:");
        lblIdProveedor = new JLabel("ID Proveedor:");
        lblPrecio = new JLabel("Precio:");
        lblRfc = new JLabel("RFC:");
        lblDetalles = new JLabel("Detalles:");
        lblFecha = new JLabel("Fecha:");
        lblUrl = new JLabel("URL:");

        // TextFields
        txtIdPedido = new JTextField(20);
        txtIdClientes = new JTextField(20);
        txtIdProducto = new JTextField(20);
        txtIdProveedor = new JTextField(20);
        txtPrecio = new JTextField(10);
        txtRfc = new JTextField(15);
        txtDetalles = new JTextField(30);
        txtFecha = new JTextField(20);
        txtUrl = new JTextField(30);

        // Botones
        btnAgregar = new JButton("Agregar");

        // Añadir componentes al panel 1

        //Id_Pedido
        panel1.add(lblIdPedido);
        panel1.add(txtIdPedido);

        //Id_Clientes
        panel1.add(lblIdClientes);
        panel1.add(txtIdClientes);

        //Id_Producto
        panel1.add(lblIdProducto);
        panel1.add(txtIdProducto);

        //Id_Proveedor
        panel1.add(lblIdProveedor);
        panel1.add(txtIdProveedor);

        //Precio
        panel1.add(lblPrecio);
        panel1.add(txtPrecio);

        //Rfc
        panel1.add(lblRfc);
        panel1.add(txtRfc);

        //Detalles
        panel1.add(lblDetalles);
        panel1.add(txtDetalles);

        //Fecha
        panel1.add(lblFecha);
        panel1.add(txtFecha);

        //Url
        panel1.add(lblUrl);
        panel1.add(txtUrl);

        //Boton Agregar
        panel1.add(btnAgregar);

        // Panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(219, 198, 246));
        btnCargar = new JButton("Cargar");

        // Añadir botón al panel 2
        panel2.add(btnCargar);

        // Crear tabla y JScrollPane
        tblTarjeta = new JTable();
        scrollPane = new JScrollPane(tblTarjeta);

        // Añadir JScrollPane al panel 2
        panel2.add(scrollPane);

        // Panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(246, 244, 197));

        //Agregamos la imagen
        imagenTarjeta = new JLabel("");
        panel3.add(imagenTarjeta);

        // Panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(150, 216, 219));
        btnBorrar = new JButton("Borrar");
        btnActualizar = new JButton("Actualizar");

        // Añadir botones al panel 4
        panel4.add(btnBorrar);
        panel4.add(btnActualizar);

        // Labels
        lblIdPedido2 = new JLabel("ID Pedido");
        lblIdClientes2 = new JLabel("ID Clientes:");
        lblIdProducto2 = new JLabel("ID Producto:");
        lblIdProveedor2 = new JLabel("ID Proveedor:");
        lblPrecio2 = new JLabel("Precio:");
        lblRfc2 = new JLabel("RFC:");
        lblDetalles2 = new JLabel("Detalles:");
        lblFecha2 = new JLabel("Fecha:");
        lblUrl2 = new JLabel("URL:");

        // TextFields
        txtIdPedido2 = new JTextField(20);
        txtIdClientes2 = new JTextField(20);
        txtIdProducto2 = new JTextField(20);
        txtIdProveedor2 = new JTextField(20);
        txtPrecio2 = new JTextField(10);
        txtRfc2 = new JTextField(15);
        txtDetalles2 = new JTextField(30);
        txtFecha2 = new JTextField(20);
        txtUrl2 = new JTextField(30);

        // Añadir componentes al panel 4


        //Id_Pedido
        panel4.add(lblIdPedido2);
        panel4.add(txtIdPedido2);

        //Id_Clientes
        panel4.add(lblIdClientes2);
        panel4.add(txtIdClientes2);

        //Id_Producto
        panel4.add(lblIdProducto2);
        panel4.add(txtIdProducto2);

        //Id_Proveedor
        panel4.add(lblIdProveedor2);
        panel4.add(txtIdProveedor2);

        //Precio
        panel4.add(lblPrecio2);
        panel4.add(txtPrecio2);

        //Rfc
        panel4.add(lblRfc2);
        panel4.add(txtRfc2);

        //Detalles
        panel4.add(lblDetalles2);
        panel4.add(txtDetalles2);

        //Fecha
        panel4.add(lblFecha2);
        panel4.add(txtFecha2);

        //Url
        panel4.add(lblUrl2);
        panel4.add(txtUrl2);

        // Añadir paneles al JFrame
        this.getContentPane().setLayout(new GridLayout(2, 2));
        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblIdPedido() {
        return lblIdPedido;
    }

    public void setLblIdPedido(JLabel lblIdPedido) {
        this.lblIdPedido = lblIdPedido;
    }

    public JLabel getLblIdClientes() {
        return lblIdClientes;
    }

    public void setLblIdClientes(JLabel lblIdClientes) {
        this.lblIdClientes = lblIdClientes;
    }

    public JLabel getLblIdProducto() {
        return lblIdProducto;
    }

    public void setLblIdProducto(JLabel lblIdProducto) {
        this.lblIdProducto = lblIdProducto;
    }

    public JLabel getLblIdProveedor() {
        return lblIdProveedor;
    }

    public void setLblIdProveedor(JLabel lblIdProveedor) {
        this.lblIdProveedor = lblIdProveedor;
    }

    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    public void setLblPrecio(JLabel lblPrecio) {
        this.lblPrecio = lblPrecio;
    }

    public JLabel getLblRfc() {
        return lblRfc;
    }

    public void setLblRfc(JLabel lblRfc) {
        this.lblRfc = lblRfc;
    }

    public JLabel getLblDetalles() {
        return lblDetalles;
    }

    public void setLblDetalles(JLabel lblDetalles) {
        this.lblDetalles = lblDetalles;
    }

    public JLabel getLblFecha() {
        return lblFecha;
    }

    public void setLblFecha(JLabel lblFecha) {
        this.lblFecha = lblFecha;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtIdPedido() {
        return txtIdPedido;
    }

    public void setTxtIdPedido(JTextField txtIdPedido) {
        this.txtIdPedido = txtIdPedido;
    }

    public JTextField getTxtIdClientes() {
        return txtIdClientes;
    }

    public void setTxtIdClientes(JTextField txtIdClientes) {
        this.txtIdClientes = txtIdClientes;
    }

    public JTextField getTxtIdProducto() {
        return txtIdProducto;
    }

    public void setTxtIdProducto(JTextField txtIdProducto) {
        this.txtIdProducto = txtIdProducto;
    }

    public JTextField getTxtIdProveedor() {
        return txtIdProveedor;
    }

    public void setTxtIdProveedor(JTextField txtIdProveedor) {
        this.txtIdProveedor = txtIdProveedor;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(JTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public JTextField getTxtRfc() {
        return txtRfc;
    }

    public void setTxtRfc(JTextField txtRfc) {
        this.txtRfc = txtRfc;
    }

    public JTextField getTxtDetalles() {
        return txtDetalles;
    }

    public void setTxtDetalles(JTextField txtDetalles) {
        this.txtDetalles = txtDetalles;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(JTextField txtFecha) {
        this.txtFecha = txtFecha;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getLblIdPedido2() {
        return lblIdPedido2;
    }

    public void setLblIdPedido2(JLabel lblIdPedido2) {
        this.lblIdPedido2 = lblIdPedido2;
    }

    public JLabel getLblIdClientes2() {
        return lblIdClientes2;
    }

    public void setLblIdClientes2(JLabel lblIdClientes2) {
        this.lblIdClientes2 = lblIdClientes2;
    }

    public JLabel getLblIdProducto2() {
        return lblIdProducto2;
    }

    public void setLblIdProducto2(JLabel lblIdProducto2) {
        this.lblIdProducto2 = lblIdProducto2;
    }

    public JLabel getLblIdProveedor2() {
        return lblIdProveedor2;
    }

    public void setLblIdProveedor2(JLabel lblIdProveedor2) {
        this.lblIdProveedor2 = lblIdProveedor2;
    }

    public JLabel getLblPrecio2() {
        return lblPrecio2;
    }

    public void setLblPrecio2(JLabel lblPrecio2) {
        this.lblPrecio2 = lblPrecio2;
    }

    public JLabel getLblRfc2() {
        return lblRfc2;
    }

    public void setLblRfc2(JLabel lblRfc2) {
        this.lblRfc2 = lblRfc2;
    }

    public JLabel getLblDetalles2() {
        return lblDetalles2;
    }

    public void setLblDetalles2(JLabel lblDetalles2) {
        this.lblDetalles2 = lblDetalles2;
    }

    public JLabel getLblFecha2() {
        return lblFecha2;
    }

    public void setLblFecha2(JLabel lblFecha2) {
        this.lblFecha2 = lblFecha2;
    }

    public JLabel getLblUrl2() {
        return lblUrl2;
    }

    public void setLblUrl2(JLabel lblUrl2) {
        this.lblUrl2 = lblUrl2;
    }

    public JTextField getTxtIdPedido2() {
        return txtIdPedido2;
    }

    public void setTxtIdPedido2(JTextField txtIdPedido2) {
        this.txtIdPedido2 = txtIdPedido2;
    }

    public JTextField getTxtIdClientes2() {
        return txtIdClientes2;
    }

    public void setTxtIdClientes2(JTextField txtIdClientes2) {
        this.txtIdClientes2 = txtIdClientes2;
    }

    public JTextField getTxtIdProducto2() {
        return txtIdProducto2;
    }

    public void setTxtIdProducto2(JTextField txtIdProducto2) {
        this.txtIdProducto2 = txtIdProducto2;
    }

    public JTextField getTxtIdProveedor2() {
        return txtIdProveedor2;
    }

    public void setTxtIdProveedor2(JTextField txtIdProveedor2) {
        this.txtIdProveedor2 = txtIdProveedor2;
    }

    public JTextField getTxtPrecio2() {
        return txtPrecio2;
    }

    public void setTxtPrecio2(JTextField txtPrecio2) {
        this.txtPrecio2 = txtPrecio2;
    }

    public JTextField getTxtRfc2() {
        return txtRfc2;
    }

    public void setTxtRfc2(JTextField txtRfc2) {
        this.txtRfc2 = txtRfc2;
    }

    public JTextField getTxtDetalles2() {
        return txtDetalles2;
    }

    public void setTxtDetalles2(JTextField txtDetalles2) {
        this.txtDetalles2 = txtDetalles2;
    }

    public JTextField getTxtFecha2() {
        return txtFecha2;
    }

    public void setTxtFecha2(JTextField txtFecha2) {
        this.txtFecha2 = txtFecha2;
    }

    public JTextField getTxtUrl2() {
        return txtUrl2;
    }

    public void setTxtUrl2(JTextField txtUrl2) {
        this.txtUrl2 = txtUrl2;
    }

    public JLabel getImagenTarjeta() {
        return imagenTarjeta;
    }

    public void setImagenTarjeta(JLabel imagenTarjeta) {
        this.imagenTarjeta = imagenTarjeta;
    }

    public JLabel getImagenTarjeta2() {
        return imagenTarjeta2;
    }

    public void setImagenTarjeta2(JLabel imagenTarjeta2) {
        this.imagenTarjeta2 = imagenTarjeta2;
    }

    public JTable getTblTarjeta() {
        return tblTarjeta;
    }

    public void setTblTarjeta(JTable tblTarjeta) {
        this.tblTarjeta = tblTarjeta;
    }

    public void limpiar(){

        txtIdPedido.setText("");
        txtIdClientes.setText("");
        txtIdProducto.setText("");
        txtIdProveedor.setText("");
        txtPrecio.setText("");
        txtRfc.setText("");
        txtDetalles.setText("");
        txtFecha.setText("");
        txtUrl.setText("");

        txtIdPedido2.setText("");
        txtIdClientes2.setText("");
        txtIdProducto2.setText("");
        txtIdProveedor2.setText("");
        txtPrecio2.setText("");
        txtRfc2.setText("");
        txtDetalles2.setText("");
        txtFecha2.setText("");
        txtUrl2.setText("");

    }

}

