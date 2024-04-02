package org.example.modelo;

import org.example.persistencia.PedidoDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaPedido implements TableModel {

    private ArrayList<Pedido> datos;
    public static final int COLUMNS = 9; // Corregido el nombre de la constante
    private PedidoDAO pedidoDAO;

    public ModeloTablaPedido() {
        pedidoDAO = new PedidoDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaPedido(ArrayList<Pedido> datos, PedidoDAO pedidoDAO) {
        this.datos = datos;
        this.pedidoDAO = pedidoDAO;
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
                return "id_pedido";
            case 1:
                return "id_clientes";
            case 2:
                return "id_producto";
            case 3:
                return "id_proveedor";
            case 4:
                return "precio";
            case 5:
                return "rfc";
            case 6:
                return "detalles";
            case 7:
                return "fecha";
            case 8:
                return "url";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
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
        Pedido tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId_pedido();
            case 1:
                return tmp.getId_clientes();
            case 2:
                return tmp.getId_producto();
            case 3:
                return tmp.getId_proveedor();
            case 4:
                return tmp.getPrecio();
            case 5:
                return tmp.getRfc();
            case 6:
                return tmp.getDetalles();
            case 7:
                return tmp.getFecha();
            case 8:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Pedido pedido = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                pedido.setId_pedido((int) aValue);
                break;
            case 1:
                pedido.setId_clientes((String) aValue);
                break;
            case 2:
                pedido.setId_producto((String) aValue);
                break;
            case 3:
                pedido.setId_proveedor((String) aValue);
                break;
            case 4:
                pedido.setPrecio((String) aValue);
                break;
            case 5:
                pedido.setRfc((String) aValue);
                break;
            case 6:
                pedido.setDetalles((String) aValue);
                break;
            case 7:
                pedido.setFecha((String) aValue);
                break;
            case 8:
                pedido.setUrl((String) aValue);
                break;
            default:
                System.out.println("No se modifica nada");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // No implementado
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // No implementado
    }

    public boolean eliminarDatos(String index) {
        boolean resultado = false;
        try {
            if (pedidoDAO.delete(index)) {
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
            datos = pedidoDAO.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarPedido(Pedido pedido) {
        boolean resultado = false;

        try {
            if (pedidoDAO.insertar(pedido)) {
                datos.add(pedido);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public Pedido getPedidoAtIndex(int idx) {
        return datos.get(idx);
    }

    public boolean updatePedido(Pedido pedido) {
        boolean resultado = false;

        try {
            if (pedidoDAO.update(pedido)) {
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

