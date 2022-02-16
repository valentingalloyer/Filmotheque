package fr.eni.tpfilmotheque.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Film {
    private int id;
    private String titre;
    private int annee;
    private int duree;
    private String synopsis;
    private Personne realisateur;
    private List<Personne> acteurs;
    private List<Avis> listAvis;
    private Genre genre;

    public Film(int id, String titre, int annee, int duree, String synopsis, Personne realisateur, List<Personne> acteurs, Genre genre) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.synopsis = synopsis;
        this.duree = duree;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
        this.genre = genre;
        this.listAvis = new ArrayList<>();
    }

    public Film(String titre, int annee, int duree, String synopsis, Personne realisateur, List<Personne> acteurs, Genre genre) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
        this.genre = genre;
        this.listAvis = new ArrayList<>();
    }
}
