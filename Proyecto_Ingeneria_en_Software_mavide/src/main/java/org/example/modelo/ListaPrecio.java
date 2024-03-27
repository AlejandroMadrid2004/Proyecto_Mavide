package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ListaPrecio {

    private int id_precios;
    private String id_productos;
    private double costo;
    private String volumen;
    private String fecha;
    private String url;

    public ListaPrecio() {
    }

    public ListaPrecio(int id_precios, String id_productos, double costo, String volumen, String fecha, String url) {
        this.id_precios = id_precios;
        this.id_productos = id_productos;
        this.costo = costo;
        this.volumen = volumen;
        this.fecha = fecha;
        this.url = url;
    }

    public int getId_precios() {
        return id_precios;
    }

    public void setId_precios(int id_precios) {
        this.id_precios = id_precios;
    }

    public String getId_productos() {
        return id_productos;
    }

    public void setId_productos(String id_productos) {
        this.id_productos = id_productos;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
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
        return "ListaPrecio{" +
                "id_precios=" + id_precios +
                ", id_productos='" + id_productos + '\'' +
                ", costo=" + costo +
                ", volumen='" + volumen + '\'' +
                ", fecha='" + fecha + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(getUrl());
        return new ImageIcon(urlImage);
    }
}
