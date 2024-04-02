package org.example.modelo;
import org.example.persistencia.ProveedorDAO;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaProveedor implements TableModel {

    private ArrayList<Proveedor> datos;
    public static final int COLUMNS = 12;
    private ProveedorDAO proveedorDAO;

    public ModeloTablaProveedor() {
        proveedorDAO = new ProveedorDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaProveedor(ArrayList<Proveedor> datos, ProveedorDAO proveedorDAO) {
        this.datos = datos;
        this.proveedorDAO = proveedorDAO;
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
                return "Id_Proveedor";
            case 1:
                return "Calle";
            case 2:
                return "Numero";
            case 3:
                return "Colonia";
            case 4:
                return "Rfc";
            case 5:
                return "Telefono1";
            case 6:
                return "Telefono2";
            case 7:
                return "Email_Proveedor";
            case 8:
                return "Cuenta";
            case 9:
                return "Id_Banco";
            case 10:
                return "Envio";
            case 11:
                return "Url";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Para los campos que son enteros, devolvemos Integer.class
        if (columnIndex == 2 ||columnIndex == 5 || columnIndex == 6 || columnIndex == 8 || columnIndex == 9 || columnIndex == 10) {
            return Integer.class;
        }
        return String.class; // Todos los demás son de tipo String
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; // Permitimos la edición de las celdas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proveedor proveedor = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return proveedor.getId_proveedor();
            case 1:
                return proveedor.getCalle();
            case 2:
                return proveedor.getNumero();
            case 3:
                return proveedor.getColonia();
            case 4:
                return proveedor.getRfc();
            case 5:
                return proveedor.getTelefono_1();
            case 6:
                return proveedor.getTelefono_2();
            case 7:
                return proveedor.getEmailp();
            case 8:
                return proveedor.getCuenta();
            case 9:
                return proveedor.getId_banco();
            case 10:
                return proveedor.getEnvio();
            case 11:
                return proveedor.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Proveedor proveedor = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                proveedor.setId_proveedor((String) aValue);
                break;
            case 1:
                proveedor.setCalle((String) aValue);
                break;
            case 2:
                proveedor.setNumero((int) aValue);
                break;
            case 3:
                proveedor.setColonia((String) aValue);
                break;
            case 4:
                proveedor.setRfc((String) aValue);
                break;
            case 5:
                proveedor.setTelefono_1((int) aValue);
                break;
            case 6:
                proveedor.setTelefono_2((int) aValue);
                break;
            case 7:
                proveedor.setEmailp((String) aValue);
                break;
            case 8:
                proveedor.setCuenta((int) aValue);
                break;
            case 9:
                proveedor.setId_banco((int) aValue);
                break;
            case 10:
                proveedor.setEnvio((int) aValue);
                break;
            case 11:
                proveedor.setUrl((String) aValue);
                break;
        }
        // Actualizamos el proveedor en la base de datos
        updateProveedor(proveedor);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // No necesitamos implementar nada aquí
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // No necesitamos implementar nada aquí
    }

    // Métodos para manipular los datos del proveedor

    public boolean eliminarDatos(String idProveedor) {
        boolean resultado = false;
        try {
            if (proveedorDAO.delete(idProveedor)) {
                System.out.println("Proveedor eliminado exitosamente");
                cargarDatos(); // Recargar los datos después de eliminar un proveedor
                resultado = true;
            } else {
                System.out.println("Error al eliminar el proveedor");
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public void cargarDatos() {
        try {
            datos = proveedorDAO.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarProveedor(Proveedor proveedor) {
        boolean resultado = false;
        try {
            if (proveedorDAO.insertar(proveedor)) {
                datos.add(proveedor);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public Proveedor getProveedorAtIndex(int idx) {
        return datos.get(idx);
    }

    public boolean updateProveedor(Proveedor proveedor) {
        boolean resultado = false;
        try {
            if (proveedorDAO.update(proveedor)) {
                System.out.println("Proveedor modificado correctamente");
                resultado = true;
            } else {
                System.out.println("No se pudo modificar el proveedor");
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
}

