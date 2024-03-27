package org.example.modelo;

import org.example.persistencia.BancoDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaBanco implements TableModel {

    private ArrayList<Banco> datos;
    public static final int COLUMNS = 3; // Corregido el nombre de la constante
    private BancoDAO bancoDAO;

    public ModeloTablaBanco() {
        bancoDAO = new BancoDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaBanco(ArrayList<Banco> datos, BancoDAO bancoDAO) {
        this.datos = datos;
        this.bancoDAO = bancoDAO;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id_Banco";
            case 1:
                return "Numero";
            case 2:
                return "Url";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Banco tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId_banco();
            case 1:
                return tmp.getNumero();
            case 2:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                datos.get(rowIndex).setId_banco((String) aValue);
                break;
            case 1:
                datos.get(rowIndex).setNumero((int) aValue);
                break;
            case 2:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
            default:
                System.out.println("No se modifica nada");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public boolean eliminarDatos(String index) {
        boolean resultado = false;
        try {
            if (bancoDAO.delete(index)) {
                System.out.println("Ha sido eliminado exitosamente");
                resultado = true;
            } else {
                System.out.println("Error al eliminar");
                System.out.println(index);
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public void cargarDatos() {
        try {
            datos = bancoDAO.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarBanco(Banco banco) {
        boolean resultado = false;

        try {
            if (bancoDAO.insertar(banco)) {
                datos.add(banco);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public Banco getBancoAtIndex(int idx) {
        return datos.get(idx);
    }

    public boolean updateBanco(Banco banco) {
        boolean resultado = false;

        try {
            if (bancoDAO.update(banco)) {
                System.out.println("Se modifico correctamente");
                resultado = true;
            } else {
                resultado = true;
                System.out.println("No se pudo modificar");
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
}
