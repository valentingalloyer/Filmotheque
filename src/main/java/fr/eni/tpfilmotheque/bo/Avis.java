package fr.eni.tpfilmotheque.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Avis {

    private int id;
    private int note;
    private String avis;
    private Film film;
    private Membre membre;

    public Avis(int id, int note, String avis, Film film, Membre membre) {
        this.id = id;
        this.note = note;
        this.avis = avis;
        this.film = film;
        this.membre = membre;
    }

    public Avis(int note, String avis, Film film) {
        this.note = note;
        this.avis = avis;
        this.film = film;
    }

    @Override
    public String toString() {
        return "Avis donné par " + (membre != null ? membre.toString() : "inconnu") + " :\n" +
                note + "/10\n" +
                avis;
    }
}
