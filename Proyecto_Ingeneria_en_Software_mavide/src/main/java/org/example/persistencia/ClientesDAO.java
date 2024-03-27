package org.example.persistencia;

import org.example.modelo.Clientes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientesDAO implements InterfazDAO{

    public ClientesDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Tb_Clientes (id_cliente, calle, numero, colonia, rfc, emailc, telefono_1, telefono_2, cuenta, id_banco, envio, url) "+
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlInsert)){
            Clientes clientes = (Clientes) obj;
            pstm.setString(1, clientes.getId_cliente());
            pstm.setString(2,clientes.getCalle());
            pstm.setInt(3,clientes.getNumero());
            pstm.setString(4,clientes.getColonia());
            pstm.setString(5,clientes.getRfc());
            pstm.setString(6,clientes.getEmailc());
            pstm.setInt(7,clientes.getTelefono_1());
            pstm.setInt(8,clientes.getTelefono_2());
            pstm.setInt(9,clientes.getCuenta());
            pstm.setInt(10,clientes.getId_banco());
            pstm.setInt(11,clientes.getEnvio());
            pstm.setString(12,clientes.getUrl());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Tb_Clientes SET calle = ?, numero = ?, colonia = ?, rfc = ?, emailc = ?, telefono_1 = ?, " +
                " telefono_2 = ?, cuenta = ?, id_banco = ?, envio = ?, url = ? WHERE id_cliente = ?";
        try(PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlUpdate)){
            Clientes clientes = (Clientes) obj;
            pstm.setString(1,clientes.getCalle());
            pstm.setInt(2,clientes.getNumero());
            pstm.setString(3,clientes.getColonia());
            pstm.setString(4,clientes.getRfc());
            pstm.setString(5,clientes.getEmailc());
            pstm.setInt(6,clientes.getTelefono_1());
            pstm.setInt(7,clientes.getTelefono_2());
            pstm.setInt(8,clientes.getCuenta());
            pstm.setInt(9,clientes.getId_banco());
            pstm.setInt(10,clientes.getEnvio());
            pstm.setString(11,clientes.getUrl());
            pstm.setString(12, clientes.getId_cliente());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM Tb_Clientes where id_cliente = ?";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlDelete)) {
            pstm.setString(1, id);
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Tb_Clientes";
        ArrayList<Clientes> clientes = new ArrayList<>();
        try (Statement stm = ConexionSingleton.getInstance("mavideDB.db").getConnection().createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                Clientes cliente = new Clientes(
                        rs.getString("id_cliente"),
                        rs.getString("calle"),
                        rs.getInt("numero"),
                        rs.getString("colonia"),
                        rs.getString("rfc"),
                        rs.getString("emailc"),
                        rs.getInt("telefono_1"),
                        rs.getInt("telefono_2"),
                        rs.getInt("cuenta"),
                        rs.getInt("id_banco"),
                        rs.getInt("envio"),
                        rs.getString("url")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM Tb_Clientes WHERE id_cliente = ?";
        try(PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sql)){
            pstm.setString(1,id);
            try(ResultSet rs = pstm.executeQuery()){
                if(rs.next()){
                    return new Clientes(
                            rs.getString("id_cliente"),
                            rs.getString("calle"),
                            rs.getInt("numero"),
                            rs.getString("colonia"),
                            rs.getString("rfc"),
                            rs.getString("emailc"),
                            rs.getInt("telefono_1"),
                            rs.getInt("telefono_2"),
                            rs.getInt("cuenta"),
                            rs.getInt("id_banco"),
                            rs.getInt("envio"),
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
