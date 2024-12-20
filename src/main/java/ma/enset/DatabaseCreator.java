package ma.enset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        createDatabaseAndTables();
    }

    public static void createDatabaseAndTables() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Create Database
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS GestionEquipe";
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Database created successfully or already exists.");

            // Switch to the new database
            String useDatabaseSQL = "USE GestionEquipe";
            statement.executeUpdate(useDatabaseSQL);

            // Create Equipe Table
            String createEquipeTableSQL = "CREATE TABLE IF NOT EXISTS Equipe (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "nom VARCHAR(255) NOT NULL, " +
                    "ville VARCHAR(255) NOT NULL)";
            statement.executeUpdate(createEquipeTableSQL);
            System.out.println("Equipe table created successfully or already exists.");

            // Create Joueur Table
            String createJoueurTableSQL = "CREATE TABLE IF NOT EXISTS Joueur (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "nom VARCHAR(255) NOT NULL, " +
                    "position VARCHAR(255) NOT NULL, " +
                    "numero INT NOT NULL, " +
                    "equipe_id BIGINT, " +
                    "FOREIGN KEY (equipe_id) REFERENCES Equipe(id) ON DELETE CASCADE)";
            statement.executeUpdate(createJoueurTableSQL);
            System.out.println("Joueur table created successfully or already exists.");

        } catch (SQLException e) {
            System.err.println("Error while creating database or tables: " + e.getMessage());
        }
    }
}
