package ma.enset;

import ma.enset.model.Equipe;
import ma.enset.model.Joueur;
import ma.enset.service.EquipeJoueurServiceImpl;
import ma.enset.service.IEquipeJoueurService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        IEquipeJoueurService service = new EquipeJoueurServiceImpl();

        // Add a team
        Equipe equipe = new Equipe();
        equipe.setNom("wydad athletic club");
        equipe.setVille("Casablanca");
        service.addEquipe(equipe);

        // Add a player
        Joueur joueur = new Joueur();
        joueur.setNom("Khalid azmi");
        joueur.setPosition("Goal keaper");
        joueur.setNumero(9);
        joueur.setEquipeId(1); // Assuming team with ID 1 exists
        service.addJoueur(joueur);

        // List all teams
        List<Equipe> equipes = service.getAllEquipes();
        for (Equipe e : equipes) {
            System.out.println("Team: " + e.getNom() + ", City: " + e.getVille());
        }

        // List players in a team
        List<Joueur> joueurs = service.getJoueursByEquipe(1);
        for (Joueur j : joueurs) {
            System.out.println("Player: " + j.getNom() + ", Position: " + j.getPosition());
        }
    }
}
