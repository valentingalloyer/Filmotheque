package fr.eni.tpfilmotheque.configuration;

import fr.eni.tpfilmotheque.bo.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {

    @Bean
    List<Genre> getGenres() {
        List<Genre> listGenres = new ArrayList<>();

        listGenres.add(new Genre(1, "Comédie"));
        listGenres.add(new Genre(2, "Thriller"));
        listGenres.add(new Genre(2, "Policier"));

        return listGenres;
    }

    @Bean(name="catalogue")
    public Catalogue catalogue() {
        List<Film> listFilms = new ArrayList<>();
        List<Personne> listActeursAline = new ArrayList<>();
        listActeursAline.add(new Personne(1, "Taiclet", "Aline"));
        listActeursAline.add(new Personne(2, "Le", "Lapin"));
        Personne realisateurAline = new Personne(3, "Le cerveau", "d'Aline");
        Genre genre1 = new Genre(1, "Comédie");

        listFilms.add(new Film(1, "Aline au pays des merveilles", 90, 2000, "C'est Aline qui arrive au pays des merveilles", realisateurAline, listActeursAline, genre1));

        return new Catalogue(1, listFilms);
    }

    @Bean(name="listMembres")
    public List<Membre> listMembres() {
        List<Membre> listMembres = new ArrayList<>();
        listMembres.add(new Membre(1, "Valentin", "valentin@eni.com", "pass", true));
        listMembres.add(new Membre(2, "Téo", "teo@eni.com", "pass", false));

        return listMembres;
    }

    @Bean(name="membreActif")
    public Membre membreActif() {
        return null;
    }

}
