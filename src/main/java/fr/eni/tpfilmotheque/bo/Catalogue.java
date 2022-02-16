package fr.eni.tpfilmotheque.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Catalogue {

    private int id;
    private List<Film> films;

    public Catalogue(int id, List<Film> films) {
        this.id = id;
        this.films = films;
    }

}
