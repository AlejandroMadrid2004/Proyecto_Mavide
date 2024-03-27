package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaExistencia extends JFrame {

    //Label 1
    private JLabel lblid_producto;
    private JLabel lblid_proveedor;
    private JLabel lblcantidad;
    private JLabel lblfecha;
    private JLabel lblurl;

    private JLabel imagenTarjeta;

    //TextField 1
    private JTextField txtid_producto;
    private JTextField txtid_proveedor;
    private JTextField txtcantidad;
    private JTextField txtfecha;
    private JTextField txturl;

    //Label 2
    private JLabel lblid_producto2;
    private JLabel lblid_proveedor2;
    private JLabel lblcantidad2;
    private JLabel lblfecha2;
    private JLabel lblurl2;

    //TextField 2
    private JTextField txtid_producto2;
    private JTextField txtid_proveedor2;
    private JTextField txtcantidad2;
    private JTextField txtfecha2;
    private JTextField txturl2;

    //Botones
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnBorrar;
    private JButton btnActualizar;

    //Tabla
    private JTable tblTarjeta;
    private JScrollPane scrollPane;
    private GridLayout layout;

    //Paneles
    private JPanel panel1;//Formulario para capturar datos
    private JPanel panel2;//Tabla para mostrar base de datos
    private JPanel panel3;//Imagen URL
    private JPanel panel4;//Boton Eliminar y Actualizar datos

    public VentanaExistencia(String title) throws HeadlessException{
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2,2);

        //Panel 1

        panel1 = new JPanel(new GridLayout(6,2));
        panel1.setBackground(new Color(248,183,183));

        //Labels
        lblid_producto = new JLabel("Id_Producto");
        lblid_proveedor = new JLabel("Id_Proveedor");
        lblcantidad = new JLabel("Cantidad");
        lblfecha = new JLabel("Fecha:");
        lblurl = new JLabel("Foto:");

        //Damos valores a las opciones de la tabla
        txtid_producto = new JTextField(6);
        txtid_proveedor = new JTextField(20);
        txtcantidad = new JTextField(4);
        txtfecha = new JTextField(6);
        txturl = new JTextField(30);
        btnAgregar = new JButton("Agregar");

        //Agregamos los valores

        //id_producto
        panel1.add(lblid_producto);
        panel1.add(txtid_producto);

        //id_proveedor
        panel1.add(lblid_proveedor);
        panel1.add(txtid_proveedor);

        //cantidad
        panel1.add(lblcantidad);
        panel1.add(txtcantidad);

        //fecha
        panel1.add(lblfecha);
        panel1.add(txtfecha);

        //url
        panel1.add(lblurl);
        panel1.add(txturl);

        //Boton Agregar
        panel1.add(btnAgregar);

        //Panel 2

        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(219, 198, 246));
        btnCargar = new JButton("Cargar");
        //Agregamos el boton
        panel2.add(btnCargar, BorderLayout.NORTH);

        //Agregamos la tabla
        tblTarjeta = new JTable();

        //Agregamos el scrollPane
        scrollPane = new JScrollPane(tblTarjeta);
        panel2.add(scrollPane,BorderLayout.CENTER);

        //Panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(246, 244, 197));

        //Agregamos la imagen
        imagenTarjeta = new JLabel("");
        panel3.add(imagenTarjeta);

        //Panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(150, 216, 219));

        //Agregamos el boton Borrar y Actualizar

        btnBorrar = new JButton("Borrar");
        btnActualizar = new JButton("Actualizar");
        panel4.add(btnBorrar);
        panel4.add(btnActualizar);

        //Labels
        lblid_producto2 = new JLabel("Id_Producto");
        lblid_proveedor2 = new JLabel("Id_Proveedor");
        lblcantidad2 = new JLabel("Cantidad");
        lblfecha2 = new JLabel("Fecha:");
        lblurl2 = new JLabel("Foto:");

        //Damos valores a las opciones de la tabla
        txtid_producto2 = new JTextField(6);
        txtid_proveedor2 = new JTextField(20);
        txtcantidad2 = new JTextField(4);
        txtfecha2 = new JTextField(6);
        txturl2 = new JTextField(30);

        //Agregamos los valores

        //id_producto
        panel4.add(lblid_producto2);
        panel4.add(txtid_producto2);

        //id_proveedor
        panel4.add(lblid_proveedor2);
        panel4.add(txtid_proveedor2);

        //cantidad
        panel4.add(lblcantidad2);
        panel4.add(txtcantidad2);

        //fecha
        panel4.add(lblfecha2);
        panel4.add(txtfecha2);

        //url
        panel4.add(lblurl2);
        panel4.add(txturl2);

        //Ponemos los paneles
        this.getContentPane().setLayout(new GridLayout(2,2));
        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public JLabel getLblid_producto() {
        return lblid_producto;
    }

    public void setLblid_producto(JLabel lblid_producto) {
        this.lblid_producto = lblid_producto;
    }

    public JLabel getLblid_proveedor() {
        return lblid_proveedor;
    }

    public void setLblid_proveedor(JLabel lblid_proveedor) {
        this.lblid_proveedor = lblid_proveedor;
    }

    public JLabel getLblcantidad() {
        return lblcantidad;
    }

    public void setLblcantidad(JLabel lblcantidad) {
        this.lblcantidad = lblcantidad;
    }

    public JLabel getLblfecha() {
        return lblfecha;
    }

    public void setLblfecha(JLabel lblfecha) {
        this.lblfecha = lblfecha;
    }

    public JLabel getLblurl() {
        return lblurl;
    }

    public void setLblurl(JLabel lblurl) {
        this.lblurl = lblurl;
    }

    public JLabel getImagenTarjeta() {
        return imagenTarjeta;
    }

    public void setImagenTarjeta(JLabel imagenTarjeta) {
        this.imagenTarjeta = imagenTarjeta;
    }

    public JTextField getTxtid_producto() {
        return txtid_producto;
    }

    public void setTxtid_producto(JTextField txtid_producto) {
        this.txtid_producto = txtid_producto;
    }

    public JTextField getTxtid_proveedor() {
        return txtid_proveedor;
    }

    public void setTxtid_proveedor(JTextField txtid_proveedor) {
        this.txtid_proveedor = txtid_proveedor;
    }

    public JTextField getTxtcantidad() {
        return txtcantidad;
    }

    public void setTxtcantidad(JTextField txtcantidad) {
        this.txtcantidad = txtcantidad;
    }

    public JTextField getTxtfecha() {
        return txtfecha;
    }

    public void setTxtfecha(JTextField txtfecha) {
        this.txtfecha = txtfecha;
    }

    public JTextField getTxturl() {
        return txturl;
    }

    public void setTxturl(JTextField txturl) {
        this.txturl = txturl;
    }

    public JLabel getLblid_producto2() {
        return lblid_producto2;
    }

    public void setLblid_producto2(JLabel lblid_producto2) {
        this.lblid_producto2 = lblid_producto2;
    }

    public JLabel getLblid_proveedor2() {
        return lblid_proveedor2;
    }

    public void setLblid_proveedor2(JLabel lblid_proveedor2) {
        this.lblid_proveedor2 = lblid_proveedor2;
    }

    public JLabel getLblcantidad2() {
        return lblcantidad2;
    }

    public void setLblcantidad2(JLabel lblcantidad2) {
        this.lblcantidad2 = lblcantidad2;
    }

    public JLabel getLblfecha2() {
        return lblfecha2;
    }

    public void setLblfecha2(JLabel lblfecha2) {
        this.lblfecha2 = lblfecha2;
    }

    public JLabel getLblurl2() {
        return lblurl2;
    }

    public void setLblurl2(JLabel lblurl2) {
        this.lblurl2 = lblurl2;
    }

    public JTextField getTxtid_producto2() {
        return txtid_producto2;
    }

    public void setTxtid_producto2(JTextField txtid_producto2) {
        this.txtid_producto2 = txtid_producto2;
    }

    public JTextField getTxtid_proveedor2() {
        return txtid_proveedor2;
    }

    public void setTxtid_proveedor2(JTextField txtid_proveedor2) {
        this.txtid_proveedor2 = txtid_proveedor2;
    }

    public JTextField getTxtcantidad2() {
        return txtcantidad2;
    }

    public void setTxtcantidad2(JTextField txtcantidad2) {
        this.txtcantidad2 = txtcantidad2;
    }

    public JTextField getTxtfecha2() {
        return txtfecha2;
    }

    public void setTxtfecha2(JTextField txtfecha2) {
        this.txtfecha2 = txtfecha2;
    }

    public JTextField getTxturl2() {
        return txturl2;
    }

    public void setTxturl2(JTextField txturl2) {
        this.txturl2 = txturl2;
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
        txtid_producto.setText("");
        txtid_proveedor.setText("");
        txtcantidad.setText("");
        txtfecha.setText("");
        txturl.setText("");

        txtid_producto2.setText("");
        txtid_proveedor2.setText("");
        txtcantidad2.setText("");
        txtfecha2.setText("");
        txturl2.setText("");

    }

}
