package fr.eni.tpfilmotheque.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Genre {

    private int id;
    private String libelle;

    public Genre(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Genre(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
}
