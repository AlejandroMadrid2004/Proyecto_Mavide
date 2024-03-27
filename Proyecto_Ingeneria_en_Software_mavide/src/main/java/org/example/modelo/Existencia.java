package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Existencia {

    private int id_producto;
    private String id_proveedor;
    private int cantidad;
    private String fecha;
    private String url;

    public Existencia() {
    }

    public Existencia(int id_producto, String id_proveedor, int cantidad, String fecha, String url) {
        this.id_producto = id_producto;
        this.id_proveedor = id_proveedor;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.url = url;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Existencia{" +
                "id_producto=" + id_producto +
                ", id_proveedor='" + id_proveedor + '\'' +
                ", cantidad=" + cantidad +
                ", fecha='" + fecha + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(getUrl());
        return new ImageIcon(urlImage);
    }

}
