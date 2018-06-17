package fr.pierreliaubet.au_clock;

import java.io.Serializable;

public class News implements Serializable{
    String titre;
    String presentation;
    String texteComplet;
    String img;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getTexteComplet() {
        return texteComplet;
    }

    public void setTexteComplet(String texteComplet) {
        this.texteComplet = texteComplet;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
