package org.example.persistencia;

import org.example.modelo.Existencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExistenciaDAO implements InterfazDAO{

    public ExistenciaDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Tb_Existencia(id_producto, id_proveedor, cantidad, fecha, url) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlInsert)) {
            Existencia existencia = (Existencia) obj;
            pstm.setInt(1, existencia.getId_producto());
            pstm.setString(2, existencia.getId_proveedor());
            pstm.setInt(3, existencia.getCantidad());
            pstm.setString(4, existencia.getFecha());
            pstm.setString(5, existencia.getUrl());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Tb_Existencia SET id_proveedor = ?, cantidad = ?, fecha = ?, url = ? WHERE id_producto = ?";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlUpdate)) {
            Existencia existencia = (Existencia) obj;
            pstm.setString(1, existencia.getId_proveedor());
            pstm.setInt(2, existencia.getCantidad());
            pstm.setString(3, existencia.getFecha());
            pstm.setString(4, existencia.getUrl());
            pstm.setInt(5, existencia.getId_producto());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM Tb_Existencia WHERE id_producto = ?";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlDelete)) {
            pstm.setString(1, id);
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Tb_Existencia";
        ArrayList<Existencia> existencias = new ArrayList<>();
        try (Statement stm = ConexionSingleton.getInstance("mavideDB.db").getConnection().createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                Existencia existencia = new Existencia(
                        rs.getInt("id_producto"),
                        rs.getString("id_proveedor"),
                        rs.getInt("cantidad"),
                        rs.getString("fecha"),
                        rs.getString("url")
                );
                existencias.add(existencia);
            }
        }
        return existencias;    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM Tb_Existencia WHERE id_producto = ?";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sql)) {
            pstm.setString(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return new Existencia(
                            rs.getInt("id_producto"),
                            rs.getString("id_proveedor"),
                            rs.getInt("cantidad"),
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
        return null;
    }
}
