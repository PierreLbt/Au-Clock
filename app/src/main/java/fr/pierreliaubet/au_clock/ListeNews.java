package fr.pierreliaubet.au_clock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListeNews extends AppCompatActivity {

    static ListeNews ln;

    List<News> lesNews = new ArrayList<>();
    ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_news);

        ln = this;

        News n1 = new News();
        n1.setPresentation("Conseil pour gérer la lumière dans votre chambre.");
        n1.setTitre("La luminosité");
        n1.setTexteComplet("Pour un meilleur sommeil, il est conseillé de dormir dans le noir complet. Coupez toutes les lumières et évitez toutes celles qui peuvent être parasite (par exemple un réveil à affichage digital). En plus de ça, nous vous recommendons d'avoir des murs sombres dans votre chambre pour être le plus dans le noir possible.");
        n1.setImg(R.drawable.soleil);

        News n2 = new News();
        n2.setPresentation("Informations sur la températures dans votre chambre.");
        n2.setTitre("La température");
        n2.setTexteComplet("Il est important de veiller à ce que cette dernière ne dépasse pas les 20°C. L'été, climatisez ou ventilez votre chambre avant d'aller dormir et assurez vous que l'air ne soit pas trop sec.");
        n2.setImg(R.drawable.temperature);

        News n3 = new News();
        n3.setPresentation("Quelle alimentation est recommandée avant d'aller se coucher ?");
        n3.setTitre("L'alimentation");
        n3.setTexteComplet("Les alimentations de type sucres rapides ainsi que le lait chaud favorisent l'endormissement.\nNous vous recommendons de ne pas trop manger le soir pour avoir un sommeil de meilleure qualité.");
        n3.setImg(R.drawable.manger);

        News n4 = new News();
        n4.setPresentation("Que peut-on dire des animaux dans la chambre ?");
        n4.setTitre("Les animaux");
        n4.setTexteComplet("Votre animal de compagnie peut être une source de mico-réveil. Aménagez lui un endroit pour qu'il ait son propre lit.\nLes poils n'animaux peuvent être source d'allergie, évitez les si vous y êtes sujet.");
        n4.setImg(R.drawable.chat);

        News n5 = new News();
        n5.setPresentation("News : Le manque de sommeil.");
        n5.setTitre("Le manque de sommeil");
        n5.setTexteComplet("La dette de sommeil a un impact direct sur notre quotidien comme le manque de performance et les difficultés de concentration.\nA long terme, des risques plus important sont à venir comme le surpoids et des risques cardio vasculaire.");
        n5.setImg(R.drawable.info);

        lesNews.add(n1);
        lesNews.add(n2);
        lesNews.add(n3);
        lesNews.add(n4);
        lesNews.add(n5);

        liste = findViewById(R.id.listNews);
        List<Map<String, String>> map = new ArrayList<>();

        for (News n : lesNews){
            Map<String, String> ajout = new HashMap<>();
            ajout.put("premiere", n.getTitre());
            ajout.put("seconde", n.getPresentation());
            map.add(ajout);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, map ,
                android.R.layout.simple_list_item_2,
                new String[] {"premiere", "seconde" },
                new int[] {android.R.id.text1, android.R.id.text2 });
        liste.setAdapter(adapter);


        liste.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListeNews.ln, DetailsNews.class);
                intent.putExtra("new", lesNews.get(position));
                startActivity(intent);
            }


        });

    }
}
