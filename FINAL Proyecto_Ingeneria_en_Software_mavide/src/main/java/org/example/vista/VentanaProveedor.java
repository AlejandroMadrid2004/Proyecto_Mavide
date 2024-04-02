package org.example.vista;

import javax.swing.*;
import java.awt.*;
public class VentanaProveedor extends JFrame{

    //Label 1
    private JLabel lblIdP;
    private JLabel lblCalle;
    private JLabel lblNumero;
    private JLabel lblColonia;
    private JLabel lblRfc;
    private JLabel lblTelefono1;
    private JLabel lblTelefono2;
    private JLabel lblEmailp;
    private JLabel lblCuenta;
    private JLabel lblIdBanco;
    private JLabel lblEnvio;
    private JLabel lblUrl;

    private  JLabel imagenTarjeta;

    //TextField 1
    private JTextField txtIdP;
    private JTextField txtCalle;
    private JTextField txtNumero;
    private JTextField txtColonia;
    private JTextField txtRfc;
    private JTextField txtTelefono1;
    private JTextField txtTelefono2;
    private JTextField txtEmailP;
    private JTextField txtCuenta;
    private JTextField txtIdBanco;
    private JTextField txtEnvio;
    private JTextField txtUrl;

    //Label 2
    private JLabel lblIdP2;
    private JLabel lblCalle2;
    private JLabel lblNumero2;
    private JLabel lblColonia2;
    private JLabel lblRfc2;
    private JLabel lblTelefono12;
    private JLabel lblTelefono22;
    private JLabel lblEmailp2;
    private JLabel lblCuenta2;
    private JLabel lblIdBanco2;
    private JLabel lblEnvio2;
    private JLabel lblUrl2;

    private  JLabel imagenTarjeta2;

    //TextField 1
    private JTextField txtIdP2;
    private JTextField txtCalle2;
    private JTextField txtNumero2;
    private JTextField txtColonia2;
    private JTextField txtRfc2;
    private JTextField txtTelefono12;
    private JTextField txtTelefono22;
    private JTextField txtEmailP2;
    private JTextField txtCuenta2;
    private JTextField txtIdBanco2;
    private JTextField txtEnvio2;
    private JTextField txtUrl2;

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

    public VentanaProveedor(String title) throws HeadlessException{
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2,2);

        //Panel1

        panel1 = new JPanel(new GridLayout(13,2));
        panel1.setBackground(new Color(248,183,183));

        //Labels
        lblIdP = new JLabel("Id_Proveedor:");
        lblCalle = new JLabel("Calle:");
        lblNumero = new JLabel("Numero:");
        lblColonia = new JLabel("Colonia:");
        lblRfc = new JLabel("Rfc:");
        lblTelefono1 = new JLabel("Telefono 1:");
        lblTelefono2 = new JLabel("Telefono 2:");
        lblEmailp = new JLabel("Email_Proveedor:");
        lblCuenta = new JLabel("Cuenta:");
        lblIdBanco= new JLabel("Id_Banco:");
        lblEnvio = new JLabel("Envio:");
        lblUrl = new JLabel("Foto");
/*
        //Desabilitamos id
        txtIdP = new JTextField(1);
        txtIdP.setText("0");
        txtIdP.setEnabled(false);

 */

        //Damos valores a las opciones de la tabla
        txtIdP = new JTextField(20);
        txtCalle = new JTextField(20);
        txtNumero = new JTextField(6);
        txtColonia = new JTextField(20);
        txtRfc = new JTextField(12);
        txtTelefono1 = new JTextField(10);
        txtTelefono2 = new JTextField(10);
        txtEmailP = new JTextField(15);
        txtCuenta = new JTextField(18);
        txtIdBanco = new JTextField(2);
        txtEnvio = new JTextField(2);
        txtUrl = new JTextField(30);
        btnAgregar = new JButton("Agregar");

        //Agregamos los valores

        //IdP
        panel1.add(lblIdP);
        panel1.add(txtIdP);

        //Calle

        panel1.add(lblCalle);
        panel1.add(txtCalle);

        //Numero
        panel1.add(lblNumero);
        panel1.add(txtNumero);

        //Colonia
        panel1.add(lblColonia);
        panel1.add(txtColonia);

        //Rfc
        panel1.add(lblRfc);
        panel1.add(txtRfc);

        //Telefono_1
        panel1.add(lblTelefono1);
        panel1.add(txtTelefono1);

        //Telefono_2
        panel1.add(lblTelefono2);
        panel1.add(txtTelefono2);

