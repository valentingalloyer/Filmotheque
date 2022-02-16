package fr.eni.tpfilmotheque.bll;

import fr.eni.tpfilmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ConnectionService")
public class ConnectionService implements IConnectionService {

    @Autowired
    List<Membre> listMembres;

    @Autowired
    Membre membreConnecte;

    public void seConnecter(Membre membre) {
        if (membreConnecte == null) {
            if (listMembres.stream().anyMatch(mb -> membre.getUsername().equals(mb.getUsername()) && membre.getPassword().equals(mb.getPassword()))) {
                membreConnecte = listMembres.stream().filter(mb -> membre.getUsername().equals(mb.getUsername()) && membre.getPassword().equals(mb.getPassword())).findFirst().get();
                System.out.println(membreConnecte + " est connecté !");

            } else {
                System.out.println("Aucun utilisateur trouvé pour ce username et password");
            }
        } else {
            System.out.println("Vous êtes déjà connecté");
        }
    }

    public void seDeconnecter() {
        if (membreConnecte == null) {
            System.out.println("Il n'y a pas d'utilisateur connecté !");
        } else {
            this.membreConnecte = null;
            System.out.println("Utilisateur déconnecté");
        }
    }

    @Override
    public Membre getMembreConnecte() {
        return this.membreConnecte;
    }


}
