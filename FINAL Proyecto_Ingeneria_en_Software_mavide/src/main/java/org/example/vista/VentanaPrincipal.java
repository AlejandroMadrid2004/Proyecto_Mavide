package org.example.vista;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JButton btnTablaB;
    private JButton btnTablaC;
    private JButton btnTablaE;
    private JButton btnTablaLP;
    private JButton btnTablaPe;
    private JButton btnTablaPro;
    private JButton btnCerrar;
    private JLabel lblPrincipal;

    public VentanaPrincipal(String title) throws HeadlessException {
        super(title);
        setSize(400, 300);

        // Creamos los botones
        btnTablaB = new JButton("Bancos");
        btnTablaC = new JButton("Clientes");
        btnTablaE = new JButton("Existencias");
        btnTablaLP = new JButton("Lista de Precios");
        btnTablaPe = new JButton("Pedidos");
        btnTablaPro = new JButton("Proveedores");
        btnCerrar = new JButton("Cerrar");
        lblPrincipal = new JLabel("Seleccione la tabla a trabajar", SwingConstants.CENTER); // Alineamos el texto al centro
        lblPrincipal.setForeground(Color.WHITE); // Cambiamos el color del texto a blanco

        // Creamos el contenedor para los botones
        JPanel panelBotones = new JPanel(new GridLayout(3, 1)); // Modificamos el diseño del panel

        // Agregamos los botones al contenedor
        panelBotones.setBackground(new Color(88, 214, 141));
        panelBotones.add(lblPrincipal); // Agregamos la etiqueta antes de los botones
        JPanel panelSubBotones = new JPanel(new GridLayout(2, 3)); // Panel para los botones
        panelSubBotones.add(btnTablaB);
        panelSubBotones.add(btnTablaC);
        panelSubBotones.add(btnTablaE);
        panelSubBotones.add(btnTablaLP);
        panelSubBotones.add(btnTablaPe);
        panelSubBotones.add(btnTablaPro);
        panelBotones.add(panelSubBotones); // Agregamos el panel de botones al panel principal
        panelBotones.add(btnCerrar); // Agregamos el botón "Cerrar" al final

        getContentPane().add(panelBotones);
    }

    // Getters y setters

    public JButton getBtnTablaB() {
        return btnTablaB;
    }

    public void setBtnTablaB(JButton btnTablaB) {
        this.btnTablaB = btnTablaB;
    }

    public JButton getBtnTablaC() {
        return btnTablaC;
    }

    public void setBtnTablaC(JButton btnTablaC) {
        this.btnTablaC = btnTablaC;
    }

    public JButton getBtnTablaE() {
        return btnTablaE;
    }

    public void setBtnTablaE(JButton btnTablaE) {
        this.btnTablaE = btnTablaE;
    }

    public JButton getBtnTablaLP() {
        return btnTablaLP;
    }

    public void setBtnTablaLP(JButton btnTablaLP) {
        this.btnTablaLP = btnTablaLP;
    }

    public JButton getBtnTablaPe() {
        return btnTablaPe;
    }

    public void setBtnTablaPe(JButton btnTablaPe) {
        this.btnTablaPe = btnTablaPe;
    }

    public JButton getBtnTablaPro() {
        return btnTablaPro;
    }

    public void setBtnTablaPro(JButton btnTablaPro) {
        this.btnTablaPro = btnTablaPro;
    }

    public JButton getBtnCerrar() {
        return btnCerrar;
    }

    public void setBtnCerrar(JButton btnCerrar) {
        this.btnCerrar = btnCerrar;
    }

    public JLabel getLblPrincipal() {
        return lblPrincipal;
    }

    public void setLblPrincipal(JLabel lblPrincipal) {
        this.lblPrincipal = lblPrincipal;
    }
}
