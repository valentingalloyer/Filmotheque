package fr.eni.tpfilmotheque.ihm;

import fr.eni.tpfilmotheque.bll.ConnectionService;
import fr.eni.tpfilmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ConnectionController {

    @Autowired
    ConnectionService connectionService;

    public void seConnecter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Username");
        String username = scanner.nextLine();

        System.out.println("Password");
        String password = scanner.nextLine();

        Membre membre = new Membre(username, password);

        this.connectionService.seConnecter(membre);
    }


    public void seDeconnecter() {
        this.connectionService.seDeconnecter();
    }

    public void getUtilisateurConnecte() {
        System.out.println(this.connectionService.getMembreConnecte());
    }

}
