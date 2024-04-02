package org.example.modelo;

import org.example.persistencia.ExistenciaDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaExistencia implements TableModel{

    private ArrayList<Existencia> datos;
    public static final int COLUMS = 5;
    private ExistenciaDAO existenciaDAO;

    public ModeloTablaExistencia() {
        existenciaDAO = new ExistenciaDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaExistencia(ArrayList<Existencia> datos, ExistenciaDAO existenciaDAO) {
        this.datos = datos;
        this.existenciaDAO = existenciaDAO;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id_Producto";
            case 1:
                return "Id_Proveedor";
            case 2:
                return "Cantidad";
            case 3:
                return "Fecha";
            case 4:
                return "Url";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 2:
                return Integer.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Existencia tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId_producto();
            case 1:
                return tmp.getId_proveedor();
            case 2:
                return tmp.getCantidad();
            case 3:
                return tmp.getFecha();
            case 4:
                return tmp.getUrl();
        }
        return null;    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                datos.get(rowIndex).setId_producto((int) aValue);
                break;
            case 1:
                datos.get(rowIndex).setId_proveedor((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setCantidad((int) aValue);
                break;
            case 3:
                datos.get(rowIndex).setFecha((String) aValue);
                break;
            case 4:
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

    public boolean eliminarDatos(int id) {
        boolean resultado = false;
        try {
            if (existenciaDAO.delete(Integer.toString(id))) {
                System.out.println("Ha sido eliminado exitosamente");
                resultado = true;
            } else {
                System.out.println("Error al eliminar");
                System.out.println(id);
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }


    public void cargarDatos() {
        try {
            datos = existenciaDAO.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarExistencia(Existencia existencia) {
        boolean resultado = false;

        try {
            if (existenciaDAO.insertar(existencia)) {
                datos.add(existencia);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public Existencia getExistenciaAtIndex(int idx) {
        return datos.get(idx);
    }

    public boolean updateExistencia(Existencia existencia) {
        boolean resultado = false;

        try {
            if (existenciaDAO.update(existencia)) {
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
