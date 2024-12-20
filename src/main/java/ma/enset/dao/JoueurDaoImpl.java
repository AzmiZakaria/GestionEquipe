package ma.enset.dao;

import ma.enset.model.Joueur;
import ma.enset.util.SingletonConnexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JoueurDaoImpl implements JoueurDao {
    private Connection connection = SingletonConnexionDB.getConnexion();

    @Override
    public List<Joueur> findAll() {
        List<Joueur> joueurs = new ArrayList<>();
        String query = "SELECT * FROM Joueur";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Joueur joueur = new Joueur();
                joueur.setId(rs.getLong("id"));
                joueur.setNom(rs.getString("nom"));
                joueur.setPosition(rs.getString("position"));
                joueur.setNumero(rs.getInt("numero"));
                joueur.setEquipeId(rs.getLong("equipe_id"));
                joueurs.add(joueur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return joueurs;
    }

    @Override
    public Joueur findById(long id) {
        Joueur joueur = null;
        String query = "SELECT * FROM Joueur WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    joueur = new Joueur();
                    joueur.setId(rs.getLong("id"));
                    joueur.setNom(rs.getString("nom"));
                    joueur.setPosition(rs.getString("position"));
                    joueur.setNumero(rs.getInt("numero"));
                    joueur.setEquipeId(rs.getLong("equipe_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return joueur;
    }

    @Override
    public void save(Joueur joueur) {
        String query = "INSERT INTO Joueur (nom, position, numero, equipe_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, joueur.getNom());
            pstmt.setString(2, joueur.getPosition());
            pstmt.setInt(3, joueur.getNumero());
            pstmt.setLong(4, joueur.getEquipeId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        String query = "DELETE FROM Joueur WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Joueur joueur) {
        String query = "UPDATE Joueur SET nom = ?, position = ?, numero = ?, equipe_id = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, joueur.getNom());
            pstmt.setString(2, joueur.getPosition());
            pstmt.setInt(3, joueur.getNumero());
            pstmt.setLong(4, joueur.getEquipeId());
            pstmt.setLong(5, joueur.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
