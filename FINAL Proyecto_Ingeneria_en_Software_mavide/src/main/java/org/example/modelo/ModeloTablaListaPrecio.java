package org.example.modelo;

import org.example.persistencia.ListaPrecioDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaListaPrecio implements TableModel {

    private ArrayList<ListaPrecio> datos;
    public static final int COLUMNS = 6;
    private ListaPrecioDAO listaPrecioDAO;

    public ModeloTablaListaPrecio() {
        listaPrecioDAO = new ListaPrecioDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaListaPrecio(ArrayList<ListaPrecio> datos, ListaPrecioDAO listaPrecioDAO) {
        this.datos = datos;
        this.listaPrecioDAO = listaPrecioDAO;
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
                return "Id_Precios";
            case 1:
                return "Id_Productos";
            case 2:
                return "Costo";
            case 3:
                return "Volumen";
            case 4:
                return "Fecha";
            case 5:
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
            case 2:
                return Double.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
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
        ListaPrecio tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId_precios();
            case 1:
                return tmp.getId_productos();
            case 2:
                return tmp.getCosto();
            case 3:
                return tmp.getVolumen();
            case 4:
                return tmp.getFecha();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                datos.get(rowIndex).setId_precios((int) aValue);
                break;
            case 1:
                datos.get(rowIndex).setId_productos((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setCosto((double) aValue);
                break;
            case 3:
                datos.get(rowIndex).setVolumen((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setFecha((String) aValue);
                break;
            case 5:
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
            if (listaPrecioDAO.delete(index)) {
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
            datos = listaPrecioDAO.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarListaPrecio(ListaPrecio listaPrecio) {
        boolean resultado = false;

        try {
            if (listaPrecioDAO.insertar(listaPrecio)) {
                datos.add(listaPrecio);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public ListaPrecio getListaPrecioAtIndex(int idx) {
        return datos.get(idx);
    }

    public boolean updateListaPrecio(ListaPrecio listaPrecio) {
        boolean resultado = false;

        try {
            if (listaPrecioDAO.update(listaPrecio)) {
                System.out.println("Se modificó correctamente");
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

