package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaListaPrecio extends JFrame {

    //Label 1

    // Labels
    private JLabel lblIdLista;
    private JLabel lblIdProducto;
    private JLabel lblCosto;
    private JLabel lblVolumen;
    private JLabel lblFecha;
    private JLabel lblUrl;

    private JLabel imagenTarjeta;

    // TextFields
    private JTextField txtIdLista;
    private JTextField txtIdProducto;
    private JTextField txtCosto;
    private JTextField txtVolumen;
    private JTextField txtFecha;
    private JTextField txtUrl;

    // Label 2
    private JLabel lblIdLista2;
    private JLabel lblIdProducto2;
    private JLabel lblCosto2;
    private JLabel lblVolumen2;
    private JLabel lblFecha2;
    private JLabel lblUrl2;

    private JLabel imagenTarjeta2;

    // TextFields 2
    private JTextField txtIdLista2;
    private JTextField txtIdProducto2;
    private JTextField txtCosto2;
    private JTextField txtVolumen2;
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
    private GridLayout layout;

    // Paneles
    private JPanel panel1; // Formulario para capturar datos
    private JPanel panel2; // Tabla para mostrar base de datos
    private JPanel panel3; // Imagen URL
    private JPanel panel4; // Boton Eliminar y Actualizar datos

    public VentanaListaPrecio(String title) throws HeadlessException{
        super(title);
        this.setSize(800, 800);
        layout = new GridLayout(2, 2);

        // Panel 1
        panel1 = new JPanel(new GridLayout(7, 2));
        panel1.setBackground(new Color(248, 183, 183));


        // Labels
        lblIdLista = new JLabel("ID Lista");
        lblIdProducto = new JLabel("ID Producto:");
        lblCosto = new JLabel("Costo:");
        lblVolumen = new JLabel("Volumen:");
        lblFecha = new JLabel("Fecha:");
        lblUrl = new JLabel("URL:");

        // Damos valores a las opciones de la tabla
        txtIdLista = new JTextField(20);
        txtIdProducto = new JTextField(20);
        txtCosto = new JTextField(10);
        txtVolumen = new JTextField(15);
        txtFecha = new JTextField(20);
        txtUrl = new JTextField(30);
        btnAgregar = new JButton("Agregar");

        // Agregamos los valores
        panel1.add(lblIdLista);
        panel1.add(txtIdLista);

        panel1.add(lblIdProducto);
        panel1.add(txtIdProducto);

        panel1.add(lblCosto);
        panel1.add(txtCosto);

        panel1.add(lblVolumen);
        panel1.add(txtVolumen);

        panel1.add(lblFecha);
        panel1.add(txtFecha);

        panel1.add(lblUrl);
        panel1.add(txtUrl);

        panel1.add(btnAgregar);

        // Panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(219, 198, 246));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);

        tblTarjeta = new JTable();
        scrollPane = new JScrollPane(tblTarjeta);
        panel2.add(scrollPane);

        // Panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(246, 244, 197));
        imagenTarjeta = new JLabel("");
        panel3.add(imagenTarjeta);

        // Panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(150, 216, 219));
        btnBorrar = new JButton("Borrar");
        btnActualizar = new JButton("Actualizar");
        panel4.add(btnBorrar);
        panel4.add(btnActualizar);

        // Labels 2
        lblIdLista2 = new JLabel("ID Lista");
        lblIdProducto2 = new JLabel("ID Producto:");
        lblCosto2 = new JLabel("Costo:");
        lblVolumen2 = new JLabel("Volumen:");
        lblFecha2 = new JLabel("Fecha:");
        lblUrl2 = new JLabel("URL:");

        // TextFields 2
        txtIdLista2 = new JTextField(20);
        txtIdProducto2 = new JTextField(20);
        txtCosto2 = new JTextField(10);
        txtVolumen2 = new JTextField(15);
        txtFecha2 = new JTextField(20);
        txtUrl2 = new JTextField(30);

        panel4.add(lblIdLista2);
        panel4.add(txtIdLista2);

        panel4.add(lblIdProducto2);
        panel4.add(txtIdProducto2);

        panel4.add(lblCosto2);
        panel4.add(txtCosto2);

        panel4.add(lblVolumen2);
        panel4.add(txtVolumen2);

        panel4.add(lblFecha2);
        panel4.add(txtFecha2);

        panel4.add(lblUrl2);
        panel4.add(txtUrl2);


        //Ponemos los paneles
        this.getContentPane().setLayout(new GridLayout(2,2));
        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblIdLista() {
        return lblIdLista;
    }

    public void setLblIdLista(JLabel lblIdLista) {
        this.lblIdLista = lblIdLista;
    }

    public JLabel getLblIdProducto() {
        return lblIdProducto;
    }

    public void setLblIdProducto(JLabel lblIdProducto) {
        this.lblIdProducto = lblIdProducto;
    }

    public JLabel getLblCosto() {
        return lblCosto;
    }

    public void setLblCosto(JLabel lblCosto) {
        this.lblCosto = lblCosto;
    }

    public JLabel getLblVolumen() {
        return lblVolumen;
    }

    public void setLblVolumen(JLabel lblVolumen) {
        this.lblVolumen = lblVolumen;
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

    public JLabel getImagenTarjeta() {
        return imagenTarjeta;
    }

    public void setImagenTarjeta(JLabel imagenTarjeta) {
        this.imagenTarjeta = imagenTarjeta;
    }

    public JTextField getTxtIdLista() {
        return txtIdLista;
    }

    public void setTxtIdLista(JTextField txtIdLista) {
        this.txtIdLista = txtIdLista;
    }

    public JTextField getTxtIdProducto() {
        return txtIdProducto;
    }

    public void setTxtIdProducto(JTextField txtIdProducto) {
        this.txtIdProducto = txtIdProducto;
    }

    public JTextField getTxtCosto() {
        return txtCosto;
    }

    public void setTxtCosto(JTextField txtCosto) {
        this.txtCosto = txtCosto;
    }

    public JTextField getTxtVolumen() {
        return txtVolumen;
    }

    public void setTxtVolumen(JTextField txtVolumen) {
        this.txtVolumen = txtVolumen;
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

    public JLabel getLblIdLista2() {
        return lblIdLista2;
    }

    public void setLblIdLista2(JLabel lblIdLista2) {
        this.lblIdLista2 = lblIdLista2;
    }

    public JLabel getLblIdProducto2() {
        return lblIdProducto2;
    }

    public void setLblIdProducto2(JLabel lblIdProducto2) {
        this.lblIdProducto2 = lblIdProducto2;
    }

    public JLabel getLblCosto2() {
        return lblCosto2;
    }

    public void setLblCosto2(JLabel lblCosto2) {
        this.lblCosto2 = lblCosto2;
    }

    public JLabel getLblVolumen2() {
        return lblVolumen2;
    }

    public void setLblVolumen2(JLabel lblVolumen2) {
        this.lblVolumen2 = lblVolumen2;
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

    public JLabel getImagenTarjeta2() {
        return imagenTarjeta2;
    }

    public void setImagenTarjeta2(JLabel imagenTarjeta2) {
        this.imagenTarjeta2 = imagenTarjeta2;
    }

    public JTextField getTxtIdLista2() {
        return txtIdLista2;
    }

    public void setTxtIdLista2(JTextField txtIdLista2) {
        this.txtIdLista2 = txtIdLista2;
    }

    public JTextField getTxtIdProducto2() {
        return txtIdProducto2;
    }

    public void setTxtIdProducto2(JTextField txtIdProducto2) {
        this.txtIdProducto2 = txtIdProducto2;
    }

    public JTextField getTxtCosto2() {
        return txtCosto2;
    }

    public void setTxtCosto2(JTextField txtCosto2) {
        this.txtCosto2 = txtCosto2;
    }

    public JTextField getTxtVolumen2() {
        return txtVolumen2;
    }

    public void setTxtVolumen2(JTextField txtVolumen2) {
        this.txtVolumen2 = txtVolumen2;
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

    public JTable getTblTarjeta() {
        return tblTarjeta;
    }

    public void setTblTarjeta(JTable tblTarjeta) {
        this.tblTarjeta = tblTarjeta;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
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

    public void limpiar(){

        txtIdLista.setText("");
        txtIdProducto.setText("");
        txtCosto.setText("");
        txtVolumen.setText("");
        txtFecha.setText("");
        txtUrl.setText("");

        txtIdLista2.setText("");
        txtIdProducto2.setText("");
        txtCosto2.setText("");
        txtVolumen2.setText("");
        txtFecha2.setText("");
        txtUrl2.setText("");

    }

}
