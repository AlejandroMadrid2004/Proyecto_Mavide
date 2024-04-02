package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaBanco extends JFrame {

    //Label 1
    private JLabel lblIdB;
    private JLabel lblNumero;
    private JLabel lblUrl;

    private JLabel imagenTarjeta;

    //TextField 1
    private JTextField txtIdB;
    private JTextField txtNumero;
    private JTextField txtUrl;

    //Label 2
    private JLabel lblIdB2;
    private JLabel lblNumero2;
    private JLabel lblUrl2;

    private JLabel imagenTarjeta2;

    //TextField 2
    private JTextField txtIdB2;
    private JTextField txtNumero2;
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
    private JPanel panel1; // Formulario para capturar datos
    private JPanel panel2; // Tabla para mostrar base de datos
    private JPanel panel3; // Imagen URL
    private JPanel panel4; // Boton Eliminar y Actualizar datos

    public VentanaBanco(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 800);
        layout = new GridLayout(2, 2);

        //Panel 1
        panel1 = new JPanel(new GridLayout(4, 2));
        panel1.setBackground(new Color(248, 183, 183));

        //Labels
        lblIdB = new JLabel("ID Banco");
        lblNumero = new JLabel("Número:");
        lblUrl = new JLabel("Foto: ");

        //Damos valores a las opciones de la tabla
        txtIdB = new JTextField(15);
        txtNumero = new JTextField(4);
        txtUrl = new JTextField(15);
        btnAgregar = new JButton("Agregar");

        //Agregamos los valores
        //id_banco
        panel1.add(lblIdB);
        panel1.add(txtIdB);
        //numero
        panel1.add(lblNumero);
        panel1.add(txtNumero);
        //url
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
        panel4 = new JPanel(new GridLayout(4,2));
        panel4.setBackground(new Color(150, 216, 219));

        //Agregamos el boton Borrar y Actualizar
        btnBorrar = new JButton("Borrar");
        btnActualizar = new JButton("Actualizar");
        panel4.add(btnBorrar);
        panel4.add(btnActualizar);

        //Labels
        lblIdB2 = new JLabel("ID Banco");
        lblNumero2 = new JLabel("Número:");
        lblUrl2 = new JLabel("Foto: ");

        //Damos valores a las opciones de la tabla
        txtIdB2 = new JTextField(15);
        txtNumero2 = new JTextField(4);
        txtUrl2 = new JTextField(15);

        //Agregamos los valores
        //id_banco
        panel4.add(lblIdB2);
        panel4.add(txtIdB2);
        //numero
        panel4.add(lblNumero2);
        panel4.add(txtNumero2);
        //url
        panel4.add(lblUrl2);
        panel4.add(txtUrl2);

        //Ponemos los paneles
        this.getContentPane().setLayout(new GridLayout(2, 2));
        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getImagenTarjeta() {
        return imagenTarjeta;
    }

    public JTextField getTxtIdB() {
        return txtIdB;
    }

    public JTextField getTxtNumero() {
        return txtNumero;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public JTextField getTxtIdB2() {
        return txtIdB2;
    }

    public JTextField getTxtNumero2() {
        return txtNumero2;
    }

    public JTextField getTxtUrl2() {
        return txtUrl2;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JTable getTblTarjeta() {
        return tblTarjeta;
    }

    public void limpiar() {
        txtIdB.setText("");
        txtNumero.setText("");
        txtUrl.setText("");
        txtIdB2.setText("");
        txtNumero2.setText("");
        txtUrl2.setText("");
    }
}
