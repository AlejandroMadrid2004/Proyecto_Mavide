package org.example.modelo;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Proveedor {

    private String id_proveedor;
    private String calle;
    private int numero;
    private String colonia;
    private String rfc;
    private int telefono_1;
    private int telefono_2;
    private String emailp;
    private int cuenta;
    private int id_banco;
    private int envio;
    private String url;

    public Proveedor() {
    }

    public Proveedor(String id_proveedor, String calle, int numero, String colonia, String rfc, int telefono_1, int telefono_2, String emailp, int cuenta, int id_banco, int envio, String url) {
        this.id_proveedor = id_proveedor;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.rfc = rfc;
        this.telefono_1 = telefono_1;
        this.telefono_2 = telefono_2;
        this.emailp = emailp;
        this.cuenta = cuenta;
        this.id_banco = id_banco;
        this.envio = envio;
        this.url = url;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public int getTelefono_1() {
        return telefono_1;
    }

    public void setTelefono_1(int telefono_1) {
        this.telefono_1 = telefono_1;
    }

    public int getTelefono_2() {
        return telefono_2;
    }

    public void setTelefono_2(int telefono_2) {
        this.telefono_2 = telefono_2;
    }

    public String getEmailp() {
        return emailp;
    }

    public void setEmailp(String emailp) {
        this.emailp = emailp;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public int getEnvio() {
        return envio;
    }

    public void setEnvio(int envio) {
        this.envio = envio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id_proveedor='" + id_proveedor + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", colonia='" + colonia + '\'' +
                ", rfc='" + rfc + '\'' +
                ", telefono_1=" + telefono_1 +
                ", telefono_2=" + telefono_2 +
                ", emailp='" + emailp + '\'' +
                ", cuenta=" + cuenta +
                ", id_banco=" + id_banco +
                ", envio=" + envio +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException{
        URL urlImage = new URL(getUrl());
        return new ImageIcon(urlImage);
    }

}
