package ma.enset.dao;
import ma.enset.util.SingletonConnexionDB;
import ma.enset.model.Equipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipeDaoImpl implements EquipeDao {
    private Connection connection = SingletonConnexionDB.getConnexion();

    @Override
    public List<Equipe> findAll() {
        List<Equipe> equipes = new ArrayList<>();
        String query = "SELECT * FROM Equipe";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Equipe equipe = new Equipe();
                equipe.setId(rs.getLong("id"));
                equipe.setNom(rs.getString("nom"));
                equipe.setVille(rs.getString("ville"));
                equipes.add(equipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipes;
    }

    @Override
    public Equipe findById(long id) {
        Equipe equipe = null;
        String query = "SELECT * FROM Equipe WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    equipe = new Equipe();
                    equipe.setId(rs.getLong("id"));
                    equipe.setNom(rs.getString("nom"));
                    equipe.setVille(rs.getString("ville"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipe;
    }

    @Override
    public void save(Equipe equipe) {
        String query = "INSERT INTO Equipe (nom, ville) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, equipe.getNom());
            pstmt.setString(2, equipe.getVille());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        String query = "DELETE FROM Equipe WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Equipe equipe) {
        String query = "UPDATE Equipe SET nom = ?, ville = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, equipe.getNom());
            pstmt.setString(2, equipe.getVille());
            pstmt.setLong(3, equipe.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
