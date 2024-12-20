package ma.enset.service;


import ma.enset.dao.EquipeDao;
import ma.enset.dao.JoueurDao;
import ma.enset.dao.EquipeDaoImpl;
import ma.enset.dao.JoueurDaoImpl;
import ma.enset.model.Equipe;
import ma.enset.model.Joueur;

import java.util.ArrayList;
import java.util.List;

public class EquipeJoueurServiceImpl implements IEquipeJoueurService {
    private EquipeDao equipeDao = new EquipeDaoImpl();
    private JoueurDao joueurDao = new JoueurDaoImpl();

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeDao.findAll();
    }

    @Override
    public List<Joueur> getAllJoueurs() {
        return joueurDao.findAll();
    }

    @Override
    public void addEquipe(Equipe equipe) {
        equipeDao.save(equipe);
    }

    @Override
    public void addJoueur(Joueur joueur) {
        joueurDao.save(joueur);
    }

    @Override
    public List<Joueur> getJoueursByEquipe(long equipeId) {
        List<Joueur> joueurs = new ArrayList<>();
        for (Joueur joueur : joueurDao.findAll()) {
            if (joueur.getEquipeId() == equipeId) {
                joueurs.add(joueur);
            }
        }
        return joueurs;
    }

    @Override
    public void removeEquipe(long equipeId) {
        equipeDao.deleteById(equipeId);
    }

    @Override
    public void removeJoueur(long joueurId) {
        joueurDao.deleteById(joueurId);
    }
}
