package org.example.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton para la conexión a la base de datos
public class ConexionSingleton {

    private String baseDatos;
    private static ConexionSingleton instance;
    private Connection connection;

    // Constructor privado
    private ConexionSingleton(String database) {
        this.baseDatos = database;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + this.baseDatos);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método estático para obtener la instancia única de la conexión
    public static ConexionSingleton getInstance(String baseDatos) {
        if (instance == null) {
            instance = new ConexionSingleton(baseDatos);
        } else {
            System.out.println("Ya se ha creado una instancia de conexión.");
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
