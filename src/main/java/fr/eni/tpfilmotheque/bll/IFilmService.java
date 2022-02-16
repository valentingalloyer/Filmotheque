package fr.eni.tpfilmotheque.bll;

import fr.eni.tpfilmotheque.bo.Avis;
import fr.eni.tpfilmotheque.bo.Film;

import java.util.List;

public interface IFilmService {

    /**
     * Faire la liste de tous les films du catalogue
     * @return la liste de tous les films
     */
    List<Film> listFilms();

    /**
     * Consulter le détail d'un film
     * @param id id du film à modifier
     * @return les détails du film
     */
    Film getFilm(int id);

    /**
     * Ajouter un film au catalogue
     * @param film Film à ajouter
     */
    void addFilm(Film film);

    /**
     * Modifier film
     * @param id id du film à modifier
     * @param film Film modifié
     */
    void updateFilm(int id, Film film);

    /**
     * Supprimer un film
     * @param id id du film à modifier
     */
    void deleteFilm(int id);


    /**
     * Donner un avis et une note à un film
     * @param id id du film à noter
     * @param avis avis donné au film
     */
    void noterFilm(int id, Avis avis);

}
