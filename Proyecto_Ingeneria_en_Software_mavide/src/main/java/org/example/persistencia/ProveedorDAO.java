package org.example.persistencia;

import org.example.modelo.Proveedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProveedorDAO implements InterfazDAO {

    public ProveedorDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Tb_Proveedor (id_proveedor, calle, numero, colonia, rfc, telefono_1, telefono_2, emailp, cuenta, id_banco, envio, url) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlInsert)) {
            Proveedor proveedor = (Proveedor) obj;
            pstm.setString(1, proveedor.getId_proveedor());
            pstm.setString(2, proveedor.getCalle());
            pstm.setInt(3, proveedor.getNumero());
            pstm.setString(4, proveedor.getColonia());
            pstm.setString(5, proveedor.getRfc());
            pstm.setInt(6, proveedor.getTelefono_1());
            pstm.setInt(7, proveedor.getTelefono_2());
            pstm.setString(8, proveedor.getEmailp());
            pstm.setInt(9, proveedor.getCuenta());
            pstm.setInt(10, proveedor.getId_banco());
            pstm.setInt(11, proveedor.getEnvio());
            pstm.setString(12, proveedor.getUrl());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Tb_Proveedor SET calle = ?, numero = ?, colonia = ?, rfc = ?, telefono_1 = ?, " +
                "telefono_2 = ?, emailp = ?, cuenta = ?, id_banco = ?, envio = ?, url = ? WHERE id_proveedor = ?";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlUpdate)) {
            Proveedor proveedor = (Proveedor) obj;
            pstm.setString(1, proveedor.getCalle());
            pstm.setInt(2, proveedor.getNumero());
            pstm.setString(3, proveedor.getColonia());
            pstm.setString(4, proveedor.getRfc());
            pstm.setInt(5, proveedor.getTelefono_1());
            pstm.setInt(6, proveedor.getTelefono_2());
            pstm.setString(7, proveedor.getEmailp());
            pstm.setInt(8, proveedor.getCuenta());
            pstm.setInt(9, proveedor.getId_banco());
            pstm.setInt(10, proveedor.getEnvio());
            pstm.setString(11, proveedor.getUrl());
            pstm.setString(12, proveedor.getId_proveedor());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM Tb_Proveedor WHERE id_proveedor = ?";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlDelete)) {
            pstm.setString(1, id);
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public ArrayList<Proveedor> obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Tb_Proveedor";
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try (Statement stm = ConexionSingleton.getInstance("mavideDB.db").getConnection().createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor(
                        rs.getString("id_proveedor"),
                        rs.getString("calle"),
                        rs.getInt("numero"),
                        rs.getString("colonia"),
                        rs.getString("rfc"),
                        rs.getInt("telefono_1"),
                        rs.getInt("telefono_2"),
                        rs.getString("emailp"),
                        rs.getInt("cuenta"),
                        rs.getInt("id_banco"),
                        rs.getInt("envio"),
                        rs.getString("url")
                );
                proveedores.add(proveedor);
            }
        }
        return proveedores;
    }

    @Override
    public Proveedor buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM Tb_Proveedor WHERE id_proveedor = ?";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sql)) {
            pstm.setString(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return new Proveedor(
                            rs.getString("id_proveedor"),
                            rs.getString("calle"),
                            rs.getInt("numero"),
                            rs.getString("colonia"),
                            rs.getString("rfc"),
                            rs.getInt("telefono_1"),
                            rs.getInt("telefono_2"),
                            rs.getString("emailp"),
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
