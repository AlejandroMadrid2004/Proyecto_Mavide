package org.example.persistencia;

import org.example.modelo.ListaPrecio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListaPrecioDAO implements InterfazDAO {

    public ListaPrecioDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Tb_ListaPrecio(id_precios, id_productos, costo, volumen, fecha, url) VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlInsert)) {
            ListaPrecio listaPrecio = (ListaPrecio) obj;
            pstm.setInt(1, listaPrecio.getId_precios());
            pstm.setString(2, listaPrecio.getId_productos());
            pstm.setDouble(3, listaPrecio.getCosto());
            pstm.setString(4, listaPrecio.getVolumen());
            pstm.setString(5, listaPrecio.getFecha());
            pstm.setString(6, listaPrecio.getUrl());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Tb_ListaPrecio SET id_productos = ?, costo = ?, volumen = ?, fecha = ?, url = ? WHERE id_precios = ?";
        try(PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlUpdate)){
            ListaPrecio listaPrecio = (ListaPrecio) obj;
            pstm.setString(1, listaPrecio.getId_productos());
            pstm.setDouble(2, listaPrecio.getCosto());
            pstm.setString(3, listaPrecio.getVolumen());
            pstm.setString(4, listaPrecio.getFecha());
            pstm.setString(5, listaPrecio.getUrl());
            pstm.setInt(6, listaPrecio.getId_precios());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM Tb_ListaPrecio WHERE id_precios = ?";
        try(PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlDelete)){
            pstm.setString(1, id);
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Tb_ListaPrecio";
        ArrayList<ListaPrecio> listaPrecios = new ArrayList<>();
        try (Statement stm = ConexionSingleton.getInstance("mavideDB.db").getConnection().createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                ListaPrecio listaPrecio = new ListaPrecio(
                        rs.getInt("id_precios"),
                        rs.getString("id_productos"),
                        rs.getDouble("costo"),
                        rs.getString("volumen"),
                        rs.getString("fecha"),
                        rs.getString("url")
                );
                listaPrecios.add(listaPrecio);
            }
        }
        return listaPrecios;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM Tb_ListaPrecio WHERE id_precios = ?";
        try(PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sql)){
            pstm.setString(1, id);
            try(ResultSet rs = pstm.executeQuery()){
                if (rs.next()){
                    return new ListaPrecio(
                            rs.getInt("id_precios"),
                            rs.getString("id_productos"),
                            rs.getDouble("costo"),
                            rs.getString("volumen"),
                            rs.getString("fecha"),
                            rs.getString("url")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public Object buscarPorNumero(int numero) throws SQLException {
        return null; // No aplicable para esta clase
    }
}

