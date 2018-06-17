package fr.pierreliaubet.au_clock;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private String dateNaissance;
    private String nombreHeuresSommeil;
    private String heureReveil;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNombreHeuresSommeil() {
        return nombreHeuresSommeil;
    }

    public void setNombreHeuresSommeil(String nombreHeuresSommeil) {
        this.nombreHeuresSommeil = nombreHeuresSommeil;
    }

    public String getHeureReveil() {
        return heureReveil;
    }

    public void setHeureReveil(String heureReveil) {
        this.heureReveil = heureReveil;
    }
}