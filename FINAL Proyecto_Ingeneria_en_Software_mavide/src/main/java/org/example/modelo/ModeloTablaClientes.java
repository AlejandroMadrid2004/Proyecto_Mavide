package org.example.modelo;

import org.example.persistencia.ClientesDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaClientes implements TableModel {

    private ArrayList<Clientes> datos;
    public static final int COLUMS = 12;
    private ClientesDAO clientesDAO;

    public ModeloTablaClientes(){
        clientesDAO = new ClientesDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaClientes(ArrayList<Clientes>datos, ClientesDAO clientesDAO){
        this.datos = datos;
        this.clientesDAO = clientesDAO;
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
        switch (columnIndex){
            case 0:
                return "Id_Cliente";
            case 1:
                return "Calle";
            case 2:
                return "Numero";
            case 3:
                return "Colonia";
            case 4:
                return "Rfc";
            case 5:
                return "Email_Cliente";
            case 6:
                return "Telefono_1";
            case 7:
                return "Telefono_2";
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
        if (columnIndex == 2||columnIndex == 6 || columnIndex == 7 || columnIndex == 8 || columnIndex == 9|| columnIndex == 10){
            return Integer.class;
        }
        return String.class; // Todos los demás son de tipo String
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clientes clientes = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return clientes.getId_cliente();
            case 1:
                return clientes.getCalle();
            case 2:
                return clientes.getNumero();
            case 3:
                return clientes.getColonia();
            case 4:
                return clientes.getRfc();
            case 5:
                return clientes.getEmailc();
            case 6:
                return clientes.getTelefono_1();
            case 7:
                return clientes.getTelefono_2();
            case 8:
                return clientes.getCuenta();
            case 9:
                return clientes.getId_banco();
            case 10:
                return clientes.getEnvio();
            case 11:
                return clientes.getUrl();

        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Clientes clientes = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                clientes.setId_cliente((String) aValue);
                break;
            case 1:
                clientes.setCalle((String) aValue);
                break;
            case 2:
                clientes.setNumero((int) aValue);
                break;
            case 3:
                clientes.setColonia((String) aValue);
                break;
            case 4:
                clientes.setRfc((String) aValue);
                break;
            case 5:
                clientes.setEmailc((String) aValue);
                break;
            case 6:
                clientes.setTelefono_1((int) aValue);
                break;
            case 7:
                clientes.setTelefono_2((int) aValue);
                break;
            case 8:
                clientes.setCuenta((int) aValue);
                break;
            case 9:
                clientes.setId_banco((int) aValue);
                break;
            case 10:
                clientes.setEnvio((int) aValue);
                break;
            case 11:
                clientes.setUrl((String) aValue);
                break;
        }
        updateCliente(clientes);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //No se requiere
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //No se requiere
    }

    // Métodos para manipular los datos del proveedor
    public boolean eliminarDatos(String idCliente){
        boolean resultado = false;
        try{
            if (clientesDAO.delete(idCliente)) {
                System.out.println("Cliente eliminado exitosamente");
                cargarDatos(); // Recargar los datos después de eliminar un proveedor
                resultado = true;
            } else {
                System.out.println("Error al eliminar el cliente");
                resultado = false;
            }
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public void cargarDatos() {
        try {
            datos = clientesDAO.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarCliente (Clientes clientes){
        boolean resultado = false;
        try{
            if (clientesDAO.insertar(clientes)) {
                datos.add(clientes);
                resultado = true;
            } else {
                resultado = false;
            }
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public Clientes getClientesAtIndex(int idx){
        return datos.get(idx);
    }

    public boolean updateCliente (Clientes clientes){
        boolean resultado = false;
        try{
            if (clientesDAO.update(clientes)) {
                System.out.println("Cliente modificado correctamente");
                resultado = true;
            } else {
                System.out.println("No se pudo modificar el cliente");
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

}
