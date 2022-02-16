package fr.eni.tpfilmotheque.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Personne {

    private int id;
    private String nom;
    private String prenom;

    public Personne(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}
