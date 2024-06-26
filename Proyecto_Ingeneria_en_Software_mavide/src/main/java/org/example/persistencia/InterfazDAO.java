package org.example.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface InterfazDAO {

    //Metodos abstractos de InterfazDAO

    public abstract boolean insertar(Object obj) throws SQLException;
    public abstract boolean update(Object obj) throws SQLException;
    public abstract boolean delete(String id) throws SQLException;
    public abstract ArrayList obtenerTodo() throws SQLException;
    public abstract Object buscarPorId(String id) throws SQLException;

    public abstract Object buscarPorNumero(int numero) throws SQLException;

}