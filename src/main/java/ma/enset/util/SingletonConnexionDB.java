package ma.enset.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {
    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/GestionEquipe";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private SingletonConnexionDB() {}

    public static Connection getConnexion() {
        if (connection == null) {
            synchronized (SingletonConnexionDB.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(URL, USER, PASSWORD);
                        System.out.println("Connection successful!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
