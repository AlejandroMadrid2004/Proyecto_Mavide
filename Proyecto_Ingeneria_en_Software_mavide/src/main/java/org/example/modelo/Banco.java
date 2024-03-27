package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Banco {

    private String id_banco;
    private int numero;
    private String url;

    public Banco() {
    }

    public Banco(String id_banco, int numero, String url) {
        this.id_banco = id_banco;
        this.numero = numero;
        this.url = url;
    }

    public String getId_banco() {
        return id_banco;
    }

    public void setId_banco(String id_banco) {
        this.id_banco = id_banco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "id_banco='" + id_banco + '\'' +
                ", numero=" + numero +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(getUrl());
        return new ImageIcon(urlImage);
    }


}
