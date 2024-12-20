package ma.enset.model;

public class Joueur {
    private long id;
    private String nom;
    private String position;
    private int numero;
    private long equipeId; // Foreign key

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(long equipeId) {
        this.equipeId = equipeId;
    }
}
