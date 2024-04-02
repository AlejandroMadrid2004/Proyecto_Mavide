package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Pedido {

    private int id_pedido;
    private String id_clientes;
    private String id_producto;
    private String id_proveedor;
    private String precio;
    private String rfc;
    private String detalles;
    private String fecha;
    private String url;

    public Pedido() {
    }

    public Pedido(int id_pedido, String id_clientes, String id_producto, String id_proveedor, String precio, String rfc, String detalles, String fecha,
                  String url) {
        this.id_pedido = id_pedido;
        this.id_clientes = id_clientes;
        this.id_producto = id_producto;
        this.id_proveedor = id_proveedor;
        this.precio = precio;
        this.rfc = rfc;
        this.detalles = detalles;
        this.fecha = fecha;
        this.url = url;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(String id_clientes) {
        this.id_clientes = id_clientes;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
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
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", id_clientes='" + id_clientes + '\'' +
                ", id_producto='" + id_producto + '\'' +
                ", id_proveedor='" + id_proveedor + '\'' +
                ", precio='" + precio + '\'' +
                ", rfc='" + rfc + '\'' +
                ", detalles='" + detalles + '\'' +
                ", fecha='" + fecha + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(getUrl());
        return new ImageIcon(urlImage);
    }
}
