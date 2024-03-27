package org.example.persistencia;

import org.example.modelo.Pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoDAO implements InterfazDAO {

    public PedidoDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Tb_Pedido(id_pedido, id_cliente, id_producto, id_proveedor, precio, rfc, detalles, fecha, url) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlInsert)) {
            Pedido pedido = (Pedido) obj;
            pstm.setInt(1, pedido.getId_pedido());
            pstm.setString(2, pedido.getId_clientes());
            pstm.setString(3, pedido.getId_producto());
            pstm.setString(4, pedido.getId_proveedor());
            pstm.setString(5, pedido.getPrecio());
            pstm.setString(6, pedido.getRfc());
            pstm.setString(7, pedido.getDetalles());
            pstm.setString(8, pedido.getFecha());
            pstm.setString(9, pedido.getUrl());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Tb_Pedido SET id_cliente = ?, id_producto = ?, id_proveedor = ?, precio = ?, rfc = ?, detalles = ?, fecha = ?, url = ? WHERE id_pedido = ?";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlUpdate)) {
            Pedido pedido = (Pedido) obj;
            pstm.setString(1, pedido.getId_clientes());
            pstm.setString(2, pedido.getId_producto());
            pstm.setString(3, pedido.getId_proveedor());
            pstm.setString(4, pedido.getPrecio());
            pstm.setString(5, pedido.getRfc());
            pstm.setString(6, pedido.getDetalles());
            pstm.setString(7, pedido.getFecha());
            pstm.setString(8, pedido.getUrl());
            pstm.setInt(9, pedido.getId_pedido());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM Tb_Pedido WHERE id_pedido = ?";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlDelete)) {
            pstm.setString(1, id);
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Tb_Pedido";
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try (Statement stm = ConexionSingleton.getInstance("mavideDB.db").getConnection().createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id_pedido"),
                        rs.getString("id_cliente"),
                        rs.getString("id_producto"),
                        rs.getString("id_proveedor"),
                        rs.getString("precio"),
                        rs.getString("rfc"),
                        rs.getString("detalles"),
                        rs.getString("fecha"),
                        rs.getString("url")
                );
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM Tb_Pedido WHERE id_pedido = ?";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sql)) {
            pstm.setString(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return new Pedido(
                            rs.getInt("id_pedido"),
                            rs.getString("id_cliente"),
                            rs.getString("id_producto"),
                            rs.getString("id_proveedor"),
                            rs.getString("precio"),
                            rs.getString("rfc"),
                            rs.getString("detalles"),
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
        return null; // No es aplicable para esta clase
    }
}

