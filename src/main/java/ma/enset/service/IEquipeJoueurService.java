package ma.enset.service;
import ma.enset.model.Equipe;
import ma.enset.model.Joueur;

import java.util.List;

public interface IEquipeJoueurService {
    List<Equipe> getAllEquipes();
    List<Joueur> getAllJoueurs();
    void addEquipe(Equipe equipe);
    void addJoueur(Joueur joueur);
    List<Joueur> getJoueursByEquipe(long equipeId);
    void removeEquipe(long equipeId);
    void removeJoueur(long joueurId);
}
