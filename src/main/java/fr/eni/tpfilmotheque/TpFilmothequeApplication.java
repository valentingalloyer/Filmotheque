package fr.eni.tpfilmotheque;

import fr.eni.tpfilmotheque.ihm.ConnectionController;
import fr.eni.tpfilmotheque.ihm.FilmController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TpFilmothequeApplication implements CommandLineRunner {

	@Autowired
	FilmController filmController;

	@Autowired
	ConnectionController connectionController;

	public static void main(String[] args) {
		SpringApplication.run(TpFilmothequeApplication.class, args);

	}

	@Override
	public void run(String... args) {
		int choix;
		do {
			System.out.println("Que voulez-vous faire ?\n" +
					"0: Quitter l'application :'(\n" +
					"1: Lister les films\n" +
					"2: Consulter un film\n" +
					"3: Se connecter\n" +
					"4: Se déconnecter\n" +
					"5: Ajouter un film\n" +
					"6: Modifier un film\n" +
					"7: Supprimer un film\n" +
					"8: Noter un film\n" +
					"9 : Consulter l'utilisateur connecté");
			Scanner scanner = new Scanner(System.in);
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					filmController.listFilms();
					break;
				case 2:
					filmController.getFilm();
					break;
				case 3:
					connectionController.seConnecter();
					break;
				case 4:
					connectionController.seDeconnecter();
					break;
				case 5:
					filmController.addFilm();
					break;
				case 6:
					System.out.println();
//					filmController.updateFilm();
					break;
				case 7:
					filmController.deleteFilm();
					break;
				case 8:
					filmController.noterFilm();
					break;
				case 9:
					connectionController.getUtilisateurConnecte();
					break;
				default:
					System.out.println("Choix incorrect");
			}
		} while (choix != 0);
	}
}
