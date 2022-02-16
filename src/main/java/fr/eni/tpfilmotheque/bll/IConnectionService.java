package fr.eni.tpfilmotheque.bll;

import fr.eni.tpfilmotheque.bo.Membre;

public interface IConnectionService {

    /**
     * Connecter l'utilisateur dans la config
     * @param membre utilisateur qui essaye de se connecter
     */
    void seConnecter(Membre membre);

    /**
     * Déconnecter l'utilisateur connecté
     */
    void seDeconnecter();

    /**
     * Obtenir les informations concernant l'utilisateur connecté
     * @return l'utilisateur connecté
     */
    Membre getMembreConnecte();
}
