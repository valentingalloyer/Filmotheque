package fr.eni.tpfilmotheque.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Membre {

    private int id;
    private String username;
    private String mail;
    private String password;
    private boolean admin;
    private List<Avis> listAvis;

    public Membre(int id, String username, String mail, String password, boolean admin) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.admin = admin;
    }

    public Membre(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username + " (" + mail + (isAdmin() ? ", admin" : "") + ")";
    }
}
