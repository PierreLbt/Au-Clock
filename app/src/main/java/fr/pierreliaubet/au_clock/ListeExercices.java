package fr.pierreliaubet.au_clock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListeExercices extends AppCompatActivity {

    List<Exercice> lesExos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_exercices);


        Exercice exo1 = new Exercice();
        exo1.setTitre("Flash sophro");
        exo1.setCondition("");
        exo1.setDuree("5 min");
        exo1.setFichier("");
        exo1.setPresenation("");

        Exercice exo2 = new Exercice();
        exo2.setTitre("Flash sophro");
        exo2.setCondition("");
        exo2.setDuree("");
        exo2.setFichier("");
        exo2.setPresenation("");

        Exercice exo3 = new Exercice();
        exo3.setTitre("Flash sophro");
        exo3.setCondition("");
        exo3.setDuree("");
        exo3.setFichier("");
        exo3.setPresenation("");

        Exercice exo4 = new Exercice();
        exo4.setTitre("Flash sophro");
        exo4.setCondition("");
        exo4.setDuree("");
        exo4.setFichier("");
        exo4.setPresenation("");

        lesExos.add(exo1);
        lesExos.add(exo2);
        lesExos.add(exo3);
        lesExos.add(exo4);
    }
}
