package fr.pierreliaubet.au_clock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListeExercices extends AppCompatActivity {

    List<Exercice> lesExos = new ArrayList<>();

    TextView titre;
    TextView presentation;
    ImageView image;
    TextView duree;

    int affiche = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_exercices);


        titre = findViewById(R.id.titreExo);
        presentation = findViewById(R.id.descExo);
        image = findViewById(R.id.imgExo);
        duree = findViewById(R.id.dureeExo);

        Exercice exo1 = new Exercice();
        exo1.setTitre("Flash Sophro");
        exo1.setCondition("");
        exo1.setDuree("5 min");
        exo1.setPresenation("Exercice de Sophrologie court, pour correspondre rapidement à tout besoin");
        exo1.setImg(R.drawable.zenasia);

        Exercice exo2 = new Exercice();
        exo2.setTitre("Exercice long");
        exo2.setCondition("");
        exo2.setDuree("11 min");
        exo2.setPresenation("Exercice de Sophrologie complet pour toute situation");
        exo2.setImg(R.drawable.zencailloux);

        Exercice exo3 = new Exercice();
        exo3.setTitre("Libération sensations positives");
        exo3.setCondition("");
        exo3.setDuree("7 min");
        exo3.setPresenation("");
        exo3.setImg(R.drawable.zenlotus);

        Exercice exo4 = new Exercice();
        exo4.setTitre("Point d'encrage");
        exo4.setCondition("");
        exo4.setDuree("6 min");
        exo4.setPresenation("");
        exo4.setImg(R.drawable.zentemple);

        lesExos.add(exo1);
        lesExos.add(exo2);
        lesExos.add(exo3);
        lesExos.add(exo4);

        afficher(affiche);
    }

    private void afficher(int index){
        Exercice trucAafficher = lesExos.get(index);
        titre.setText(trucAafficher.getTitre());
        presentation.setText(trucAafficher.getPresenation());
        duree.setText(trucAafficher.getDuree());
        image.setImageResource(trucAafficher.getImg());
    }

    public void btnAvancer(View view){
        if (lesExos.size()-1 == affiche){

        }else{
            affiche += 1;
            afficher(affiche);
        }
    }

    public void btnReculer(View view){
        if (0 == affiche){

        }else{
            affiche -= 1;
            afficher(affiche);
        }
    }

    public void commencerExercice (View view){
        Intent player = new Intent(this, AndroidBuildingMusicPlayerActivity.class);
        player.putExtra("exo", lesExos.get(affiche));
        player.putExtra("index", affiche);
        startActivity(player);
    }
}
