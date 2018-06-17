package fr.pierreliaubet.au_clock;

import java.io.Serializable;

public class News implements Serializable{
    String titre;
    String presentation;
    String texteComplet;
    int img;

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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


}