        //EmailP
        panel1.add(lblEmailp);
        panel1.add(txtEmailP);

        //Cuenta
        panel1.add(lblCuenta);
        panel1.add(txtCuenta);

        //Id_banco
        panel1.add(lblIdBanco);
        panel1.add(txtIdBanco);

        //Envio
        panel1.add(lblEnvio);
        panel1.add(txtEnvio);

        //Url
        panel1.add(lblUrl);
        panel1.add(txtUrl);

        //Boton Agregar
        panel1.add(btnAgregar);

        //Panel 2

        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(219, 198, 246));
        btnCargar = new JButton("Cargar");

        //Agregamos el boton
        panel2.add(btnCargar);

        //Agregamos la tabla
        tblTarjeta = new JTable();

        //Agregamos el scrollPane
        scrollPane = new JScrollPane(tblTarjeta);
        panel2.add(scrollPane);

        //Panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(246, 244, 197));

        //Agregamos la imagen
        imagenTarjeta = new JLabel("");
        panel3.add(imagenTarjeta);


        //Panel 4

        panel4 = new JPanel(new GridLayout(13,2));
        panel4.setBackground(new Color(150, 216, 219));

        //Agregamos el boton Borrar y Actualizar

        btnBorrar = new JButton("Borrar");
        btnActualizar = new JButton("Actualizar");
        panel4.add(btnBorrar);
        panel4.add(btnActualizar);

        //Labels
        lblIdP2 = new JLabel("Id_Proveedor:");
        lblCalle2 = new JLabel("Calle:");
        lblNumero2 = new JLabel("Numero:");
        lblColonia2 = new JLabel("Colonia:");
        lblRfc2 = new JLabel("Rfc:");
        lblTelefono12 = new JLabel("Telefono 1:");
        lblTelefono22 = new JLabel("Telefono 2:");
        lblEmailp2 = new JLabel("Email_Proveedor:");
        lblCuenta2 = new JLabel("Cuenta:");
        lblIdBanco2 = new JLabel("Id_Banco:");
        lblEnvio2 = new JLabel("Envio:");
        lblUrl2 = new JLabel("Foto");

        /*
        txtIdP2 = new JTextField(1);
        txtIdP2.setText("0");
        txtIdP2.setEnabled(false);

         */

        //Damos valores a las opciones de la tabla
        txtIdP2 = new JTextField(20);
        txtCalle2 = new JTextField(20);
        txtNumero2 = new JTextField(6);
        txtColonia2 = new JTextField(20);
        txtRfc2 = new JTextField(12);
        txtTelefono12 = new JTextField(10);
        txtTelefono22 = new JTextField(10);
        txtEmailP2 = new JTextField(15);
        txtCuenta2 = new JTextField(18);
        txtIdBanco2 = new JTextField(2);
        txtEnvio2 = new JTextField(2);
        txtUrl2 = new JTextField(30);

        //Agregamos los valores

        //IdP
        panel4.add(lblIdP2);
        panel4.add(txtIdP2);

        //Calle

        panel4.add(lblCalle2);
        panel4.add(txtCalle2);

        //Numero
        panel4.add(lblNumero2);
        panel4.add(txtNumero2);

        //Colonia
        panel4.add(lblColonia2);
        panel4.add(txtColonia2);

        //Rfc
        panel4.add(lblRfc2);
        panel4.add(txtRfc2);

        //Telefono_1
        panel4.add(lblTelefono12);
        panel4.add(txtTelefono12);

        //Telefono_2
        panel4.add(lblTelefono22);
        panel4.add(txtTelefono22);

        //EmailP
        panel4.add(lblEmailp2);
        panel4.add(txtEmailP2);

        //Cuenta
        panel4.add(lblCuenta2);
        panel4.add(txtCuenta2);

        //Id_banco
        panel4.add(lblIdBanco2);
        panel4.add(txtIdBanco2);

        //Envio
        panel4.add(lblEnvio2);
        panel4.add(txtEnvio2);

        //Url
        panel4.add(lblUrl2);
        panel4.add(txtUrl2);

        //Ponemos los paneles
        this.getContentPane().setLayout(new GridLayout(2,2));
        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public JLabel getLblIdP() {
        return lblIdP;
    }

    public void setLblIdP(JLabel lblIdP) {
        this.lblIdP = lblIdP;
    }

    public JLabel getLblCalle() {
        return lblCalle;
    }

    public void setLblCalle(JLabel lblCalle) {
        this.lblCalle = lblCalle;
    }

    public JLabel getLblNumero() {
        return lblNumero;
    }

    public void setLblNumero(JLabel lblNumero) {
        this.lblNumero = lblNumero;
    }

    public JLabel getLblColonia() {
        return lblColonia;
    }

    public void setLblColonia(JLabel lblColonia) {
        this.lblColonia = lblColonia;
    }

    public JLabel getLblRfc() {
        return lblRfc;
    }

    public void setLblRfc(JLabel lblRfc) {
        this.lblRfc = lblRfc;
    }

    public JLabel getLblTelefono1() {
        return lblTelefono1;
    }

    public void setLblTelefono1(JLabel lblTelefono1) {
        this.lblTelefono1 = lblTelefono1;
    }

    public JLabel getLblTelefono2() {
        return lblTelefono2;
    }

    public void setLblTelefono2(JLabel lblTelefono2) {
        this.lblTelefono2 = lblTelefono2;
    }

    public JLabel getLblEmailp() {
        return lblEmailp;
    }

    public void setLblEmailp(JLabel lblEmailp) {
        this.lblEmailp = lblEmailp;
    }

    public JLabel getLblCuenta() {
        return lblCuenta;
    }

    public void setLblCuenta(JLabel lblCuenta) {
        this.lblCuenta = lblCuenta;
    }

    public JLabel getLblIdBanco() {
        return lblIdBanco;
    }

    public void setLblIdBanco(JLabel lblIdBanco) {
        this.lblIdBanco = lblIdBanco;
    }

    public JLabel getLblEnvio() {
        return lblEnvio;
    }

    public void setLblEnvio(JLabel lblEnvio) {
        this.lblEnvio = lblEnvio;
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

    public JTextField getTxtIdP() {
        return txtIdP;
    }

    public void setTxtIdP(JTextField txtIdP) {
        this.txtIdP = txtIdP;
    }

    public JTextField getTxtCalle() {
        return txtCalle;
    }

    public void setTxtCalle(JTextField txtCalle) {
        this.txtCalle = txtCalle;
    }

    public JTextField getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(JTextField txtNumero) {
        this.txtNumero = txtNumero;
    }

    public JTextField getTxtColonia() {
        return txtColonia;
    }

    public void setTxtColonia(JTextField txtColonia) {
        this.txtColonia = txtColonia;
    }

    public JTextField getTxtRfc() {
        return txtRfc;
    }

    public void setTxtRfc(JTextField txtRfc) {
        this.txtRfc = txtRfc;
    }

    public JTextField getTxtTelefono1() {
        return txtTelefono1;
    }

    public void setTxtTelefono1(JTextField txtTelefono1) {
        this.txtTelefono1 = txtTelefono1;
    }

    public JTextField getTxtTelefono2() {
        return txtTelefono2;
    }

    public void setTxtTelefono2(JTextField txtTelefono2) {
        this.txtTelefono2 = txtTelefono2;
    }

    public JTextField getTxtEmailP() {
        return txtEmailP;
    }

    public void setTxtEmailP(JTextField txtEmailP) {
        this.txtEmailP = txtEmailP;
    }

    public JTextField getTxtCuenta() {
        return txtCuenta;
    }

    public void setTxtCuenta(JTextField txtCuenta) {
        this.txtCuenta = txtCuenta;
    }

    public JTextField getTxtIdBanco() {
        return txtIdBanco;
    }

    public void setTxtIdBanco(JTextField txtIdBanco) {
        this.txtIdBanco = txtIdBanco;
    }

    public JTextField getTxtEnvio() {
        return txtEnvio;
    }

    public void setTxtEnvio(JTextField txtEnvio) {
        this.txtEnvio = txtEnvio;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JLabel getLblIdP2() {
        return lblIdP2;
    }

    public void setLblIdP2(JLabel lblIdP2) {
        this.lblIdP2 = lblIdP2;
    }

    public JLabel getLblCalle2() {
        return lblCalle2;
    }

    public void setLblCalle2(JLabel lblCalle2) {
        this.lblCalle2 = lblCalle2;
    }

    public JLabel getLblNumero2() {
        return lblNumero2;
    }

    public void setLblNumero2(JLabel lblNumero2) {
        this.lblNumero2 = lblNumero2;
    }

    public JLabel getLblColonia2() {
        return lblColonia2;
    }

    public void setLblColonia2(JLabel lblColonia2) {
        this.lblColonia2 = lblColonia2;
    }

    public JLabel getLblRfc2() {
        return lblRfc2;
    }

    public void setLblRfc2(JLabel lblRfc2) {
        this.lblRfc2 = lblRfc2;
    }

    public JLabel getLblTelefono12() {
        return lblTelefono12;
    }

    public void setLblTelefono12(JLabel lblTelefono12) {
        this.lblTelefono12 = lblTelefono12;
    }

    public JLabel getLblTelefono22() {
        return lblTelefono22;
    }

    public void setLblTelefono22(JLabel lblTelefono22) {
        this.lblTelefono22 = lblTelefono22;
    }

    public JLabel getLblEmailp2() {
        return lblEmailp2;
    }

    public void setLblEmailp2(JLabel lblEmailp2) {
        this.lblEmailp2 = lblEmailp2;
    }

    public JLabel getLblCuenta2() {
        return lblCuenta2;
    }

    public void setLblCuenta2(JLabel lblCuenta2) {
        this.lblCuenta2 = lblCuenta2;
    }

    public JLabel getLblIdBanco2() {
        return lblIdBanco2;
    }

    public void setLblIdBanco2(JLabel lblIdBanco2) {
        this.lblIdBanco2 = lblIdBanco2;
    }

    public JLabel getLblEnvio2() {
        return lblEnvio2;
    }

    public void setLblEnvio2(JLabel lblEnvio2) {
        this.lblEnvio2 = lblEnvio2;
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

    public JTextField getTxtIdP2() {
        return txtIdP2;
    }

    public void setTxtIdP2(JTextField txtIdP2) {
        this.txtIdP2 = txtIdP2;
    }

    public JTextField getTxtCalle2() {
        return txtCalle2;
    }

    public void setTxtCalle2(JTextField txtCalle2) {
        this.txtCalle2 = txtCalle2;
    }

    public JTextField getTxtNumero2() {
        return txtNumero2;
    }

    public void setTxtNumero2(JTextField txtNumero2) {
        this.txtNumero2 = txtNumero2;
    }

    public JTextField getTxtColonia2() {
        return txtColonia2;
    }

    public void setTxtColonia2(JTextField txtColonia2) {
        this.txtColonia2 = txtColonia2;
    }

    public JTextField getTxtRfc2() {
        return txtRfc2;
    }

    public void setTxtRfc2(JTextField txtRfc2) {
        this.txtRfc2 = txtRfc2;
    }

    public JTextField getTxtTelefono12() {
        return txtTelefono12;
    }

    public void setTxtTelefono12(JTextField txtTelefono12) {
        this.txtTelefono12 = txtTelefono12;
    }

    public JTextField getTxtTelefono22() {
        return txtTelefono22;
    }

    public void setTxtTelefono22(JTextField txtTelefono22) {
        this.txtTelefono22 = txtTelefono22;
    }

    public JTextField getTxtEmailP2() {
        return txtEmailP2;
    }

    public void setTxtEmailP2(JTextField txtEmailP2) {
        this.txtEmailP2 = txtEmailP2;
    }

    public JTextField getTxtCuenta2() {
        return txtCuenta2;
    }

    public void setTxtCuenta2(JTextField txtCuenta2) {
        this.txtCuenta2 = txtCuenta2;
    }

    public JTextField getTxtIdBanco2() {
        return txtIdBanco2;
    }

    public void setTxtIdBanco2(JTextField txtIdBanco2) {
        this.txtIdBanco2 = txtIdBanco2;
    }

    public JTextField getTxtEnvio2() {
        return txtEnvio2;
    }

    public void setTxtEnvio2(JTextField txtEnvio2) {
        this.txtEnvio2 = txtEnvio2;
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
        txtIdP.setText("");
        txtCalle.setText("");
        txtNumero.setText("");
        txtColonia.setText("");
        txtRfc.setText("");
        txtTelefono1.setText("");
        txtTelefono2.setText("");
        txtEmailP.setText("");
        txtCuenta.setText("");
        txtIdBanco.setText("");
        txtEnvio.setText("");
        txtUrl.setText("");

        txtIdP2.setText("");
        txtCalle2.setText("");
        txtNumero2.setText("");
        txtColonia2.setText("");
        txtRfc2.setText("");
        txtTelefono12.setText("");
        txtTelefono22.setText("");
        txtEmailP2.setText("");
        txtCuenta2.setText("");
        txtIdBanco2.setText("");
        txtEnvio2.setText("");
        txtUrl2.setText("");

    }


}
