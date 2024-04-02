package org.example.persistencia;
import org.example.modelo.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BancoDAO implements InterfazDAO{

    public BancoDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Tb_Banco(id_banco, numero, url) VALUES(?, ?, ?)";
        try (PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlInsert)) {
            Banco banco = (Banco) obj;
            pstm.setInt(1, banco.getId_banco());
            pstm.setInt(2, banco.getNumero());
            pstm.setString(3, banco.getUrl());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Tb_Banco SET numero = ?, url = ? WHERE id_banco = ?;";
        try(PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlUpdate)){
            Banco banco = (Banco) obj;
            pstm.setInt(1,banco.getNumero());
            pstm.setString(2, banco.getUrl());
            pstm.setInt(3,banco.getId_banco());
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM Tb_Banco WHERE id_banco = ?";
        try(PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sqlDelete)){
            pstm.setString(1, id);
            int rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Tb_Banco";
        ArrayList<Banco> bancos = new ArrayList<>();
        try (Statement stm = ConexionSingleton.getInstance("mavideDB.db").getConnection().createStatement();
             ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                Banco banco = new Banco(
                        rs.getInt("id_banco"),
                        rs.getInt("numero"),
                        rs.getString("url")
                );
                bancos.add(banco);
            }
        }
        return bancos;

    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        return null;
    }

    @Override
    public Object buscarPorNumero(int numero) throws SQLException {
        String sql = "SELECT * FROM Tb_Banco WHERE numero = ?";
        try(PreparedStatement pstm = ConexionSingleton.getInstance("mavideDB.db").getConnection().prepareStatement(sql)){
            pstm.setInt(1,numero);
            try(ResultSet rs = pstm.executeQuery()){
                if (rs.next()){
                    return new Banco(
                            rs.getInt("id_banco"),
                            rs.getInt("numero"),
                            rs.getString("url")
                    );
                }
            }
        }
        return null;
    }

}
