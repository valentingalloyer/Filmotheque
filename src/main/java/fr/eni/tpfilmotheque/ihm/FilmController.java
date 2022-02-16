package fr.eni.tpfilmotheque.ihm;

import fr.eni.tpfilmotheque.bll.IFilmService;
import fr.eni.tpfilmotheque.bo.Avis;
import fr.eni.tpfilmotheque.bo.Film;
import fr.eni.tpfilmotheque.bo.Genre;
import fr.eni.tpfilmotheque.bo.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class FilmController {

    @Autowired
    IFilmService filmService;

    public void listFilms() {
        for (Film film: filmService.listFilms()) {
            System.out.println(film.getId() + "- " + film.getTitre());
        }
    }

    public Film getFilmById(int id) {
        return filmService.getFilm(id);
    }

    public void getFilm() {
        System.out.println("Quel film ?");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Film film = this.filmService.getFilm(id);
        System.out.println(
                film.getTitre() + ", "
                + film.getSynopsis() + ","
                + " sorti en " + film.getAnnee() + ","
                + " réalisé par " + film.getRealisateur() + ","
                + " liste des acteurs : "
        );
        for (Personne acteur: film.getActeurs()) {
            System.out.println(acteur);
        }
        System.out.println(film.getGenre());
        for (Avis avis: film.getListAvis()) {
            System.out.println(avis);
        }
    }

    public void addFilm() {
        // Titre
        System.out.println("Titre :");
        Scanner scanner = new Scanner(System.in);
        String titre = scanner.nextLine();

        // Réalisateur
        System.out.println("Réalisateur :");
        System.out.println("Prénom :");
        String prenomRealisateur = scanner.nextLine();
        System.out.println("Nom :");
        String nomRealisateur = scanner.nextLine();
        Personne realisateur = new Personne(nomRealisateur, prenomRealisateur);

        // Durée
        System.out.println("Durée :");
        int duree = scanner.nextInt();

        // Année de sortie
        System.out.println("Année de sortie :");
        int anneeSortie = scanner.nextInt();

        // Synopsis
        System.out.println("Synopsis :");
        String synopsis = scanner.nextLine();

        // Acteurs
        List<Personne> acteurs = new ArrayList<>();
        String reponse;
        do {
            System.out.println("Ajouter des acteurs ? O/N");
            reponse = scanner.nextLine();
            if (reponse.equals("O") || reponse.equals("o")) {
                System.out.println("Prénom :");
                String prenomActeur = scanner.nextLine();

                System.out.println("Nom :");
                String nomActeur = scanner.nextLine();

                acteurs.add(new Personne(nomActeur, prenomActeur));
            }
        } while (reponse.equals("O") || reponse.equals("o"));

        // Genre
        Genre genre = new Genre("Horreur");

        Film film = new Film(titre, anneeSortie, duree, synopsis, realisateur, acteurs, genre);
        this.filmService.addFilm(film);
        System.out.println("Le film a été ajouté");
    }

    public void deleteFilm() {
        System.out.println("Quel id ?");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        this.filmService.deleteFilm(id);
        System.out.println("Le film a été supprimé");
    }

    public void noterFilm() {
        System.out.println("Quel id ?");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        System.out.println("Vous allez noter le film " + getFilmById(id).getTitre());

        System.out.println("Quelle note ?");
        int note = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Dites m'en plus");
        String libelle = scanner.nextLine();

        Avis avis = new Avis(note, libelle, getFilmById(id));

        this.filmService.noterFilm(id, avis);
    }
}
