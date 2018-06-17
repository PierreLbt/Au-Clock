package fr.pierreliaubet.au_clock;

import java.io.Serializable;

public class Exercice implements Serializable{
    String titre;
    String presenation;
    String condition;
    String duree;
    String fichier;
    String img;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPresenation() {
        return presenation;
    }

    public void setPresenation(String presenation) {
        this.presenation = presenation;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
